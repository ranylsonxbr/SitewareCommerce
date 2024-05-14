package br.com.siteware.app.Carrinho.infra;

import br.com.siteware.app.Carrinho.domain.Carrinho;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarrinhoSpringDataJPA extends JpaRepository<Carrinho,Long> {
}
