package art.katpersonalizados.model.dados.atualizacao;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record DadosAtualizacaoProduto(@NotNull Long idProduto, String descricao, BigDecimal preco, Long idCategoria) {
}
