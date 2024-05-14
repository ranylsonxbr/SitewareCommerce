package br.com.siteware.app.Carrinho.application.api;

import br.com.siteware.app.ProdutoCarrinho.ProdutoCarrinho;
import lombok.Data;
import lombok.Value;

import java.util.List;

@Data
public class CarrinhoRequest {

    private List<ProdutoCarrinho> produtos;

}
