package art.katpersonalizados.controller;

import art.katpersonalizados.model.dados.atualizacao.DadosAtualizacaoProduto;
import art.katpersonalizados.model.dados.cadastro.DadosCadastroProduto;
import art.katpersonalizados.model.dados.detalhamento.DadosDetalhamentoProduto;
import art.katpersonalizados.model.dados.listagem.DadosListagemProduto;
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
        var uri = uriComponentsBuilder.path("/produtos/{idProduto}").buildAndExpand(produto.id()).toUri();
        return ResponseEntity.created(uri).body(produto);
    }

    @GetMapping("/descricao/{descricao}")
    public ResponseEntity<List<DadosListagemProduto>> listarPorDescricao(@PathVariable String descricao) {
        List<DadosListagemProduto> produtos = produtoService.listarPorDescricao(descricao);
        return ResponseEntity.ok(produtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalhamentoProduto> detalhar(@PathVariable Long id) {
        DadosDetalhamentoProduto produto = produtoService.detalhar(id);
        return ResponseEntity.ok(produto);
    }

    @GetMapping
    public ResponseEntity<List<DadosListagemProduto>> listar() {
        List<DadosListagemProduto> produtos = produtoService.listar();
        return ResponseEntity.ok(produtos);
    }

    @GetMapping("/categoria/{nomeCategoria}")
    public ResponseEntity<List<DadosListagemProduto>> buscarPorNomeDaCategoria(@PathVariable String nomeCategoria) {
        List<DadosListagemProduto> produtos = produtoService.listarPorNomeCategoria(nomeCategoria);
        return ResponseEntity.ok(produtos);
    }

    @PutMapping
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
