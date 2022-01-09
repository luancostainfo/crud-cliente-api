package br.com.gs3.desafio.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ClienteResumoResponse {

    private Long id;
    private String nome;
    private String uf;
    private String cidade;
    private Integer quantidadeEmails;
    private Integer quantidadeTelefones;

} 