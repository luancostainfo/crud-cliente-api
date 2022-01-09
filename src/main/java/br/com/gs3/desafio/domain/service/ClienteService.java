package br.com.gs3.desafio.domain.service;

import br.com.gs3.desafio.api.dto.request.ClienteRequest;
import br.com.gs3.desafio.api.dto.response.ClienteResponse;
import br.com.gs3.desafio.domain.model.Cliente;
import br.com.gs3.desafio.domain.repository.ClienteRepository;
import br.com.gs3.desafio.domain.service.converter.ClienteConverter;
import br.com.gs3.desafio.domain.service.exception.RecursoNaoEncontradoException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

        var cliente = getClientePorId(id);

        return clienteConverter.toResponse(cliente);
    }

    public List<ClienteResponse> listarTodos() {
        var clientes = clienteRepository.findAll();
        return clienteConverter.toCollectionResponse(clientes);
    }

    @Transactional
    public void deletar(Long id) {
        var cliente = getClientePorId(id);
        clienteRepository.delete(cliente);
    }

    private Cliente getClientePorId(Long id) {
        return clienteRepository
                .findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException(String.format(MSG_CLIENTE_NAO_ENCONTRADO, id)));
    }
}
