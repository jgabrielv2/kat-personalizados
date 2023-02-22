package art.katpersonalizados.model;

import art.katpersonalizados.model.entity.Produto;

import java.math.BigDecimal;

public class ItemDoCarrinho {

    private Produto produto;

    private int quantidade;

    public ItemDoCarrinho(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getTotal(){
        return produto.getPreco().multiply(BigDecimal.valueOf(quantidade));
    }
}
