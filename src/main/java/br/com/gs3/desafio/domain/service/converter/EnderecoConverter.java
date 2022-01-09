package br.com.gs3.desafio.domain.service.converter;

import br.com.gs3.desafio.api.dto.request.EnderecoRequest;
import br.com.gs3.desafio.api.dto.response.EnderecoResponse;
import br.com.gs3.desafio.domain.model.Endereco;
import org.springframework.stereotype.Component;

@Component
public class EnderecoConverter implements RequestDisassembler<Endereco, EnderecoRequest>,
        ResponseAssembler<Endereco, EnderecoResponse> {

    @Override
    public Endereco toEntity(EnderecoRequest request) {
        var endereco = new Endereco();
        endereco.setCep(request.getCep());
        endereco.setLogradouro(request.getLogradouro());
        endereco.setBairro(request.getBairro());
        endereco.setCidade(request.getCidade());
        endereco.setUf(request.getUf());
        endereco.setComplemento(request.getComplemento());
        return endereco;
    }

    @Override
    public EnderecoResponse toResponse(Endereco entity) {
        var enderecoResponse = new EnderecoResponse();
        enderecoResponse.setCep(entity.getCep());
        enderecoResponse.setLogradouro(entity.getLogradouro());
        enderecoResponse.setBairro(entity.getBairro());
        enderecoResponse.setCidade(entity.getCidade());
        enderecoResponse.setUf(entity.getUf());
        enderecoResponse.setComplemento(entity.getComplemento());
        return enderecoResponse;
    }
}
