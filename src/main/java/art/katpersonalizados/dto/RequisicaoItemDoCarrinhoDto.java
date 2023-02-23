package art.katpersonalizados.dto;


import art.katpersonalizados.model.ItemDoCarrinho;

/**
 * A classe {@link RequisicaoItemDoCarrinhoDto} serve como um objeto de transferência de dados (DTO)
 * para representar os dados de um item que será adicionado ao carrinho de compras. Ela é uti-
 * lizada para receber as informações enviadas pelo cliente no corpo da requisição (por meio
 * do método POST, por exemplo) e transformá-las em um objeto {@link ItemDoCarrinho} que será utilizado
 * pelo serviço para adicionar o item ao carrinho. Isso permite que o código cliente (frontend)
 * e o código servidor (backend) utilizem estruturas de dados diferentes e independam da repre-
 * sentação interna utilizada pelo outro. Além disso, o DTO também pode ser utilizado para de-
 * finir um contrato claro de comunicação entre as partes envolvidas no processo, facilitando
 * a manutenção e evolução do sistema.
 */
@SuppressWarnings({"ClassHasNoToStringMethod", "unused"})
public class RequisicaoItemDoCarrinhoDto {

    private Long idProduto;

    private int quantidade;

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
