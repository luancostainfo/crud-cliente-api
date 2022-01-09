package br.com.gs3.desafio.api.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Builder
public class ProblemDetail {

    private final Integer status;
    private final String title;
    private final String detail;
    private final List<InvalidParam> params;

}
