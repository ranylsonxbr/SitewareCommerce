package br.com.siteware.app.Carrinho.application.api;

import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
public class ProdutoCarrinhoRequest {
    private Long idProduto;
    @Positive
    private BigDecimal quantidade;
}
