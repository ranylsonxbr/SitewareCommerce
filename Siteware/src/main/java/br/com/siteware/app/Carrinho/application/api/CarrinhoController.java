package br.com.siteware.app.Carrinho.application.api;

import br.com.siteware.app.Carrinho.application.service.CarrinhoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequiredArgsConstructor
public class CarrinhoController implements CarrinhoAPI {

    private final CarrinhoService carrinhoService;

    @Override
    public CarrinhoResponse criaCarrinho(CarrinhoRequest carrinhoRequest) {
        log.info("[start] CarrinhoController - criaCarrinho");
        CarrinhoResponse carrinhoResponse = carrinhoService.criaCarrinho(carrinhoRequest);
        log.info("[finish] CarrinhoController - criaCarrinho");
        return carrinhoResponse;
    }

    @Override
    public void adicionaItemAoCarrinho(Long idCarrinho, ProdutoCarrinhoRequest produtoCarrinhoRequest) {
        log.info("[start] CarrinhoController - adicionaItemAoCarrinho");
        carrinhoService.adicionaItemAoCarrinho(idCarrinho, produtoCarrinhoRequest);
        log.info("[finish] CarrinhoController - adicionaItemAoCarrinho");
    }

    @Override
    public CarrinhoResponse consultaCarrinho(Long idCarrinho) {
        log.info("[start] CarrinhoController - consultaCarrinho");
        log.info("[idCarrinho] {}", idCarrinho);
        CarrinhoResponse carrinhoResponse = carrinhoService.consultarItensDoCarrinho(idCarrinho);
        log.info("[finish] CarrinhoController - consultaCarrinho");
        return carrinhoResponse;
    }

    @Override
    public void alteraProdutosDoCarrinho(Long idCarrinho, ProdutoCarrinhoRequest produtoCarrinhoRequest) {
        log.info("[start] CarrinhoController - alteraProdutosDoCarrinho");
        log.info("[idCarrinho] {}", idCarrinho);
        carrinhoService.alteraProdutosDoCarrinho(idCarrinho, produtoCarrinhoRequest);
        log.info("[finish] CarrinhoController - alteraProdutosDoCarrinho");

    }

    @Override
    public void removeProdutoDoCarrinho(Long idCarrinho, Long idProduto) {
        log.info("[start] CarrinhoController - removeProdutosDoCarrinho");
        log.info("[idCarrinho] {}", idCarrinho);
        carrinhoService.removeProduto(idCarrinho,idProduto);
        log.info("[finish] CarrinhoController - removeProdutosDoCarrinho");
    }


}
