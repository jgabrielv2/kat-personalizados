package art.katpersonalizados.model.dados.cadastro;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

public record DadosCadastroEndereco(@NotNull Long idCliente,
                                    @NotBlank String cep,
                                    @NotBlank @Size(max = 100) String logradouro,
                                    @NotBlank @Size(max = 100) String complemento,
                                    @NotBlank @Size(max = 20) String bairro,
                                    @NotBlank @Size(max = 20) String localidade,
                                    @NotBlank @Size(max = 20) String uf,
                                    @NotBlank @Size(max = 10) String numero) implements Serializable {
}