package art.katpersonalizados.service;

import art.katpersonalizados.dto.CategoriaDto;
import art.katpersonalizados.model.Categoria;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CategoriaService {

    ResponseEntity<Categoria> salvar(CategoriaDto categoriaDto);

    ResponseEntity<Categoria> buscarPorId(Long id);

    ResponseEntity<Categoria> buscarPorNome(String nome);

    ResponseEntity<List<Categoria>> buscarTodos();

    ResponseEntity<Categoria> atualizar(Long id, CategoriaDto categoriaDto);

    void excluir(Long id);
}
