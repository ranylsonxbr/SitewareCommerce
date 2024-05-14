package br.com.siteware.app.Carrinho.repository;

import br.com.siteware.app.Carrinho.domain.Carrinho;

import java.util.Optional;

public interface CarrinhoRepository {

    Carrinho salvaCarrinho(Carrinho carrinho);

    Carrinho buscaCarrinhoPorId(Long idCarrinho);

}
