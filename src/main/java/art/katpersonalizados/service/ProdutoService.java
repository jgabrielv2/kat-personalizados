package art.katpersonalizados.service;

import art.katpersonalizados.model.dados.atualizacao.DadosAtualizacaoProduto;
import art.katpersonalizados.model.dados.cadastro.DadosCadastroProduto;
import art.katpersonalizados.model.dados.detalhamento.DadosDetalhamentoProduto;
import art.katpersonalizados.model.entity.Produto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProdutoService {

    DadosDetalhamentoProduto salvar (DadosCadastroProduto dados);

    ResponseEntity<List<Produto>> buscarPorDescricao (String descricao);

    ResponseEntity<Produto> buscarPorId (Long id);

    ResponseEntity<List<Produto>> buscarTodos();

    ResponseEntity<List<Produto>> buscarPorNomeCategoria(String nome);

    DadosDetalhamentoProduto atualizar (DadosAtualizacaoProduto dados);

    void excluir(Long id);

}
