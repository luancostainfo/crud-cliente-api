package br.com.gs3.desafio.domain.repository;

import br.com.gs3.desafio.api.dto.response.ClienteResumoResponse;
import br.com.gs3.desafio.domain.model.Cliente;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    @EntityGraph(attributePaths = {"endereco"})
    @Override
    List<Cliente> findAll();

    @Query("select new br.com.gs3.desafio.api.dto.response.ClienteResumoResponse" +
            "(c.id, c.nome, c.endereco.uf, c.endereco.cidade, c.emails.size, c.telefones.size) from Cliente c")
    List<ClienteResumoResponse> listarTodos();

}
