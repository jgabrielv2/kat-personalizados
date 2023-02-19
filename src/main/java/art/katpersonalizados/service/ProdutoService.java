package art.katpersonalizados.service;

import art.katpersonalizados.dto.ProdutoDto;
import art.katpersonalizados.model.Produto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProdutoService {

    ResponseEntity<Produto> salvar (ProdutoDto produtoDto);

    ResponseEntity<List<Produto>> buscarPorDescricao (String descricao);

    ResponseEntity<Produto> buscarPorId (Long id);

    ResponseEntity<List<Produto>> buscarTodos();

    ResponseEntity<List<Produto>> buscarPorNomeCategoria(String nome);

    ResponseEntity<Produto> atualizar (Long id, ProdutoDto produtoDto);

    void excluir(Long id);

}
