package art.katpersonalizados.service;

import art.katpersonalizados.model.dados.atualizacao.DadosAtualizacaoCategoria;
import art.katpersonalizados.model.dados.cadastro.DadosCadastroCategoria;
import art.katpersonalizados.model.dados.detalhamento.DadosDetalhamentoCategoria;
import art.katpersonalizados.model.dados.listagem.DadosListagemCategoria;

import java.util.List;

public interface CategoriaService {

    DadosListagemCategoria salvar(DadosCadastroCategoria dadosCadastroCategoria);

    DadosDetalhamentoCategoria detalhar(Long id);

    DadosDetalhamentoCategoria detalharPorNome(String nome);

    List<DadosListagemCategoria> listar();

    DadosDetalhamentoCategoria atualizar(DadosAtualizacaoCategoria dados);

    void excluir(Long id);
}
