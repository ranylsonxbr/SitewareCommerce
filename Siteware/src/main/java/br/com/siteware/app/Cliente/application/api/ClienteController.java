package br.com.siteware.app.Cliente.application.api;

import br.com.siteware.app.Cliente.application.service.ClienteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@Log4j2
@RequiredArgsConstructor
public class ClienteController implements ClienteAPI {

    private final ClienteService clienteService;

    @Override
    public ClienteResponse postCliente(ClienteRequest clienteRequest) {
        log.info("[start] ClienteController - postCliente");
        ClienteResponse novoCliente = clienteService.salvaCliente(clienteRequest);
        log.info("[finish] ClienteController - postCliente");
        return novoCliente;
    }

//    @Override
//    public List<ClienteListResponse> getTodosClientes() {
//        log.info("[start] ClienteController - getTodosClientes");
//
//        log.info("[finish] ClienteController - getTodosClientes");
//        return null;
//    }
//
//    @Override
//    public ClienteDetalhadoResponse getBuscaClientePorId(UUID idCliente) {
//        log.info("[start] ClienteController - getBuscaClientePorId");
//
//        log.info("[finish] ClienteController - getBuscaClientePorId");
//        return null;
//    }
//
//    @Override
//    public void deletaClientePorId(UUID idCliente) {
//        log.info("[start] ClienteController - deletaClientePorId");
//
//        log.info("[finish] ClienteController - deletaClientePorId");
//    }
//
//    @Override
//    public void patchAlteraCliente(UUID idCliente, ClienteAlteracaoRequest clienteAlteracaoRequest) {
//        log.info("[start] ClienteController - patchAlteraCliente");
//
//        log.info("[finish] ClienteController - patchAlteraCliente");
//    }
}
