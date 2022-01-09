package br.com.gs3.desafio.domain.service.converter;

import br.com.gs3.desafio.domain.model.Email;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class EmailConverter implements RequestDisassembler<Email, String>,
        ResponseAssembler<Email, String> {

    @Override
    public Email toEntity(String emailRequest) {
        Email email = new Email();
        email.setEnderecoEmail(emailRequest);
        return email;
    }

    @Override
    public String toResponse(Email entity) {
        return entity.getEnderecoEmail();
    }

    @Override
    public List<String> toCollectionResponse(Collection<Email> entities) {
        return entities.stream().map(this::toResponse).collect(Collectors.toList());
    }
}
