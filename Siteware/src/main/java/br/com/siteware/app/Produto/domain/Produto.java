package br.com.siteware.app.Produto.domain;

import br.com.siteware.app.Produto.application.api.ProdutoAlteracaoRequest;
import br.com.siteware.app.Produto.application.api.ProdutoRequest;
import br.com.siteware.app.ProdutoCarrinho.ProdutoCarrinho;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@Table(name = "Produto")
public class Produto implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduto;
    private String nome;
    private BigDecimal preco;
    private Promocoes promocoes;
    @OneToMany(mappedBy = "produto")
    private List<ProdutoCarrinho> produtoCarrinho = new ArrayList<>();


    public Produto(ProdutoRequest produtoRequest) {
        this.nome = produtoRequest.getNome();
        this.preco = produtoRequest.getPreco();
        this.promocoes = produtoRequest.getPromocoes();
    }

    public void altera(ProdutoAlteracaoRequest produtoAlteracaoRequest) {
        this.nome = produtoAlteracaoRequest.getNome();
        this.preco = produtoAlteracaoRequest.getPreco();
        this.promocoes = produtoAlteracaoRequest.getPromocoes();
    }

}