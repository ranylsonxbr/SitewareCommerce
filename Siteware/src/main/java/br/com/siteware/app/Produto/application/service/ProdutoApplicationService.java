package br.com.siteware.app.Produto.application.service;


import br.com.siteware.app.Produto.application.api.*;
import br.com.siteware.app.Produto.domain.Produto;
import br.com.siteware.app.Produto.repository.ProdutoRespository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
@RequiredArgsConstructor
public class ProdutoApplicationService implements ProdutoService {

    private final ProdutoRespository produtoRepository;

    @Override
    public ProdutoResponse criaProduto(ProdutoRequest produtoRequest) {
        log.info("[start] ProdutoApplicationService - criaProduto");
        Produto novoProduto = produtoRepository.salvaProduto(new Produto(produtoRequest));
        log.info("[finish] ProdutoApplicationService - criaProduto");
        return new ProdutoResponse(novoProduto);
    }

    @Override
    public ProdutoDetalhadoResponse buscaProdutoPorID(Long idProduto) {
        log.info("[start] ProdutoApplicationService - buscaProdutoPorID");
        Produto produto = produtoRepository.buscaProdutoPorID(idProduto);
        log.info("[finish] ProdutoApplicationService - buscaProdutoPorID");
        return new ProdutoDetalhadoResponse(produto);
    }

    @Override
    public List<ProdutoListResponse> buscaTodosProdutos() {
        log.info("[start] ProdutoApplicationService - buscaTodosProdutos");
        List<Produto> produtos = produtoRepository.buscaTodosProdutos();
        log.info("[finish] ProdutoApplicationService - buscaTodosProdutos");
        return ProdutoListResponse.converteListaProdutos(produtos);
    }

    @Override
    public void deletaProdutoPorID(Long idProduto) {
        log.info("[start] ProdutoApplicationService - deletaProdutoPorID");
        Produto produto = produtoRepository.buscaProdutoPorID(idProduto);
        produtoRepository.deletaProduto(produto);
        log.info("[finish] ProdutoApplicationService - deletaProdutoPorID");
    }

    @Override
    public void patchAlteraProduto(Long idProduto, ProdutoAlteracaoRequest produtoAlteracaoRequest) {
        log.info("[start] ProdutoApplicationService - patchAlteraProduto");
        Produto produto = produtoRepository.buscaProdutoPorID(idProduto);
        produto.altera(produtoAlteracaoRequest);
        produtoRepository.salvaProduto(produto);
        log.info("[finish] ProdutoApplicationService - patchAlteraProduto");
    }
}
