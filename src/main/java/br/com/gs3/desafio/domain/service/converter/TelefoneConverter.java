package br.com.gs3.desafio.domain.service.converter;

import br.com.gs3.desafio.api.dto.request.TelefoneRequest;
import br.com.gs3.desafio.api.dto.response.TelefoneResponse;
import br.com.gs3.desafio.domain.model.Telefone;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class TelefoneConverter implements RequestDisassembler<Telefone, TelefoneRequest>,
        ResponseAssembler<Telefone, TelefoneResponse> {

    @Override
    public Telefone toEntity(TelefoneRequest request) {
        Telefone telefone = new Telefone();
        telefone.setTipoTelefone(request.getTipoTelefone());
        telefone.setNumeroTelefone(request.getNumeroTelefone());
        return telefone;
    }

    @Override
    public TelefoneResponse toResponse(Telefone entity) {
        var telefoneResponse = new TelefoneResponse();
        telefoneResponse.setNumeroTelefone(entity.getNumeroTelefone());
        telefoneResponse.setTipoTelefone(entity.getTipoTelefone());
        return telefoneResponse;
    }

    @Override
    public List<TelefoneResponse> toCollectionResponse(Collection<Telefone> entities) {
        return entities.stream().map(this::toResponse).collect(Collectors.toList());
    }
}
