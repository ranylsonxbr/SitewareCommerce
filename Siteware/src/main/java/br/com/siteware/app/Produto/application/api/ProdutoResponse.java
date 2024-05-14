package br.com.siteware.app.Produto.application.api;


import br.com.siteware.app.Produto.domain.Produto;
import lombok.Value;


@Value
public class ProdutoResponse {

    private Long idProduto;

    public ProdutoResponse(Produto novoProduto) {
        this.idProduto = novoProduto.getIdProduto();

    }


}
