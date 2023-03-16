package art.katpersonalizados.controller;

import art.katpersonalizados.model.dados.atualizacao.DadosAtualizacaoCategoria;
import art.katpersonalizados.model.dados.cadastro.DadosCadastroCategoria;
import art.katpersonalizados.model.dados.detalhamento.DadosDetalhamentoCategoria;
import art.katpersonalizados.model.dados.listagem.DadosListagemCategoria;
import art.katpersonalizados.service.CategoriaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@SuppressWarnings("ClassHasNoToStringMethod")
@RestController
@RequestMapping("categorias")
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @PostMapping
    public ResponseEntity<DadosListagemCategoria> salvar(@RequestBody @Valid DadosCadastroCategoria dadosCadastroCategoria, UriComponentsBuilder uriComponentsBuilder) {
        DadosListagemCategoria categoria = categoriaService.salvar(dadosCadastroCategoria);
        var uri = uriComponentsBuilder.path("/categorias/{id}").buildAndExpand(categoria.id()).toUri();
        return ResponseEntity.created(uri).body(categoria);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalhamentoCategoria> buscarPorId(@PathVariable Long id) {
        DadosDetalhamentoCategoria categoria = categoriaService.detalhar(id);
        return ResponseEntity.ok(categoria);
    }

    @GetMapping
    public ResponseEntity<List<DadosListagemCategoria>> listar() {
        List<DadosListagemCategoria> categorias = categoriaService.listar();
        return ResponseEntity.ok(categorias);
    }

    @PutMapping
    public ResponseEntity<DadosDetalhamentoCategoria> atualizar(@RequestBody @Valid DadosAtualizacaoCategoria dados) {
        DadosDetalhamentoCategoria categoria = categoriaService.atualizar(dados);
        return ResponseEntity.ok(categoria);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        categoriaService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
