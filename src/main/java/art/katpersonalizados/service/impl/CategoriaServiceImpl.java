package art.katpersonalizados.service.impl;

import art.katpersonalizados.dto.CategoriaDto;
import art.katpersonalizados.exception.NotFoundException;
import art.katpersonalizados.model.Categoria;
import art.katpersonalizados.repository.CategoriaRepository;
import art.katpersonalizados.service.CategoriaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    // Constante para o status HTTP 404 not fouund
    private static final HttpStatus NOT_FOUND = HttpStatus.NOT_FOUND;

    private final CategoriaRepository categoriaRepository;

    public CategoriaServiceImpl(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    // Cria uma nova Categoria, define um nome, salva e retorna um status HTTP
    @Override
    public ResponseEntity<Categoria> salvar(CategoriaDto categoriaDto) {
        Categoria c = new Categoria();
        c.setNome(categoriaDto.getNome());
        return ResponseEntity.ok(c);
    }

    // Busca uma categoria por id. Se existir, retorna a Categoria e o status HTTP. Se não existir, lança uma Not Found Exception
    @Override
    public ResponseEntity<Categoria> buscarPorId(Long id) {
        Optional<Categoria> optionalCategoria = categoriaRepository.findById(id);
        return optionalCategoria.map(ResponseEntity::ok).orElseThrow(() -> new NotFoundException("Categoria não encontrada com a id" + id));
    }

    // Busca uma categoria por nome, ignorando maiúsculas. Se existir, retorna a Categoria e o status HTTP. Se não existir, lança uma Not Found Exception
    @Override
    public ResponseEntity<Categoria> buscarPorNome(String nome) {
        Optional<Categoria> optionalCategoria = categoriaRepository.findByNomeIgnoreCase(nome);
        return optionalCategoria.map(ResponseEntity::ok).orElseThrow(() -> new NotFoundException("Categoria " + nome + " não encontrada!"));
    }

    // Lista todas as Categorias. Se houver nenhuma, retorna o HTTP status Not Found
    @Override
    public ResponseEntity<List<Categoria>> buscarTodos() {
        List<Categoria> categorias = categoriaRepository.findAll();

        if (categorias.isEmpty()) {
            return ResponseEntity.status(NOT_FOUND).build();
        } else {
            return ResponseEntity.ok(categorias);
        }
    }
    // Atualiza a Categoria de id informada. Se não existir, lança uma Not Found Exception
    @Override
    public ResponseEntity<Categoria> atualizar(Long id, CategoriaDto categoriaDto) {
        Categoria c = categoriaRepository.findById(id).orElseThrow(() -> new NotFoundException("Categoria não encontrada com a id" + id));
        c.setNome(categoriaDto.getNome());
        return ResponseEntity.ok(c);
    }

    // Exclui a Categoria de id informada. Se não existir, lança uma Not Found Exception
    @Override
    public void excluir(Long id) {
        if(!categoriaRepository.existsById(id)){
            throw new NotFoundException("Categoria não encontrada com a id" + id);
        } else {
            categoriaRepository.deleteById(id);
        }
    }
}
