package br.com.siteware.app.Carrinho.domain;

import br.com.siteware.app.Carrinho.application.api.CarrinhoRequest;
import br.com.siteware.app.Carrinho.application.api.ProdutoCarrinhoRequest;
import br.com.siteware.app.Handler.APIException;
import br.com.siteware.app.Produto.domain.Produto;
import br.com.siteware.app.Produto.repository.ProdutoRespository;
import br.com.siteware.app.ProdutoCarrinho.ProdutoCarrinho;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.*;

@Entity
@Table(name = "tb_carrinho")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Carrinho implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "carrinho", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProdutoCarrinho> produtos ;

    private LocalDateTime dataHoraAbertura;
    private LocalDateTime dataHoraDaUltimaAlteracao;

    public Carrinho(CarrinhoRequest carrinhoRequest) {
        this.produtos = new ArrayList<>();
        this.dataHoraAbertura = LocalDateTime.now();
    }

    public void adicionaProdutos(List<ProdutoCarrinhoRequest> produtos, ProdutoRespository produtoRepository) {
        produtos.parallelStream().forEach(i -> adicionaProduto(i, produtoRepository));
    }

    public void adicionaProduto(ProdutoCarrinhoRequest produtoCarrinhoReq, ProdutoRespository produtoRepository) {
        var optionalProduto = produtoRepository.consultaProdutoOptionalAtravesId(produtoCarrinhoReq.getIdProduto());
        optionalProduto.ifPresent(p -> {
            ProdutoCarrinho produto = new ProdutoCarrinho(p, produtoCarrinhoReq, this);
            this.produtos.add(produto);
            this.dataHoraDaUltimaAlteracao = LocalDateTime.now();
        });
    }

    public void removeProduto(Long idProduto) {
        produtos.removeIf(p -> p.getProduto().getIdProduto().equals(idProduto));
    }

    private Boolean itemJaExisteNoCarrinho(ProdutoCarrinhoRequest produtoCarrinhoRequest) {
        return this.produtos.stream().anyMatch(i -> i.getProduto().getIdProduto().equals(produtoCarrinhoRequest.getIdProduto()));
    }

    public void alteraItem(ProdutoCarrinhoRequest produtoCarrinhoRequest, ProdutoRespository produtoRepository) {
        if (itemJaExisteNoCarrinho(produtoCarrinhoRequest)) {
            removeProduto(produtoCarrinhoRequest.getIdProduto());
            adicionaProduto(produtoCarrinhoRequest, produtoRepository);
        } else {
            throw APIException.build(HttpStatus.BAD_REQUEST, "Não existe esse produto no carrinho");
        }
    }
}