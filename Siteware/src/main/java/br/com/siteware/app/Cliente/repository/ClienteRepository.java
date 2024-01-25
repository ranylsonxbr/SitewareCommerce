package br.com.siteware.app.Cliente.repository;

import br.com.siteware.app.Cliente.domain.Cliente;

import java.util.List;

public interface ClienteRepository {

    Cliente salvaCliente(Cliente cliente);

    List<Cliente> buscaTodosClientes();
}
