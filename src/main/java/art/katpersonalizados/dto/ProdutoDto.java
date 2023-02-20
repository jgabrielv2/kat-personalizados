package art.katpersonalizados.dto;

import art.katpersonalizados.model.Categoria;
import art.katpersonalizados.model.Produto;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * A DTO for the {@link Produto} entity
 */
public record ProdutoDto(@NotNull String descricao, @NotNull BigDecimal preco,
                         Categoria categoria) implements Serializable {
}