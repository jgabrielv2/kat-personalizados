package art.katpersonalizados.dto;

import art.katpersonalizados.model.Categoria;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * A DTO for the {@link art.katpersonalizados.model.Produto} entity
 */
public class ProdutoDto implements Serializable {
    private final String descricao;
    private final BigDecimal preco;
    private final Categoria categoria;

    public ProdutoDto(String descricao, BigDecimal preco, Categoria categoria) {
        this.descricao = descricao;
        this.preco = preco;
        this.categoria = categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProdutoDto entity = (ProdutoDto) o;
        return Objects.equals(this.descricao, entity.descricao) &&
                Objects.equals(this.preco, entity.preco) &&
                Objects.equals(this.categoria, entity.categoria);
    }

    @Override
    public int hashCode() {
        return Objects.hash(descricao, preco, categoria);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "descricao = " + descricao + ", " +
                "preco = " + preco + ", " +
                "categoria = " + categoria + ")";
    }
}