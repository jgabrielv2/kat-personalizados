package art.katpersonalizados.model.dados.atualizacao;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * A DTO for the {@link art.katpersonalizados.model.entity.Categoria} entity
 */
public record DadosAtualizacaoCategoria(@NotBlank String nome, @NotNull Long idCategoria) {

}