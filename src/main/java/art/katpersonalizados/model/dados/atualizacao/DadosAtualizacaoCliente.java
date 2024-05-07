package art.katpersonalizados.model.dados.atualizacao;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoCliente(@NotNull Long idCliente, String username, AtualizacaoDadosPessoais dadosPessoais,
                                      DadosAtualizacaoEndereco endereco) {


}
