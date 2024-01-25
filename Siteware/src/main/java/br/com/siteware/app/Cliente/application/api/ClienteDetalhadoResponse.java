package br.com.siteware.app.Cliente.application.api;

import br.com.siteware.app.Cliente.domain.Cliente;
import lombok.Value;

import java.time.LocalDate;
import java.util.UUID;

@Value
public class ClienteDetalhadoResponse {
    private UUID idCliente;
    private String nomeCompleto;
    private String email;

    private LocalDate dataNascimento;

    private ClienteDetalhadoResponse(Cliente cliente) {
        this.idCliente = cliente.getIdCliente();
        this.nomeCompleto = cliente.getNomeCompleto();
        this.email = cliente.getEmail();
        this.dataNascimento = cliente.getDataNascimento();
    }

    public static ClienteDetalhadoResponse converteClienteParaResponse(Cliente cliente) {
        return new ClienteDetalhadoResponse(cliente);
    }
}