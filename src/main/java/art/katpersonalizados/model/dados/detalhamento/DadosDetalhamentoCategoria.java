package art.katpersonalizados.model.dados.detalhamento;

import art.katpersonalizados.model.entity.Categoria;

import java.util.List;

public record DadosDetalhamentoCategoria(Long id, String nome, List<DadosDetalhamentoProduto> produtos) {

    public DadosDetalhamentoCategoria(Categoria c){
        this(c.getId(), c.getNome(), c.getProdutos().stream().map(DadosDetalhamentoProduto::new).toList());
    }
}
