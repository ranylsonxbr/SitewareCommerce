package br.com.siteware.app.Carrinho.application.api;


import br.com.siteware.app.Carrinho.domain.Carrinho;
import br.com.siteware.app.ProdutoCarrinho.ProdutoCarrinho;
import lombok.Value;

import java.math.BigDecimal;
import java.util.List;


@Value
public class CarrinhoResponse {
    private Long idCarrinho;
    private BigDecimal valorTotalLiquido;
    private List<ProdutoCarrinhoResponse> itens;

    public CarrinhoResponse(Carrinho carrinho) {
        this.idCarrinho = carrinho.getId();
        this.itens = ProdutoCarrinhoResponse.converte(carrinho.getProdutos());
        this.valorTotalLiquido = ProdutoCarrinhoResponse.calculaValorTotalLiquido(this.itens);
    }
}
