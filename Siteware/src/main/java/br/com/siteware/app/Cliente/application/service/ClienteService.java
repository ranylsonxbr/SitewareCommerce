package br.com.siteware.app.Cliente.application.service;


import br.com.siteware.app.Cliente.application.api.ClienteRequest;
import br.com.siteware.app.Cliente.application.api.ClienteResponse;

public interface ClienteService {
    ClienteResponse salvaCliente(ClienteRequest clienteRequest);
}
