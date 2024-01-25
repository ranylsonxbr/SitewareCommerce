package br.com.siteware.app.Cliente.application.api;



import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;




@RestController
@RequestMapping("/v1/cliente")
public interface ClienteAPI {

    @PostMapping(value = "/cria-cliente")
    @ResponseStatus(value = HttpStatus.CREATED)
    ClienteResponse postCliente(@RequestBody @Valid ClienteRequest ClienteRequest);

}

