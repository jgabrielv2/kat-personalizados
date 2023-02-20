package art.katpersonalizados.service.impl;

import art.katpersonalizados.dto.ProdutoDto;
import art.katpersonalizados.exception.NotFoundException;
import art.katpersonalizados.model.Categoria;
import art.katpersonalizados.model.Produto;
import art.katpersonalizados.repository.CategoriaRepository;
import art.katpersonalizados.repository.ProdutoRepository;
import art.katpersonalizados.service.ProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    // Constante para o status HTTP 404 not fouund
    private static final HttpStatus NOT_FOUND = HttpStatus.NOT_FOUND;
    private final ProdutoRepository produtoRepository;
    private final CategoriaRepository categoriaRepository;

    public ProdutoServiceImpl(ProdutoRepository produtoRepository, CategoriaRepository categoriaRepository) {
        this.produtoRepository = produtoRepository;
        this.categoriaRepository = categoriaRepository;
    }


    @Override
    public ResponseEntity<Produto> salvar(ProdutoDto produtoDto) {
        Produto p = new Produto();
        return setAtributos(produtoDto, p);
    }

    @Override
    public ResponseEntity<List<Produto>> buscarPorDescricao(String descricao) {
        List<Produto> produtos = produtoRepository.findByDescricaoContainsIgnoreCase(descricao);
        if (produtos.isEmpty()) {
            return ResponseEntity.status(NOT_FOUND).build();
        } else {
            return ResponseEntity.ok(produtos);
        }
    }

    @Override
    public ResponseEntity<Produto> buscarPorId(Long id) {
        Optional<Produto> optionalProduto = produtoRepository.findById(id);
        return optionalProduto.map(ResponseEntity::ok)
                .orElseThrow(() -> new NotFoundException("Produto não encontrado com a id " + id));
    }

    @Override
    public ResponseEntity<List<Produto>> buscarTodos() {
        List<Produto> produtos = produtoRepository.findAll();
        if (produtos.isEmpty()) {
            return ResponseEntity.status(NOT_FOUND).build();
        } else {
            return ResponseEntity.ok(produtos);
        }
    }

    @Override
    public ResponseEntity<List<Produto>> buscarPorNomeCategoria(String nome) {
        List<Produto> produtos = produtoRepository.findByCategoria_NomeIgnoreCase(nome);
        if (produtos.isEmpty()) {
            return ResponseEntity.status(NOT_FOUND).build();
        } else {
            return ResponseEntity.ok(produtos);
        }

    }

    @Override
    public ResponseEntity<Produto> atualizar(Long id, ProdutoDto produtoDto) {
        Produto p = produtoRepository.findById(id).orElseThrow(() -> new NotFoundException("Produto não encontrado!"));
        return setAtributos(produtoDto, p);
    }

    // método interno auxiliar, para salvar e atualizar
    private ResponseEntity<Produto> setAtributos(ProdutoDto produtoDto, Produto p) {

        Categoria c = categoriaRepository.findByNomeIgnoreCase(produtoDto.categoria().getNome()).orElse(new Categoria());
        c.setNome(produtoDto.categoria().getNome());


        p.setDescricao(produtoDto.descricao());
        p.setPreco(produtoDto.preco());
        p.setCategoria(c);
        return ResponseEntity.ok(p);
    }

    @Override
    public void excluir(Long id) {
        if (!produtoRepository.existsById(id)) {
        throw new NotFoundException("Produto não encontrado com a id " + id);
        } else {
            produtoRepository.deleteById(id);
        }
    }
}
