package br.com.gs3.desafio.api.dto.request;

import br.com.gs3.desafio.domain.model.TipoTelefone;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class TelefoneRequest {

    @NotBlank
    private String numeroTelefone;

    @NotNull
    private TipoTelefone tipoTelefone;

}
