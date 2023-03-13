package art.katpersonalizados.service.impl;

import art.katpersonalizados.exception.NotFoundException;
import art.katpersonalizados.model.dados.atualizacao.DadosAtualizacaoProduto;
import art.katpersonalizados.model.dados.cadastro.DadosCadastroProduto;
import art.katpersonalizados.model.dados.detalhamento.DadosDetalhamentoProduto;
import art.katpersonalizados.model.dados.listagem.DadosListagemProduto;
import art.katpersonalizados.model.entity.Categoria;
import art.katpersonalizados.model.entity.Produto;
import art.katpersonalizados.repository.CategoriaRepository;
import art.katpersonalizados.repository.ProdutoRepository;
import art.katpersonalizados.service.ProdutoService;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("ClassHasNoToStringMethod")
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


    @Transactional
    @Override
    public DadosDetalhamentoProduto salvar(DadosCadastroProduto dados) {
        Categoria c = categoriaRepository.getReferenceById(dados.idCategoria());
        Produto p = new Produto();
        p.setDescricao(dados.descricao());
        p.setPreco(dados.preco());
        p.setCategoria(c);
        produtoRepository.save(p);
        return new DadosDetalhamentoProduto(p);
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
    public List<DadosListagemProduto> listar() {
        return produtoRepository.findAll().stream().map(DadosListagemProduto::new).toList();
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
    public DadosDetalhamentoProduto atualizar(DadosAtualizacaoProduto dados) {
        Produto p = produtoRepository.getReferenceById(dados.id());

        if (dados.descricao() != null) {
            p.setDescricao(dados.descricao());
        }
        if (dados.preco() != null) {
            p.setPreco(dados.preco());
        }
        if (dados.idCategoria() != null) {
            p.setCategoria(categoriaRepository.getReferenceById(dados.idCategoria()));
        }

        return new DadosDetalhamentoProduto(p);
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
