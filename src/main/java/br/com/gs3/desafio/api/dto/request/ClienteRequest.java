package br.com.gs3.desafio.api.dto.request;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;

@Getter
@Setter
public class ClienteRequest {

    @NotBlank
    @Size(min = 3, max = 100)
    private String nome;

    @NotBlank
    @CPF
    private String cpf;

    @NotEmpty
    @Valid
    private List<@Email String> emails;

    @NotEmpty
    @Valid
    private List<TelefoneRequest> telefones;

    @NotNull
    @Valid
    private EnderecoRequest endereco;

}
