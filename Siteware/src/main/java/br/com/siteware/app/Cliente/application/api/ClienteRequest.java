package br.com.siteware.app.Cliente.application.api;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Value;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

@Value
public class ClienteRequest {
    private String nomeCompleto;
    @NotBlank
    @Email
    private String email;
    @NotNull
    private LocalDate dataNascimento;

}
