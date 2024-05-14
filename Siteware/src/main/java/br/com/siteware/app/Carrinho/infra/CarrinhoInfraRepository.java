package br.com.siteware.app.Carrinho.infra;

import br.com.siteware.app.Carrinho.domain.Carrinho;
import br.com.siteware.app.Carrinho.repository.CarrinhoRepository;
import br.com.siteware.app.Handler.APIException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Log4j2
@RequiredArgsConstructor
public class CarrinhoInfraRepository implements CarrinhoRepository {

    private final CarrinhoSpringDataJPA carrinhoSpringDataJPA;

    @Override
    public Carrinho salvaCarrinho(Carrinho carrinho) {
        log.info("[start] CarrinhoInfraRepository - salvaCarrinho");
        carrinhoSpringDataJPA.save(carrinho);
        log.info("[finish] CarrinhoInfraRepository - salvaCarrinho");
        return carrinho;
    }

    @Override
    public Carrinho buscaCarrinhoPorId(Long idCarrinho) {
        log.info("[start] CarrinhoInfraRepository - buscaCarrinhoPorId");
        Carrinho carrinho = carrinhoSpringDataJPA.findById(idCarrinho)
                .orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Carrinho não encontrado"));
        log.info("[finish] CarrinhoInfraRepository - buscaCarrinhoPorId");
        return carrinho;
    }

}
