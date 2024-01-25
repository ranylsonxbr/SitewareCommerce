package br.com.siteware.app.Cliente.application.service;


import br.com.siteware.app.Cliente.application.api.ClienteListResponse;
import br.com.siteware.app.Cliente.application.api.ClienteRequest;
import br.com.siteware.app.Cliente.application.api.ClienteResponse;

import java.util.List;

public interface ClienteService {
    ClienteResponse salvaCliente(ClienteRequest clienteRequest);

    List<ClienteListResponse> buscaTodosClientes();
}
