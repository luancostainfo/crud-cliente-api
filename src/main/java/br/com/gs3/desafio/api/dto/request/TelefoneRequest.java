package br.com.gs3.desafio.api.dto.request;

import br.com.gs3.desafio.domain.model.TipoTelefone;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@Setter
public class TelefoneRequest {

    @NotBlank
    @Pattern(regexp = "^\\(?[1-9]{2}\\)? ?(?:[2-8]|9[1-9])[0-9]{3}-?[0-9]{4}$", message = "Informe um número de telefone válido")
    private String numeroTelefone;

    @NotNull
    private TipoTelefone tipoTelefone;

}
