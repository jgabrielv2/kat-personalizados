package art.katpersonalizados.service;

import art.katpersonalizados.model.dados.atualizacao.DadosAtualizacaoProduto;
import art.katpersonalizados.model.dados.cadastro.DadosCadastroProduto;
import art.katpersonalizados.model.dados.detalhamento.DadosDetalhamentoProduto;
import art.katpersonalizados.model.dados.listagem.DadosListagemProduto;

import java.util.List;

public interface ProdutoService {

    DadosDetalhamentoProduto salvar(DadosCadastroProduto dados);

    DadosDetalhamentoProduto detalhar(Long id);

    List<DadosListagemProduto> listar();

    List<DadosListagemProduto> listarPorDescricao(String descricao);

    List<DadosListagemProduto> listarPorNomeCategoria(String nome);


    DadosDetalhamentoProduto atualizar(DadosAtualizacaoProduto dados);

    void excluir(Long id);

}
