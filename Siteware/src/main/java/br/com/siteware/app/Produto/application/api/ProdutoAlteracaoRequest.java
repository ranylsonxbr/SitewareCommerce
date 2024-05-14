package br.com.siteware.app.Produto.application.api;


import br.com.siteware.app.Produto.domain.Promocoes;
import lombok.Value;

import java.math.BigDecimal;

@Value
public class ProdutoAlteracaoRequest {
    private String nome;
    private BigDecimal preco;
    private Promocoes Promocoes;

}
