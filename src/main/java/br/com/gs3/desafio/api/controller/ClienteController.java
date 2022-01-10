package br.com.gs3.desafio.api.controller;

import br.com.gs3.desafio.api.dto.request.ClienteRequest;
import br.com.gs3.desafio.api.dto.response.ClienteResponse;
import br.com.gs3.desafio.api.dto.response.ClienteResumoResponse;
import br.com.gs3.desafio.domain.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@CrossOrigin(origins = {"${settings.cors_origin}"})
@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    @PostMapping
    public ResponseEntity<ClienteResponse> cadastrar(@Valid @RequestBody ClienteRequest clienteRequest) {

        var clienteResponse = clienteService.cadastrar(clienteRequest);

        var uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(clienteResponse.getId())
                .toUri();

        return ResponseEntity.created(uri).body(clienteResponse);
    }

    @GetMapping("/{id}")
    public ClienteResponse buscarPorId(@PathVariable Long id) {
        return clienteService.buscarPorId(id);
    }

    @GetMapping
    public List<ClienteResumoResponse> listarTodos() {
        return clienteService.listarTodos();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id) {
        clienteService.deletar(id);
    }

    @PutMapping("/{id}")
    public ClienteResponse atualizar(@PathVariable Long id, @Valid @RequestBody ClienteRequest clienteRequest) {
        return clienteService.atualizar(id, clienteRequest);
    }
}
