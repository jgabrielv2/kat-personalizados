package art.katpersonalizados.service.impl;

import art.katpersonalizados.dto.ProdutoDto;
import art.katpersonalizados.exception.NotFoundException;
import art.katpersonalizados.model.Categoria;
import art.katpersonalizados.model.Produto;
import art.katpersonalizados.repository.CategoriaRepository;
import art.katpersonalizados.repository.ProdutoRepository;
import art.katpersonalizados.service.ProdutoService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoServiceImpl implements ProdutoService {

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
            return ResponseEntity.notFound().build();
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
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(produtos);
        }
    }

    @Override
    public ResponseEntity<List<Produto>> buscarPorNomeCategoria(String nome) {
        List<Produto> produtos = produtoRepository.findByCategoria_NomeIgnoreCase(nome);
        if (produtos.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(produtos);
        }

    }

    @Override
    public ResponseEntity<Produto> atualizar(Long id, ProdutoDto produtoDto) {
        Produto p = produtoRepository.findById(id).orElseThrow(() -> new NotFoundException("Produto não encontrado!"));
        return setAtributos(produtoDto, p);
    }

    private ResponseEntity<Produto> setAtributos(ProdutoDto produtoDto, Produto p) {
        Categoria c = categoriaRepository.findByNomeIgnoreCase(produtoDto.getCategoria().getNome());

        if (c == null) {
            c = new Categoria();
            c.setNome(produtoDto.getCategoria().getNome());
        }

        p.setDescricao(produtoDto.getDescricao());
        p.setPreco(produtoDto.getPreco());
        p.setCategoria(c);
        return ResponseEntity.ok(p);
    }

    @Override
    public void excluir(Long id) {

        produtoRepository.deleteById(id);

    }
}
