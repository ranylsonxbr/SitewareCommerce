package br.com.siteware.app.Produto.application.api;


import br.com.siteware.app.Produto.application.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Log4j2
@RequiredArgsConstructor
public class ProdutoController implements ProdutoAPI {

    private final ProdutoService produtoService;

    @Override
    public ProdutoResponse postProduto(ProdutoRequest produtoRequest) {
        log.info("[start] ProdutoController - postProduto");
        ProdutoResponse novoProduto = produtoService.criaProduto(produtoRequest);
        log.info("[finish] ProdutoController - postProduto");
        return novoProduto;
    }

    @Override
    public List<ProdutoListResponse> getTodosProdutos() {
        log.info("[start] ProdutoController - getTodosClientes");
        List<ProdutoListResponse> produtos = produtoService.buscaTodosProdutos();
        log.info("[finish] ProdutoController - getTodosClientes");
        return produtos;
    }

    @Override
    public ProdutoDetalhadoResponse getBuscaProdutoPorId(Long idProduto) {
        log.info("[start] ProdutoController - getBuscaProdutoPorId");
        log.info("[idProduto] {}", idProduto);
        ProdutoDetalhadoResponse produtoDetalhado = produtoService.buscaProdutoPorID(idProduto);
        log.info("[finish] ProdutoController - getBuscaProdutoPorId");
        return produtoDetalhado;
    }

    @Override
    public void deletaProdutoPorId(Long idProduto) {
        log.info("[start] ProdutoController - deletaProdutoPorId");
        log.info("[idProduto] {}", idProduto);
        produtoService.deletaProdutoPorID(idProduto);
        log.info("[finish] ProdutoController - deletaProdutoPorId");
    }

    @Override
    public void patchAlteraProduto(Long idProduto, ProdutoAlteracaoRequest produtoAlteracaoRequest) {
        log.info("[start] ProdutoController - patchAlteraProduto");
        log.info("[idProduto] {}", idProduto);
        produtoService.patchAlteraProduto(idProduto,produtoAlteracaoRequest);
        log.info("[finish] ProdutoController - patchAlteraProduto");
    }
}
