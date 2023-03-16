package art.katpersonalizados.model.dados.listagem;

import art.katpersonalizados.model.entity.Categoria;

public record DadosListagemCategoria(String nome) {

    public DadosListagemCategoria(Categoria c) {
        this(c.getNome());
    }

}
