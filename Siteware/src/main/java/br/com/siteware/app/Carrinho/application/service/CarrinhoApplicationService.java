package br.com.siteware.app.Carrinho.application.service;

import br.com.siteware.app.Carrinho.application.api.CarrinhoRequest;
import br.com.siteware.app.Carrinho.application.api.CarrinhoResponse;
import br.com.siteware.app.Carrinho.application.api.ProdutoCarrinhoRequest;
import br.com.siteware.app.Carrinho.domain.Carrinho;
import br.com.siteware.app.Carrinho.repository.CarrinhoRepository;
import br.com.siteware.app.Produto.repository.ProdutoRespository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Log4j2
@RequiredArgsConstructor
public class CarrinhoApplicationService implements CarrinhoService {

    private final CarrinhoRepository carrinhoRepository;
    private final ProdutoRespository produtoRepository;

    @Override
    public CarrinhoResponse criaCarrinho(CarrinhoRequest carrinhoRequest) {
        log.info("[start] CarrinhoApplicationService - criaCarrinho");
        Carrinho carrinho = new Carrinho(carrinhoRequest);
        carrinhoRepository.salvaCarrinho(carrinho);
        log.info("[finish] CarrinhoApplicationService - criaCarrinho");
        return new CarrinhoResponse(carrinho);
    }

    @Override
    public void adicionaItemAoCarrinho(Long idCarrinho, ProdutoCarrinhoRequest produtoCarrinhoRequest) {
        log.info("[start] CarrinhoApplicationService - adicionaItemAoCarrinho");
        var carrinhoDeCompras = carrinhoRepository.buscaCarrinhoPorId(idCarrinho);
        carrinhoDeCompras.adicionaProduto(produtoCarrinhoRequest, produtoRepository);
        carrinhoRepository.salvaCarrinho(carrinhoDeCompras);
        log.info("[finish] CarrinhoApplicationService - adicionaItemAoCarrinho");
    }

    @Override
    public CarrinhoResponse consultarItensDoCarrinho(Long idCarrinho) {
        log.info("[start] CarrinhoApplicationService - consultarItensDoCarrinho");
        Carrinho carrinho = carrinhoRepository.buscaCarrinhoPorId(idCarrinho);
        log.info("[finish] CarrinhoApplicationService - consultarItensDoCarrinho");
        return new CarrinhoResponse(carrinho);
    }

    @Override
    public void alteraProdutosDoCarrinho(Long idCarrinho, ProdutoCarrinhoRequest produtoCarrinhoRequest) {
        log.info("[start] CarrinhoApplicationService - alteraProdutosDoCarrinho");
        Carrinho carrinho = carrinhoRepository.buscaCarrinhoPorId(idCarrinho);
        carrinho.alteraItem(produtoCarrinhoRequest, produtoRepository);
        carrinhoRepository.salvaCarrinho(carrinho);
        log.info("[finish] CarrinhoApplicationService - alteraProdutosDoCarrinho");
    }

    @Override
    public void removeProduto(Long idCarrinho, Long idProduto) {
        log.info("[start] CarrinhoApplicationService - removeProduto");
        Carrinho carrinho = carrinhoRepository.buscaCarrinhoPorId(idCarrinho);
        carrinho.removeProduto(idProduto);
        carrinhoRepository.salvaCarrinho(carrinho);
        log.info("[finish] CarrinhoApplicationService - removeProduto");
    }
}
