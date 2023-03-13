package art.katpersonalizados.model.dados.listagem;

import art.katpersonalizados.model.entity.Produto;

import java.math.BigDecimal;

public record DadosListagemProduto(Long id, String descricao, BigDecimal preco,Long idCategoria, String nomeCategoria) {

    public DadosListagemProduto(Produto p){
        this(p.getId(), p.getDescricao(), p.getPreco(), p.getCategoria().getId(), p.getCategoria().getNome());
    }

}
