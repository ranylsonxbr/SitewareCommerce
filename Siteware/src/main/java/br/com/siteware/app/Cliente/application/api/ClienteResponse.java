package br.com.siteware.app.Cliente.application.api;

import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Value
@Builder
public class ClienteResponse {
    UUID idCliente;
}
