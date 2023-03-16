package art.katpersonalizados.model.dados.listagem;

import art.katpersonalizados.model.entity.Categoria;

public record DadosListagemCategoria(Long id, String nome) {

    public DadosListagemCategoria(Categoria c) {
        this(c.getId(), c.getNome());
    }

}
