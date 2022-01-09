package br.com.gs3.desafio.domain.service;

import br.com.gs3.desafio.api.dto.request.ClienteRequest;
import br.com.gs3.desafio.api.dto.response.ClienteResponse;
import br.com.gs3.desafio.api.dto.response.ClienteResumoResponse;
import br.com.gs3.desafio.domain.model.Cliente;
import br.com.gs3.desafio.domain.repository.ClienteRepository;
import br.com.gs3.desafio.domain.service.converter.ClienteConverter;
import br.com.gs3.desafio.domain.service.exception.RecursoNaoEncontradoException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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

    public List<ClienteResumoResponse> listarTodos() {
        return clienteRepository.listarTodos();
    }

    @Transactional
    public void deletar(Long id) {
        var cliente = getClientePorId(id);
        clienteRepository.delete(cliente);
    }

    @Transactional
    public ClienteResponse atualizar(Long id, ClienteRequest clienteRequest) {

        Optional<Cliente> clienteOptional = clienteRepository.findById(id);
        var cliente = clienteConverter.toEntity(clienteRequest);

        if (clienteOptional.isPresent()) {
            Cliente finalCliente = cliente;
            cliente.setId(id);
            cliente.getEndereco().setCliente(cliente);
            cliente.getTelefones().forEach(telefone -> telefone.setCliente(finalCliente));
            cliente.getEmails().forEach(email -> email.setCliente(finalCliente));
            cliente = clienteRepository.save(cliente);

        } else {
            throw new RecursoNaoEncontradoException(String.format(MSG_CLIENTE_NAO_ENCONTRADO, id));
        }

        return clienteConverter.toResponse(cliente);
    }

    private Cliente getClientePorId(Long id) {
        return clienteRepository
                .findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException(String.format(MSG_CLIENTE_NAO_ENCONTRADO, id)));
    }
}
