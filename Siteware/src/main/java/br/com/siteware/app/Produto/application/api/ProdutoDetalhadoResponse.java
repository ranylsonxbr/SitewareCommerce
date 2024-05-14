package br.com.siteware.app.Produto.application.api;


import br.com.siteware.app.Produto.domain.Produto;
import br.com.siteware.app.Produto.domain.Promocoes;
import lombok.Value;

import java.math.BigDecimal;

@Value
public class ProdutoDetalhadoResponse {
    private Long idProduto;
    private String nome;
    private BigDecimal preco;
    private Promocoes Promocoes;

    public ProdutoDetalhadoResponse(Produto produto) {
        this.idProduto = produto.getIdProduto();
        this.nome = produto.getNome();
        this.preco = produto.getPreco();
        this.Promocoes = produto.getPromocoes();
    }

}
