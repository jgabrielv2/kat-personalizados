package art.katpersonalizados.model.dados.cadastro;

import art.katpersonalizados.model.dados.DadosEndereco;
import art.katpersonalizados.model.dados.DadosPessoaisDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

public record DadosCadastroCliente(@NotBlank String username,
                                   @Valid @NotNull DadosPessoaisDto dadosPessoais,
                                   @Valid @NotNull DadosEndereco endereco) implements Serializable {
}