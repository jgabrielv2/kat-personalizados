package art.katpersonalizados.model.dados.atualizacao;

import art.katpersonalizados.model.dados.DadosEndereco;
import art.katpersonalizados.model.dados.DadosPessoaisDto;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoCliente(@NotNull Long idCliente, String username, DadosPessoaisDto dadosPessoais, DadosEndereco endereco) {


}
