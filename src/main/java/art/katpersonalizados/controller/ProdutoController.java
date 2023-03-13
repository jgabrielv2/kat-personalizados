package art.katpersonalizados.controller;

import art.katpersonalizados.model.dados.atualizacao.DadosAtualizacaoProduto;
import art.katpersonalizados.model.dados.cadastro.DadosCadastroProduto;
import art.katpersonalizados.model.dados.detalhamento.DadosDetalhamentoProduto;
import art.katpersonalizados.model.dados.listagem.DadosListagemProduto;
import art.katpersonalizados.model.entity.Produto;
import art.katpersonalizados.service.ProdutoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@SuppressWarnings("ClassHasNoToStringMethod")
@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping
    public ResponseEntity<DadosDetalhamentoProduto> salvar(@RequestBody @Valid DadosCadastroProduto dadosCadastroProduto, UriComponentsBuilder uriComponentsBuilder) {
        DadosDetalhamentoProduto produto = produtoService.salvar(dadosCadastroProduto);
        var uri = uriComponentsBuilder.path("/produtos/{id}").buildAndExpand(produto.id()).toUri();
        return ResponseEntity.created(uri).body(produto);
    }

    @GetMapping("/descricao/{descricao}")
    public ResponseEntity<List<Produto>> buscarPorDescricao(@PathVariable String descricao) {
        return produtoService.buscarPorDescricao(descricao);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscarPorId(@PathVariable Long id) {
        return produtoService.buscarPorId(id);
    }

    @GetMapping
    public ResponseEntity<List<DadosListagemProduto>> listar() {
        List<DadosListagemProduto> produtos = produtoService.listar();
        return ResponseEntity.ok(produtos);
    }

    @GetMapping("/categoria/{nomeCategoria}")
    public ResponseEntity<List<Produto>> buscarPorNomeDaCategoria(@PathVariable String nomeCategoria) {
        return produtoService.buscarPorNomeCategoria(nomeCategoria);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DadosDetalhamentoProduto> atualizar(@RequestBody @Valid DadosAtualizacaoProduto dados) {
        DadosDetalhamentoProduto produto = produtoService.atualizar(dados);
        return ResponseEntity.ok(produto);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        produtoService.excluir(id);
        return ResponseEntity.noContent().build();
    }

}
