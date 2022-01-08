package br.com.gs3.desafio.domain.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String cpf;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "cliente")
    private Endereco endereco;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente")
    private List<Telefone> telefones;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente")
    private List<Email> emails;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return id.equals(cliente.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}