package art.katpersonalizados.model.dados;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

public record DadosEndereco(@NotBlank String cep,
                            @NotBlank @Size(max = 100) String logradouro,
                            @NotBlank @Size(max = 100) String complemento,
                            @NotBlank @Size(max = 20) String bairro,
                            @NotBlank @Size(max = 20) String localidade,
                            @NotBlank @Size(max = 20) String uf,
                            @NotBlank @Size(max = 10) String numero) implements Serializable {
}