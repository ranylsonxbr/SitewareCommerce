package br.com.siteware.app.Carrinho.application.service;

import br.com.siteware.app.Carrinho.application.api.CarrinhoRequest;
import br.com.siteware.app.Carrinho.application.api.CarrinhoResponse;
import br.com.siteware.app.Carrinho.application.api.ProdutoCarrinhoRequest;

public interface CarrinhoService {

    CarrinhoResponse criaCarrinho(CarrinhoRequest carrinhoRequest);

    void adicionaItemAoCarrinho(Long idCarrinho, ProdutoCarrinhoRequest produtoCarrinhoRequest);

    CarrinhoResponse consultarItensDoCarrinho(Long idCarrinho);

    void alteraProdutosDoCarrinho(Long idCarrinho, ProdutoCarrinhoRequest produtoCarrinhoRequest);

    void removeProduto(Long idCarrinho, Long idProduto);
}
