package art.katpersonalizados.model.dados.cadastro;

import art.katpersonalizados.model.entity.Categoria;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

/**
 * A DTO for the {@link Categoria} entity
 */
public record DadosCadastroCategoria(@NotNull String nome) implements Serializable {


}