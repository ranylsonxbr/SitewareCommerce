package br.com.siteware.app.Produto.application.api;


import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/v1/produto")
public interface ProdutoAPI {

    @PostMapping(value = "/cria-produto")
    @ResponseStatus(value = HttpStatus.CREATED)
    ProdutoResponse postProduto(@RequestBody ProdutoRequest produtoRequest);

    @GetMapping(value = "/busca-todos-produtos")
    @ResponseStatus(value = HttpStatus.OK)
    List<ProdutoListResponse> getTodosProdutos();
    @GetMapping(value = "/{idProduto}")
    @ResponseStatus(value = HttpStatus.OK)
    ProdutoDetalhadoResponse getBuscaProdutoPorId(@PathVariable(value = "idProduto") Long idProduto);

    @DeleteMapping(value = "/{idProduto}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void deletaProdutoPorId (@PathVariable Long idProduto);

    @PatchMapping(value = "/{idProduto}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void patchAlteraProduto(@PathVariable Long idProduto,@Valid @RequestBody ProdutoAlteracaoRequest produtoAlteracaoRequest);

}
