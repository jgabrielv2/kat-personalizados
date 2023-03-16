package art.katpersonalizados.service.impl;

import art.katpersonalizados.model.CarrinhoDeCompras;
import art.katpersonalizados.model.dados.CarrinhoDeComprasDto;
import art.katpersonalizados.model.dados.RequisicaoItemDoCarrinhoDto;
import art.katpersonalizados.model.entity.Produto;
import art.katpersonalizados.repository.ProdutoRepository;
import art.katpersonalizados.service.CarrinhoDeComprasService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@SuppressWarnings("ClassHasNoToStringMethod")
@Service
public class CarrinhoDeComprasServiceImpl implements CarrinhoDeComprasService {

    private final CarrinhoDeCompras carrinho;

    private final ProdutoRepository produtoRepository;

    public CarrinhoDeComprasServiceImpl(CarrinhoDeCompras carrinho, ProdutoRepository produtoRepository) {
        this.carrinho = carrinho;
        this.produtoRepository = produtoRepository;
    }

    @Override
    public ResponseEntity<String> adicionarItemNoCarrinho(RequisicaoItemDoCarrinhoDto requisicaoItemDoCarrinhoDto) {
        Produto p = produtoRepository.getReferenceById(requisicaoItemDoCarrinhoDto.getIdProduto());
        if (p == null) {
            return ResponseEntity.notFound().build();
        }
        carrinho.adicionaItem(p, requisicaoItemDoCarrinhoDto.getQuantidade());
        return ResponseEntity.ok("Produto adicionado ao carrinho.");
    }

    @Override
    public ResponseEntity<String> atualizarQuantidadedoItem(RequisicaoItemDoCarrinhoDto requisicaoItemDoCarrinhoDto) {
        Produto p = produtoRepository.findById(requisicaoItemDoCarrinhoDto.getIdProduto()).get();
        if (p == null) {
            return ResponseEntity.notFound().build();
        }
        carrinho.atualizarQuantidadeDoItem(p, requisicaoItemDoCarrinhoDto.getQuantidade());
        return ResponseEntity.ok("Quantidade do item atualizada.");
    }

    @Override
    public ResponseEntity<String> removerItemDoCarrinho(Long id) {
        Produto p = produtoRepository.findById(id).get();
        if (p == null) {
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
