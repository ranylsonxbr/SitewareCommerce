package br.com.siteware.app.Produto.application.service;


import br.com.siteware.app.Produto.application.api.*;

import java.util.List;

public interface ProdutoService {
    ProdutoResponse criaProduto(ProdutoRequest produtoRequest);

    ProdutoDetalhadoResponse buscaProdutoPorID(Long idProduto);

    List<ProdutoListResponse> buscaTodosProdutos();

    void deletaProdutoPorID(Long idProduto);

    void patchAlteraProduto(Long idProduto, ProdutoAlteracaoRequest produtoAlteracaoRequest);
}
