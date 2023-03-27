package art.katpersonalizados.controller;

import art.katpersonalizados.model.dados.atualizacao.DadosAtualizacaoCliente;
import art.katpersonalizados.model.dados.cadastro.DadosCadastroCliente;
import art.katpersonalizados.model.dados.detalhamento.DadosDetalhamentoCliente;
import art.katpersonalizados.model.dados.listagem.DadosListagemCliente;
import art.katpersonalizados.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@SuppressWarnings("ClassHasNoToStringMethod")
@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    public ResponseEntity<DadosDetalhamentoCliente> salvar(@RequestBody @Valid DadosCadastroCliente dados, UriComponentsBuilder uriComponentsBuilder) {

        var cliente = clienteService.salvar(dados);
        var uri = uriComponentsBuilder.path("/clientes/{id}")
                .buildAndExpand(cliente.id()).toUri();
        return ResponseEntity.created(uri).body(cliente);
    }

    @GetMapping("/busca/{cpf}")
    public ResponseEntity<DadosDetalhamentoCliente> buscarPorCpf(@PathVariable String cpf) {
        var cliente = clienteService.buscarPorCpf(cpf);
        return ResponseEntity.ok(cliente);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalhamentoCliente> buscarPorId(@PathVariable Long id) {
        var cliente = clienteService.buscarPorId(id);
        return ResponseEntity.ok(cliente);
    }

    @GetMapping
    public ResponseEntity<List<DadosListagemCliente>> buscarTodos() {
        var clientes = clienteService.buscarTodos();
        return ResponseEntity.ok(clientes);
    }

    @PutMapping
    public ResponseEntity<DadosDetalhamentoCliente> atualizar(@RequestBody @Valid DadosAtualizacaoCliente dados) {
        var cliente = clienteService.atualizar(dados);
        return ResponseEntity.ok(cliente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        clienteService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
