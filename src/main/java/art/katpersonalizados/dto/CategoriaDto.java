package art.katpersonalizados.dto;

import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

/**
 * A DTO for the {@link art.katpersonalizados.model.Categoria} entity
 */
public record CategoriaDto(@NotNull String nome) implements Serializable {


}