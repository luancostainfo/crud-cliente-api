package br.com.gs3.desafio.domain.service.converter;

public interface RequestDisassembler<E, R> {

    E toEntity(R request);

}
