package art.katpersonalizados.controller;

import art.katpersonalizados.dto.CarrinhoDeComprasDto;
import art.katpersonalizados.service.CarrinhoDeComprasService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@SuppressWarnings("ClassHasNoToStringMethod")
@RestController
@RequestMapping("/carrinho")
public class CarrinhoDeComprasController {

    private final CarrinhoDeComprasService carrinhoDeComprasService;

    public CarrinhoDeComprasController(CarrinhoDeComprasService carrinhoDeComprasService){
        this.carrinhoDeComprasService = carrinhoDeComprasService;
    }

    @PostMapping("/add")
    public ResponseEntity<String> adicionarItem(@RequestParam Long id, @RequestParam int quantidade){
        return carrinhoDeComprasService.adicionarItemNoCarrinho(id, quantidade);
    }

    @PutMapping("/update")
    public ResponseEntity<String> atualizarItem(@RequestParam Long id, @RequestParam int quantidade){
        return carrinhoDeComprasService.atualizarQuantidadedoItem(id, quantidade);
    }

    @DeleteMapping
    public ResponseEntity<String> removerItem(Long id){
        return carrinhoDeComprasService.removerItemDoCarrinho(id);
    }

    @GetMapping
    public ResponseEntity<CarrinhoDeComprasDto> mostrarItensNoCarrinho(){
        return carrinhoDeComprasService.getCarrinhoDeCompras();
    }

    @DeleteMapping
    public ResponseEntity<String> esvaziarCarrinho(){
        return carrinhoDeComprasService.esvaziarCarrinho();
    }

    @GetMapping
    public ResponseEntity<BigDecimal> mostrarSubTotal(){
        return carrinhoDeComprasService.getSubTotal();
    }
}
