package art.katpersonalizados.model.dados.detalhamento;

import art.katpersonalizados.model.entity.Categoria;
import art.katpersonalizados.model.entity.Produto;

import java.math.BigDecimal;

public record DadosDetalhamentoProduto(Long id, String descricao, BigDecimal preco, Categoria categoria) {

    public DadosDetalhamentoProduto(Produto p){
        this(p.getId(), p.getDescricao(), p.getPreco(), p.getCategoria());
    }

}
