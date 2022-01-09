package br.com.gs3.desafio.domain.service.converter;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public interface ResponseAssembler<E, R> {

    R toResponse(E entity);

    default List<R> toCollectionResponse(Collection<E> entities) {
        return Collections.emptyList();
    }

}
