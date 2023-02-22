package art.katpersonalizados.controller;

import art.katpersonalizados.dto.ProdutoDto;
import art.katpersonalizados.model.Produto;
import art.katpersonalizados.service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<Produto> salvar(@RequestBody @Valid ProdutoDto produtoDto) {
        return produtoService.salvar(produtoDto);
    }

    @PostMapping("/adicionar")
    public ResponseEntity<List<Produto>> salvarTodos(@RequestBody List<ProdutoDto> produtosDto) {
        return produtoService.salvarTodos(produtosDto);
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
    public ResponseEntity<List<Produto>> buscarTodos() {
        return produtoService.buscarTodos();
    }

    @GetMapping("/categoria/{nomeCategoria}")
    public ResponseEntity<List<Produto>> buscarPorNomeDaCategoria(@PathVariable String nomeCategoria) {
        return produtoService.buscarPorNomeCategoria(nomeCategoria);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> atualizar(@PathVariable Long id, @RequestBody @Valid ProdutoDto produtoDto) {
        return produtoService.atualizar(id, produtoDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        produtoService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
