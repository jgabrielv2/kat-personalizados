package art.katpersonalizados.controller;

import art.katpersonalizados.model.dados.CarrinhoDeComprasDto;
import art.katpersonalizados.model.dados.RequisicaoItemDoCarrinhoDto;
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
    public ResponseEntity<String> adicionarItem(@RequestBody RequisicaoItemDoCarrinhoDto requisicaoItemDoCarrinhoDto){
        return carrinhoDeComprasService.adicionarItemNoCarrinho(requisicaoItemDoCarrinhoDto);
    }

    @PutMapping("/update")
    public ResponseEntity<String> atualizarItem(@RequestBody RequisicaoItemDoCarrinhoDto requisicaoItemDoCarrinhoDto){
        return carrinhoDeComprasService.atualizarQuantidadedoItem(requisicaoItemDoCarrinhoDto);
    }

    @DeleteMapping("/remove")
    public ResponseEntity<String> removerItem(@RequestParam Long id){
        return carrinhoDeComprasService.removerItemDoCarrinho(id);
    }

    @GetMapping("/view")
    public ResponseEntity<CarrinhoDeComprasDto> mostrarItensNoCarrinho(){
        return carrinhoDeComprasService.getCarrinhoDeCompras();
    }

    @DeleteMapping("/clear")
    public ResponseEntity<String> esvaziarCarrinho(){
        return carrinhoDeComprasService.esvaziarCarrinho();
    }

    @GetMapping("/subtotal")
    public ResponseEntity<BigDecimal> mostrarSubTotal(){
        return carrinhoDeComprasService.getSubTotal();
    }
}
