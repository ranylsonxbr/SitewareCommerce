package br.com.siteware.app.ProdutoCarrinho;

import br.com.siteware.app.Carrinho.application.api.ProdutoCarrinhoRequest;
import br.com.siteware.app.Carrinho.domain.Carrinho;
import br.com.siteware.app.Produto.domain.Produto;
import br.com.siteware.app.Produto.domain.Promocoes;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Entity
@Table(name = "tb_produto_carrinho")
@Getter
@NoArgsConstructor
public class ProdutoCarrinho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProdutoCarrinho;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "carrinho_id", nullable = false)
    private Carrinho carrinho;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "produto_id", nullable = false)
    private Produto produto;

    private String nome;
    private Promocoes promocao;
    private BigDecimal quantidade;
    private BigDecimal precoUnitario;
    private BigDecimal precoTotalBruto;

    public ProdutoCarrinho(Produto produto, ProdutoCarrinhoRequest produtoCarrinhoRequest, Carrinho carrinho) {
        this.nome = produto.getNome();
        this.carrinho = carrinho;
        this.produto = produto;
        this.precoUnitario = produto.getPreco();
        this.quantidade = produtoCarrinhoRequest.getQuantidade();
        this.promocao = produto.getPromocoes();
        this.calculaPrecoTotalBruto();

    }

    private void calculaPrecoTotalBruto() {
        this.precoTotalBruto = this.precoUnitario.multiply(this.quantidade);
    }

}