package art.katpersonalizados.controller;

import art.katpersonalizados.model.dados.atualizacao.DadosAtualizacaoEndereco;
import art.katpersonalizados.model.dados.cadastro.DadosCadastroEndereco;
import art.katpersonalizados.model.dados.detalhamento.DadosDetalhamentoEndereco;
import art.katpersonalizados.model.dados.listagem.DadosListagemEndereco;
import art.katpersonalizados.service.EnderecoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

    private final EnderecoService enderecoService;

    public EnderecoController(EnderecoService enderecoService) {
        this.enderecoService = enderecoService;
    }

    @PostMapping
    public ResponseEntity<DadosDetalhamentoEndereco> salvar(@RequestBody @Valid DadosCadastroEndereco dados, UriComponentsBuilder uriComponentsBuilder) {
        var endereco = enderecoService.salvar(dados);
        var uri = uriComponentsBuilder.path("/endereco/{id}")
                .buildAndExpand(endereco.id()).toUri();
        return ResponseEntity.created(uri).body(endereco);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalhamentoEndereco> buscarPorId(@PathVariable Long id) {
        var endereco = enderecoService.buscarPorId(id);
        return ResponseEntity.ok(endereco);
    }

    @GetMapping
    public ResponseEntity<List<DadosListagemEndereco>> buscarTodos(){
        var enderecos = enderecoService.buscarTodos();
        return ResponseEntity.ok(enderecos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DadosDetalhamentoEndereco> atualizar (@RequestBody @Valid DadosAtualizacaoEndereco dados, @PathVariable Long id){
        var endereco = enderecoService.atualizar(dados, id);
        return ResponseEntity.ok(endereco);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id){
        enderecoService.excluir(id);
        return ResponseEntity.noContent().build();
    }

}
