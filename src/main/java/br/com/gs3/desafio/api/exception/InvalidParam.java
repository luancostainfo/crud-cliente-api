package br.com.gs3.desafio.api.exception;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class InvalidParam {

    private final String param;
    private final String message;

}
