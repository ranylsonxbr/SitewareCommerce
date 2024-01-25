package br.com.siteware.app.Cliente.infra;

import br.com.siteware.app.Cliente.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClienteSpringDataJPARepository extends JpaRepository<Cliente, UUID> {
}
