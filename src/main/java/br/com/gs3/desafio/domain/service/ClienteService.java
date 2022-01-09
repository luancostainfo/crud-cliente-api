package br.com.gs3.desafio.domain.service;

import br.com.gs3.desafio.api.dto.request.ClienteRequest;
import br.com.gs3.desafio.api.dto.response.ClienteResponse;
import br.com.gs3.desafio.domain.repository.ClienteRepository;
import br.com.gs3.desafio.domain.service.converter.ClienteConverter;
import br.com.gs3.desafio.domain.service.exception.RecursoNaoEncontradoException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class ClienteService {

    private static final String MSG_CLIENTE_NAO_ENCONTRADO = "Cliente de id %d não encontrado.";
    private final ClienteRepository clienteRepository;
    private final ClienteConverter clienteConverter;

    @Transactional
    public ClienteResponse cadastrar(ClienteRequest clienteRequest) {

        var cliente = clienteConverter.toEntity(clienteRequest);
        cliente = clienteRepository.save(cliente);
        return clienteConverter.toResponse(cliente);
    }

    public ClienteResponse buscarPorId(Long id) {

        var cliente = clienteRepository
                .findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException(String.format(MSG_CLIENTE_NAO_ENCONTRADO, id)));

        return clienteConverter.toResponse(cliente);
    }
}
