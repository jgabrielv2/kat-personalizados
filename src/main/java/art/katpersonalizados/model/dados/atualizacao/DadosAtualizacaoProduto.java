package art.katpersonalizados.model.dados.atualizacao;

import java.math.BigDecimal;

public record DadosAtualizacaoProduto(Long id, String descricao, BigDecimal preco, Long idCategoria) {
}
