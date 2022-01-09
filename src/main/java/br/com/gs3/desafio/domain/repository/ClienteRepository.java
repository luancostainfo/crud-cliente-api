package br.com.gs3.desafio.domain.repository;

import br.com.gs3.desafio.domain.model.Cliente;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    @EntityGraph(attributePaths = {"telefones", "emails", "endereco"})
    @Override
    List<Cliente> findAll();
}
