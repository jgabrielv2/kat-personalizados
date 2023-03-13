package art.katpersonalizados.service;

import art.katpersonalizados.model.dados.CarrinhoDeComprasDto;
import art.katpersonalizados.model.dados.RequisicaoItemDoCarrinhoDto;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;

public interface    CarrinhoDeComprasService {

    ResponseEntity<String> adicionarItemNoCarrinho(RequisicaoItemDoCarrinhoDto requisicaoItemDoCarrinhoDto);

    ResponseEntity<String> atualizarQuantidadedoItem(RequisicaoItemDoCarrinhoDto requisicaoItemDoCarrinhoDto);

    ResponseEntity<String> removerItemDoCarrinho(Long id);

    ResponseEntity<CarrinhoDeComprasDto> getCarrinhoDeCompras();

    ResponseEntity<String> esvaziarCarrinho();

    ResponseEntity<BigDecimal> getSubTotal();
}
