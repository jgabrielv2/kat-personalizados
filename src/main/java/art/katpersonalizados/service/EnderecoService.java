package art.katpersonalizados.service;

import art.katpersonalizados.model.dados.atualizacao.DadosAtualizacaoEndereco;
import art.katpersonalizados.model.dados.cadastro.DadosCadastroEndereco;
import art.katpersonalizados.model.dados.detalhamento.DadosDetalhamentoEndereco;
import art.katpersonalizados.model.dados.listagem.DadosListagemEndereco;

import java.util.List;

public interface EnderecoService {

    DadosDetalhamentoEndereco salvar(DadosCadastroEndereco dados);
    DadosDetalhamentoEndereco buscarPorId(Long id);
    List<DadosListagemEndereco> buscarTodos();

    DadosDetalhamentoEndereco atualizar(DadosAtualizacaoEndereco dados, Long id);

    void excluir(Long id);





}
