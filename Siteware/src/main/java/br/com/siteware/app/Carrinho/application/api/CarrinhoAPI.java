package br.com.siteware.app.Carrinho.application.api;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/v1/carrinho")
public interface CarrinhoAPI {

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    CarrinhoResponse criaCarrinho(@RequestBody @Valid CarrinhoRequest carrinhoRequest);

    @PostMapping(path = "/{idCarrinho}/produto")
    @ResponseStatus(code = HttpStatus.CREATED)
    void adicionaItemAoCarrinho(@PathVariable Long idCarrinho, @RequestBody ProdutoCarrinhoRequest produtoCarrinhoRequest);

    @GetMapping(path = "/{idCarrinho}/produto")
    @ResponseStatus(code = HttpStatus.OK)
    CarrinhoResponse consultaCarrinho(@PathVariable Long idCarrinho);

    @PatchMapping(path = "/{idCarrinho}/produto/{idProdutoCarrinho}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void alteraProdutosDoCarrinho(@PathVariable Long idCarrinho, @RequestBody  ProdutoCarrinhoRequest produtoCarrinhoRequest);


    @PatchMapping(path = "/{idCarrinho}/produto/remove/{idProduto}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void removeProdutoDoCarrinho(@PathVariable Long idCarrinho, @PathVariable  Long idProduto);

}