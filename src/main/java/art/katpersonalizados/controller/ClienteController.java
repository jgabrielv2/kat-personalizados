package art.katpersonalizados.controller;

import art.katpersonalizados.dto.ClienteDto;
import art.katpersonalizados.model.Cliente;
import art.katpersonalizados.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService){
        this.clienteService = clienteService;
    }

    @PostMapping
    public ResponseEntity<Cliente> salvar(@RequestBody @Valid ClienteDto clienteDto){
        return clienteService.salvar(clienteDto);
    }

    @GetMapping("/busca/{cpf}")
    public ResponseEntity<Cliente> buscarPorCpf(@PathVariable String cpf){
        return clienteService.buscarPorCpf(cpf);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarPorId(@PathVariable Long id){
        return clienteService.buscarPorId(id);
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> buscarTodos(){
        return clienteService.buscarTodos();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizar(@PathVariable Long id, @RequestBody @Valid ClienteDto clienteDto){
        return clienteService.atualizar(id, clienteDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id){
        clienteService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
