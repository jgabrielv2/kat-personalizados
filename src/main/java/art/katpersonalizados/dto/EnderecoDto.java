package art.katpersonalizados.dto;

import art.katpersonalizados.model.Endereco;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

/**
 * A DTO for the {@link Endereco} entity
 */
public record EnderecoDto(@NotBlank String cep, @NotBlank @Size(max = 100) String logradouro,
                          @NotBlank @Size(max = 100) String complemento, @NotBlank @Size(max = 20) String bairro,
                          @NotBlank @Size(max = 20) String localidade,
                          @NotBlank @Size(max = 20) String uf) implements Serializable {
}