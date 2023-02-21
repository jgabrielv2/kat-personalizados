package art.katpersonalizados.controller;

import art.katpersonalizados.dto.CategoriaDto;
import art.katpersonalizados.model.Categoria;
import art.katpersonalizados.service.CategoriaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SuppressWarnings("ClassHasNoToStringMethod")
@RestController
@RequestMapping("categorias")
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService){
        this.categoriaService = categoriaService;
    }

    @PostMapping
    public ResponseEntity<Categoria> salvar(@RequestBody @Valid CategoriaDto categoriaDto){
        return categoriaService.salvar(categoriaDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> buscarPorId(@PathVariable Long id){
        return categoriaService.buscarPorId(id);
    }

    @GetMapping("/{nome}")
    public ResponseEntity<Categoria> buscarPorNome(@PathVariable String nome){
        return categoriaService.buscarPorNome(nome);
    }

    @GetMapping
    public ResponseEntity<List<Categoria>> buscarTodos(){
        return categoriaService.buscarTodos();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categoria> atualizar (@PathVariable Long id, @RequestBody @Valid CategoriaDto categoriaDto){
        return categoriaService.atualizar(id, categoriaDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id){
        categoriaService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
