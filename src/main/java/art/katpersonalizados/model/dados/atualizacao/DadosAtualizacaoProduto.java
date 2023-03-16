package art.katpersonalizados.model.dados.atualizacao;

import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;

public record DadosAtualizacaoProduto(Long id, @NotBlank String descricao, BigDecimal preco, Long idCategoria) {
}
