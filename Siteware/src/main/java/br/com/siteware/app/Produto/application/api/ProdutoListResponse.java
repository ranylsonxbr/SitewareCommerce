package br.com.siteware.app.Produto.application.api;


import br.com.siteware.app.Produto.domain.Produto;
import br.com.siteware.app.Produto.domain.Promocoes;
import lombok.Value;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Value
public class ProdutoListResponse {
    private Long idProduto;
    private String nome;
    private BigDecimal preco;
    private Promocoes Promocoes;

    public ProdutoListResponse(Produto produto) {
        this.idProduto = produto.getIdProduto();
        this.nome = produto.getNome();
        this.preco = produto.getPreco();
        this.Promocoes = produto.getPromocoes();
    }

    public static List<ProdutoListResponse> converteListaProdutos(List<Produto> produtos){
        return produtos.stream().map(ProdutoListResponse::new).collect(Collectors.toList());
    }
}
