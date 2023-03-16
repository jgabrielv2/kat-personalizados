package art.katpersonalizados.model.dados.cadastro;

import art.katpersonalizados.model.entity.Produto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

/**
 * A DTO for the {@link Produto} entity
 */
public record DadosCadastroProduto(@NotBlank String descricao, @NotNull @Positive BigDecimal preco,
                                   @NotNull Long idCategoria) {
}