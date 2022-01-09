package br.com.gs3.desafio.api.dto.response;

import br.com.gs3.desafio.domain.model.TipoTelefone;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TelefoneResponse {

    private String numeroTelefone;
    private TipoTelefone tipoTelefone;

}
