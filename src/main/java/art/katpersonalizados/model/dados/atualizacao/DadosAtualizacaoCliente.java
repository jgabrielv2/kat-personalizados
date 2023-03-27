package art.katpersonalizados.model.dados.atualizacao;

import art.katpersonalizados.model.dados.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoCliente(@NotNull Long idCliente, String username, AtualizacaoDadosPessoais dadosPessoais,
                                      DadosEndereco endereco) {


}
