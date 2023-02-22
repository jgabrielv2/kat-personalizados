package art.katpersonalizados.service;

import art.katpersonalizados.model.ItemDoCarrinho;
import art.katpersonalizados.model.entity.Produto;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.util.List;

public interface CarrinhoDeComprasService {

    ResponseEntity<String> adicionarItemNoCarrinho(Long id, int quantidade);

    ResponseEntity<Void> atualizarQuantidadedoItem(Long id, int quantidade);

    ResponseEntity<Void> removerItemDoCarrinho(Long id);

    void esvaziarCarrinho();

    ResponseEntity<List<ItemDoCarrinho>> getItens();

    BigDecimal getSubTotal();
}
