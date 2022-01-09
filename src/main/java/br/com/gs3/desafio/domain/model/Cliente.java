package br.com.gs3.desafio.domain.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

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

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "cliente", orphanRemoval = true)
    private Endereco endereco;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente", orphanRemoval = true)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Telefone> telefones;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente", orphanRemoval = true)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Email> emails;

    public void setCpf(String cpf) {
        this.cpf = cpf.replaceAll("[^\\d ]", "");
    }

    public String getCpf() {
        return this.cpf.replaceAll("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");
    }

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
