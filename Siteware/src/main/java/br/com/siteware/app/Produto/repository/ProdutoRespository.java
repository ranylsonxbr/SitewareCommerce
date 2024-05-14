package br.com.siteware.app.Produto.repository;


import br.com.siteware.app.Produto.domain.Produto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProdutoRespository {

    Produto buscaProdutoPorID(Long idProduto);

    List<Produto> buscaTodosProdutos();

    void deletaProduto(Produto produto);

    Produto salvaProduto(Produto produto);

    Optional<Produto> consultaProdutoOptionalAtravesId(Long idProduto);
}
