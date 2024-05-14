package br.com.siteware.app.Produto.infra;


import br.com.siteware.app.Handler.APIException;
import br.com.siteware.app.Produto.domain.Produto;
import br.com.siteware.app.Produto.repository.ProdutoRespository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@Log4j2
@RequiredArgsConstructor
public class ProdutoInfraRespository implements ProdutoRespository {


    private final ProdutoSpringDataJPARepository produtoSpringDataJPARepository;

    @Override
    public Produto salvaProduto(Produto produto) {
        log.info("[start] ProdutoInfraRespository - salvaProduto");
        produtoSpringDataJPARepository.save(produto);
        log.info("[finish] ProdutoInfraRespository - salvaProduto");
        return produto;
    }

    @Override
    public Optional<Produto> consultaProdutoOptionalAtravesId(Long idProduto) {
        Produto produto = produtoSpringDataJPARepository.findById(idProduto)
                .orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Produto não encontrado!"));
        log.info("[finish] ProdutoInfraRespository - buscaProdutoPorID");
        return Optional.ofNullable(produto);
    }


    @Override
    public Produto buscaProdutoPorID(Long idProduto) {
        log.info("[start] ProdutoInfraRespository - buscaProdutoPorID");
        Produto produto = produtoSpringDataJPARepository.findById(idProduto)
                .orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Produto não encontrado!"));
        log.info("[finish] ProdutoInfraRespository - buscaProdutoPorID");
        return produto;
    }

    @Override
    public List<Produto> buscaTodosProdutos() {
        log.info("[start] ProdutoInfraRespository - buscaTodosProdutos");
        List<Produto> todosClientes = produtoSpringDataJPARepository.findAll();
        log.info("[finish] ProdutoInfraRespository - buscaTodosProdutos");
        return todosClientes;
    }

    @Override
    public void deletaProduto(Produto produto) {
        log.info("[start] ProdutoInfraRespository - deletaProduto");
        produtoSpringDataJPARepository.delete(produto);
        log.info("[finish] ProdutoInfraRespository - deletaProduto");
    }
}
