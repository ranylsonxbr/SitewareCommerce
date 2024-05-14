package br.com.siteware.app.Produto.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public enum Promocoes {
    NENHUMA_PROMOCAO(0),
    LEVE_2_PAGUE_1(1),
    TRES_POR_DEZ(2);

    private Integer code;

}