package br.com.gs3.desafio.domain.service;

import br.com.gs3.desafio.api.dto.request.ClienteRequest;
import br.com.gs3.desafio.api.dto.response.ClienteResponse;
import br.com.gs3.desafio.domain.model.Cliente;
import br.com.gs3.desafio.domain.repository.ClienteRepository;
import br.com.gs3.desafio.domain.service.converter.ClienteConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;
    private final ClienteConverter clienteConverter;

    @Transactional
    public ClienteResponse cadastrar(ClienteRequest clienteRequest) {

        Cliente cliente = clienteConverter.toEntity(clienteRequest);
        cliente = clienteRepository.save(cliente);
        return clienteConverter.toResponse(cliente);
    }

}
