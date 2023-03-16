package art.katpersonalizados.model.dados.detalhamento;

import art.katpersonalizados.model.entity.Produto;

import java.math.BigDecimal;

public record DadosDetalhamentoProduto(Long id, String descricao, BigDecimal preco, Long idCategoria,
                                       String nomeCategoria) {

    public DadosDetalhamentoProduto(Produto p) {
        this(p.getId(), p.getDescricao(), p.getPreco(), p.getCategoria().getId(), p.getCategoria().getNome());
    }

}
