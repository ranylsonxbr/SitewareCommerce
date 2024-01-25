package br.com.siteware.app.Cliente.domain;

import br.com.siteware.app.Cliente.application.api.ClienteRequest;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idCliente", updatable = false, unique = true, nullable = false, length = 36)
    private UUID idCliente;
    @NotBlank
    private String nomeCompleto;
    @NotBlank
    @Email
    @Column(unique = true)
    private String email;
    @NotNull
    private LocalDate dataNascimento;

    private LocalDateTime dataHoraDoCadastro;
    private LocalDateTime dataHoraDaultimaAlteracao;

    public Cliente(ClienteRequest clienteRequest) {
        this.nomeCompleto= clienteRequest.getNomeCompleto();
        this.email = clienteRequest.getEmail();
        this.dataNascimento = clienteRequest.getDataNascimento();
        this.dataHoraDoCadastro = LocalDateTime.now();
    }
}
