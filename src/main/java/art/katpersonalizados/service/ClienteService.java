package art.katpersonalizados.service;

import art.katpersonalizados.model.dados.atualizacao.DadosAtualizacaoCliente;
import art.katpersonalizados.model.dados.cadastro.DadosCadastroCliente;
import art.katpersonalizados.model.dados.detalhamento.DadosDetalhamentoCliente;
import art.katpersonalizados.model.dados.listagem.DadosListagemCliente;

import java.util.List;

public interface ClienteService {

    DadosDetalhamentoCliente salvar(DadosCadastroCliente dados);

    DadosDetalhamentoCliente buscarPorCpf(String cpf);

    DadosDetalhamentoCliente buscarPorId(Long id);

    List<DadosListagemCliente> buscarTodos();

    DadosDetalhamentoCliente atualizar(DadosAtualizacaoCliente dados);

    void excluir(Long id);

}
