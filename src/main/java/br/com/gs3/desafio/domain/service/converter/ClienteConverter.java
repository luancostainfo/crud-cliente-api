package br.com.gs3.desafio.domain.service.converter;

import br.com.gs3.desafio.api.dto.request.ClienteRequest;
import br.com.gs3.desafio.api.dto.response.ClienteResponse;
import br.com.gs3.desafio.domain.model.Cliente;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class ClienteConverter implements RequestDisassembler<Cliente, ClienteRequest>,
        ResponseAssembler<Cliente, ClienteResponse> {

    private final EnderecoConverter enderecoConverter;
    private final TelefoneConverter telefoneConverter;
    private final EmailConverter emailConverter;

    @Override
    public Cliente toEntity(ClienteRequest request) {

        var telefones = request.getTelefones().stream().map(telefoneConverter::toEntity).collect(Collectors.toList());
        var emails = request.getEmails().stream().map(emailConverter::toEntity).collect(Collectors.toList());
        var endereco = enderecoConverter.toEntity(request.getEndereco());

        var cliente = new Cliente();
        cliente.setNome(request.getNome());
        cliente.setCpf(request.getCpf());
        cliente.setEndereco(endereco);
        cliente.setTelefones(telefones);
        cliente.setEmails(emails);

        endereco.setCliente(cliente);
        telefones.forEach(telefone -> telefone.setCliente(cliente));
        emails.forEach(email -> email.setCliente(cliente));

        return cliente;
    }

    @Override
    public ClienteResponse toResponse(Cliente entity) {

        var enderecoResponse = enderecoConverter.toResponse(entity.getEndereco());
        var telefonesResponse = telefoneConverter.toCollectionResponse(entity.getTelefones());
        var emails = emailConverter.toCollectionResponse(entity.getEmails());

        var clienteResponse = new ClienteResponse();
        clienteResponse.setId(entity.getId());
        clienteResponse.setNome(entity.getNome());
        clienteResponse.setCpf(entity.getCpf());
        clienteResponse.setEndereco(enderecoResponse);
        clienteResponse.setTelefones(telefonesResponse);
        clienteResponse.setEmails(emails);

        return clienteResponse;
    }
}
