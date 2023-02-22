package art.katpersonalizados.controller;

import art.katpersonalizados.dto.ProdutoDto;
import art.katpersonalizados.model.CarrinhoDeCompras;
import art.katpersonalizados.model.entity.Produto;
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
    private final CarrinhoDeCompras carrinhoDeCompras;

    public ProdutoController(ProdutoService produtoService, CarrinhoDeCompras carrinhoDeCompras) {
        this.produtoService = produtoService;
        this.carrinhoDeCompras = carrinhoDeCompras;
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

    public ResponseEntity<Produto> adicionarAoCarrinho(Long id, int quantidade) {
        Produto p = produtoService.buscarPorId(id).getBody();
        if (p == null) {
            return ResponseEntity.notFound().build();
        }

        public void removerDoCarrinho (Long id){
            Produto p = produtoService.buscarPorId(id).getBody();
            if (p != null) {
                carrinhoDeCompras.removerItem(p);
            }
        }
    }
