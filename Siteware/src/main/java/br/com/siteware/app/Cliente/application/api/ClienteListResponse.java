package br.com.siteware.app.Cliente.application.api;

import br.com.siteware.app.Cliente.domain.Cliente;
import lombok.Value;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Value
public class ClienteListResponse {
    private UUID idCliente;
    private String nomeCompleto;
    private String email;
    private LocalDate dataNascimento;

    public ClienteListResponse(Cliente cliente) {
        this.idCliente = cliente.getIdCliente();
        this.nomeCompleto = cliente.getNomeCompleto();
        this.email = cliente.getEmail();
        this.dataNascimento = cliente.getDataNascimento();
    }

    public static List<ClienteListResponse> converteListaClientes(List<Cliente> clientes){
        return clientes.stream().map(ClienteListResponse::new).collect(Collectors.toList());
    }
}