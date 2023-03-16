package art.katpersonalizados.service.impl;

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
import org.springframework.stereotype.Service;

import java.util.List;

@SuppressWarnings("ClassHasNoToStringMethod")
@Service
public class ProdutoServiceImpl implements ProdutoService {

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
        p.setAtivo(true);
        produtoRepository.save(p);
        return new DadosDetalhamentoProduto(p);
    }

    @Override
    public List<DadosListagemProduto> listarPorDescricao(String descricao) {
        return produtoRepository.findByDescricaoContainsIgnoreCase(descricao).stream().map(DadosListagemProduto::new).toList();
    }

    @Override
    public DadosDetalhamentoProduto detalhar(Long id) {
        return new DadosDetalhamentoProduto(produtoRepository.getReferenceById(id));
    }

    @Override
    public List<DadosListagemProduto> listar() {
        return produtoRepository.findByAtivoTrue().stream().map(DadosListagemProduto::new).toList();
    }

    @Override
    public List<DadosListagemProduto> listarPorNomeCategoria(String nome) {
        return produtoRepository.findByCategoria_NomeIgnoreCase(nome).stream().map(DadosListagemProduto::new).toList();
    }

    @Transactional
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

    @Transactional
    @Override
    public void excluir(Long id) {
        Produto p = produtoRepository.getReferenceById(id);
        p.setAtivo(false);
    }
}
