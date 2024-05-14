package br.com.siteware.app.Carrinho.application.api;

import br.com.siteware.app.Produto.domain.Promocoes;
import br.com.siteware.app.ProdutoCarrinho.ProdutoCarrinho;
import lombok.Value;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Value
public class ProdutoCarrinhoResponse {
    private Long idProduto;
    private String nomeProduto;
    private BigDecimal quantidade;
    private BigDecimal precoUnitario;
    private Promocoes promocao;
    private BigDecimal precoTotalBruto;

    public static List<ProdutoCarrinhoResponse> converte(List<ProdutoCarrinho> tarefaList) {
        return tarefaList.stream().map(ProdutoCarrinhoResponse::new).collect(Collectors.toList());
    }

    public ProdutoCarrinhoResponse(ProdutoCarrinho produtoCarrinho) {
        this.idProduto = produtoCarrinho.getProduto().getIdProduto();
        this.nomeProduto = produtoCarrinho.getNome();
        this.quantidade = produtoCarrinho.getQuantidade();
        this.precoUnitario = produtoCarrinho.getPrecoUnitario();
        this.promocao = produtoCarrinho.getPromocao();
        this.precoTotalBruto = produtoCarrinho.getPrecoTotalBruto();

    }

    public static BigDecimal calculaValorComPromocao(ProdutoCarrinhoResponse produtoCarrinho) {
        BigDecimal valorTotalLiquido = BigDecimal.ZERO;
        switch (produtoCarrinho.getPromocao().getCode()) {
            case 1:
                valorTotalLiquido = calculaLeve2Pague1(produtoCarrinho);
                break;
            case 2:
                valorTotalLiquido = calculaLeve3Pague10(produtoCarrinho);
                break;
            default:
                valorTotalLiquido = produtoCarrinho.getPrecoUnitario().multiply(produtoCarrinho.getQuantidade());
                break;
        }
        return valorTotalLiquido;
    }

    @NotNull
    private static BigDecimal calculaLeve3Pague10(ProdutoCarrinhoResponse produtoCarrinho) {
        int divisaoPorTres = produtoCarrinho.getQuantidade().intValue() / 3;
        int resto = produtoCarrinho.getQuantidade().intValue() % 3;

        BigDecimal precoPromocional = new BigDecimal(10);

        return precoPromocional.multiply(new BigDecimal(divisaoPorTres))
                .add(produtoCarrinho.getPrecoUnitario().multiply(new BigDecimal(resto)));
    }

    @NotNull
    private static BigDecimal calculaLeve2Pague1(ProdutoCarrinhoResponse produtoCarrinho) {
        BigDecimal valorTotalLiquido;
        int divisaoPorDois = produtoCarrinho.getQuantidade().intValue() / 2;
        int sobra = produtoCarrinho.getQuantidade().intValue() % 2;
        valorTotalLiquido = produtoCarrinho.getPrecoUnitario().multiply(new BigDecimal(divisaoPorDois))
                .add(produtoCarrinho.getPrecoUnitario().multiply(new BigDecimal(sobra)));
        return valorTotalLiquido;
    }

    public static BigDecimal calculaValorTotalLiquido(List<ProdutoCarrinhoResponse> produtoCarrinhoList) {
        BigDecimal valorTotalLiquido = BigDecimal.ZERO;
        for (ProdutoCarrinhoResponse produtoCarrinho : produtoCarrinhoList) {
            valorTotalLiquido = valorTotalLiquido.add(calculaValorComPromocao(produtoCarrinho));
        }
        return valorTotalLiquido;
    }

}