package br.com.gs3.desafio.api.dto.response;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import java.util.List;

@Getter
@Setter
public class ClienteResponse {

    private Long id;
    private String nome;
    private String cpf;
    private List<@Email String> emails;
    private List<TelefoneResponse> telefones;
    private EnderecoResponse endereco;

}
