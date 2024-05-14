package br.com.siteware.app.Produto.infra;



import br.com.siteware.app.Produto.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;



public interface ProdutoSpringDataJPARepository extends JpaRepository<Produto, Long> {
}