package art.katpersonalizados.dto;

import art.katpersonalizados.model.CarrinhoDeCompras;

import java.util.List;
import java.util.stream.Collectors;

public class CarrinhoDeComprasDto {
    private List<ItemDoCarrinhoDto> itensDoCarrinhoDto;

    public CarrinhoDeComprasDto(CarrinhoDeCompras carrinhoDeCompras){
        this.itensDoCarrinhoDto = carrinhoDeCompras.getItens().stream().map(ItemDoCarrinhoDto::new).collect
        (Collectors.toList());
    }

    public List<ItemDoCarrinhoDto> getItensDoCarrinhoDto() {
        return itensDoCarrinhoDto;
    }

    public void setItensDoCarrinhoDto(List<ItemDoCarrinhoDto> itensDoCarrinhoDto) {
        this.itensDoCarrinhoDto = itensDoCarrinhoDto;
    }
}
