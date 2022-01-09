package br.com.gs3.desafio.api.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
public class EnderecoRequest {

    @NotBlank
    @Pattern(regexp = "\\d{8}|\\d{2}\\.\\d{3}-\\d{3}")
    private String cep;

    @NotBlank
    private String logradouro;

    @NotBlank
    private String bairro;

    @NotBlank
    private String cidade;

    @NotBlank
    private String uf;

    private String complemento;

}
