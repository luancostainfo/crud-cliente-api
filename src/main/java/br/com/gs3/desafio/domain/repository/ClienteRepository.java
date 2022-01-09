package br.com.gs3.desafio.domain.repository;

import br.com.gs3.desafio.domain.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
