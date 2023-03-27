package art.katpersonalizados.model.dados.cadastro;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record DadosCadastroProduto(@NotBlank String descricao, @NotNull @Positive BigDecimal preco,
                                   @NotNull Long idCategoria) {
}