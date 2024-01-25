package br.com.siteware.app.Cliente.application.service;
import br.com.siteware.app.Cliente.application.api.ClienteListResponse;
import br.com.siteware.app.Cliente.application.api.ClienteRequest;
import br.com.siteware.app.Cliente.application.api.ClienteResponse;
import br.com.siteware.app.Cliente.domain.Cliente;
import br.com.siteware.app.Cliente.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor
public class ClienteApplicationService implements ClienteService {

    private final ClienteRepository clienteRepository;

    @Override
    public ClienteResponse salvaCliente(ClienteRequest clienteRequest) {
        log.info("[start] ClienteApplicationService - salva");
        Cliente cliente = clienteRepository.salvaCliente(new Cliente(clienteRequest));
        log.info("[finish] ClienteApplicationService - salva");
        return ClienteResponse.builder()
                .idCliente(cliente.getIdCliente())
                .build();
    }

    @Override
    public List<ClienteListResponse> buscaTodosClientes() {
        log.info("[start] ClienteApplicationService - buscaTodosClientes");
        List<Cliente> clientes = clienteRepository.buscaTodosClientes();
        log.info("[finish] ClienteApplicationService - buscaTodosClientes");
        return ClienteListResponse.converteListaClientes(clientes);
    }
}
