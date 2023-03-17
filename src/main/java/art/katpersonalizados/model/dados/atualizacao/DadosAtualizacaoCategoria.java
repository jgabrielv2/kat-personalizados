package art.katpersonalizados.model.dados.atualizacao;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoCategoria(@NotBlank String nome, @NotNull Long idCategoria) {

}