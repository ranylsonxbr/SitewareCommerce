package br.com.siteware.app.Cliente.infra;

import br.com.siteware.app.Cliente.domain.Cliente;
import br.com.siteware.app.Cliente.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

@Repository
@Log4j2
@RequiredArgsConstructor
public class ClienteInfraRepository implements ClienteRepository {

    private final ClienteSpringDataJPARepository clientSpringDataJPARepository;

    @Override
    public Cliente salvaCliente(Cliente cliente) {
        log.info("[start] ClienteInfraRepository - salvaCliente");
        clientSpringDataJPARepository.save(cliente);
        log.info("[finish] ClienteInfraRepository - salvaCliente");
        return cliente;
    }
}
