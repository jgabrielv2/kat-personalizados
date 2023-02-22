package art.katpersonalizados.service;

import art.katpersonalizados.dto.CarrinhoDeComprasDto;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;

public interface CarrinhoDeComprasService {

    ResponseEntity<String> adicionarItemNoCarrinho(Long id, int quantidade);

    ResponseEntity<String> atualizarQuantidadedoItem(Long id, int quantidade);

    ResponseEntity<String> removerItemDoCarrinho(Long id);

    ResponseEntity<CarrinhoDeComprasDto> getCarrinhoDeCompras();

    ResponseEntity<String> esvaziarCarrinho();

    ResponseEntity<BigDecimal> getSubTotal();
}
