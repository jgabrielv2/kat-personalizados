package art.katpersonalizados.dto;

import art.katpersonalizados.model.ItemDoCarrinho;

import java.math.BigDecimal;

@SuppressWarnings({"ClassHasNoToStringMethod", "unused"})
public class ItemDoCarrinhoDto {

    private Long idProduto;

    private String descricaoProduto;

    private BigDecimal preco;

    private int quantidade;

    public ItemDoCarrinhoDto(ItemDoCarrinho item){
        this.idProduto = item.getProduto().getId();
        this.descricaoProduto = item.getProduto().getDescricao();
        this.preco = item.getProduto().getPreco();
        this.quantidade = item.getQuantidade();
    }

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
