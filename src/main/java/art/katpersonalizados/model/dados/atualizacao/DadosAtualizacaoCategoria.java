package art.katpersonalizados.model.dados.atualizacao;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoCategoria(String nome, @NotNull Long idCategoria) {

}