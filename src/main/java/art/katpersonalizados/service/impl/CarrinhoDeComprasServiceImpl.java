package art.katpersonalizados.service.impl;

import art.katpersonalizados.dto.CarrinhoDeComprasDto;
import art.katpersonalizados.model.CarrinhoDeCompras;
import art.katpersonalizados.model.entity.Produto;
import art.katpersonalizados.service.CarrinhoDeComprasService;
import art.katpersonalizados.service.ProdutoService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@SuppressWarnings("ClassHasNoToStringMethod")
@Service
public class CarrinhoDeComprasServiceImpl implements CarrinhoDeComprasService {

    private final CarrinhoDeCompras carrinho;

    private final ProdutoService produtoService;

    public CarrinhoDeComprasServiceImpl(CarrinhoDeCompras carrinho, ProdutoService produtoService){
        this.carrinho = carrinho;
        this.produtoService = produtoService;
    }

    @Override
    public ResponseEntity<String> adicionarItemNoCarrinho(Long id, int quantidade) {
        Produto p = produtoService.buscarPorId(id).getBody();
        if (p == null){
            return ResponseEntity.notFound().build();
        }
        carrinho.adicionaItem(p, quantidade);
        return ResponseEntity.ok("Produto adicionado ao carrinho.");
    }

    @Override
    public ResponseEntity<String> atualizarQuantidadedoItem(Long id, int quantidade) {
        Produto p = produtoService.buscarPorId(id).getBody();
        if (p == null){
            return ResponseEntity.notFound().build();
        }
        carrinho.atualizarQuantidadeDoItem(p, quantidade);
        return ResponseEntity.ok("Quantidade do item atualizada.");
    }

    @Override
    public ResponseEntity<String> removerItemDoCarrinho(Long id) {
        Produto p = produtoService.buscarPorId(id).getBody();
        if (p == null){
            return ResponseEntity.notFound().build();
        }
        carrinho.removerItem(p);
        return ResponseEntity.ok("Produto removido do carrinho.");
    }

    @Override
    public ResponseEntity<CarrinhoDeComprasDto> getCarrinhoDeCompras() {
        return ResponseEntity.ok(new CarrinhoDeComprasDto(carrinho));
    }

    @Override
    public ResponseEntity<String> esvaziarCarrinho() {
        carrinho.clear();
        return ResponseEntity.ok("Carrinho esvaziado");
    }

    @Override
    public ResponseEntity<BigDecimal> getSubTotal() {
        return ResponseEntity.ok(carrinho.getSubTotal());
    }
}
