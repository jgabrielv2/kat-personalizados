package art.katpersonalizados.model;

import art.katpersonalizados.model.entity.Produto;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CarrinhoDeCompras {

    // lista de ItemDoCarrinho que representam os itens do carrinho de compras.
    private final List<ItemDoCarrinho> itens = new ArrayList<>();

    public List<ItemDoCarrinho> getItens() {
        return itens;
    }

    public int getSize() {
        return itens.size();
    }

    public BigDecimal getTotal() {
        BigDecimal total = BigDecimal.ZERO;
        for (ItemDoCarrinho item : itens) {
            total = total.add(item.getTotal());
        }
        return total;
    }

    //  Adiciona um item ao carrinho de compras
    public void adicionaItem(Produto p, int quantidade) {

        // percorre todos os itens existentes no carrinho de compras
        for (ItemDoCarrinho item : itens) {
            // verifica se o Produto passado como parâmetro já existe no carrinho de compras,
            // comparando os IDs do produto já existente no carrinho de compras com o ID do novo produto passado como parâmetro
            if (item.getProduto().getId().equals(p.getId())) {

                // Se um produto correspondente for encontrado, o método atualiza a quantidade
                // desse item no carrinho de compras adicionando a quantidade passada como parâmetro à quantidade existente do item
                item.setQuantidade(item.getQuantidade() + quantidade);
                return;
            }
        }
        // Se nenhum produto correspondente for encontrado no carrinho de compras, o método adiciona um novo
        // objeto ItemDoCarrinho à lista items com o novo Produto e quantidade passados como parâmetros
        itens.add(new ItemDoCarrinho(p, quantidade));
    }

    // remove um item específico do carrinho de compras com base no objeto Produto passado como parâmetro
    public void removerItem(Produto p) {
        // verifica se o ID do produto do item do carrinho de compras é igual ao ID do produto passado como parâmetro.
        // Se a condição for true, o item correspondente é removido da lista de itens.
        itens.removeIf(item -> item.getProduto().getId().equals(p.getId()));
    }

    // atualiza um a quantidde de um item específico, com base no objeto Produto e quantidade, passados como parâmetros.
    public void atualizarQuantidadeDoItem(Produto p, int quantidade) {
        for (ItemDoCarrinho item : itens) {

            // percorre a lista de itens, verificando se há algum produto com o idProduto do produto passado como parâmetro
            if (item.getProduto().getId().equals(p.getId())) {
                item.setQuantidade(quantidade);
                return;
            }
        }
    }

    /**
     * Esse método getSubtotal() é responsável por calcular o subtotal do carrinho de compras,
     * que é a soma do preço de cada produto multiplicado pela quantidade correspondente.
     *
     * Primeiramente, o método usa o método stream() da classe List para criar um fluxo de dados
     * dos itens do carrinho de compras. Em seguida, ele chama o método map() do fluxo para
     * transformar cada item em um valor correspondente ao preço do produto multiplicado pela
     * quantidade. Isso é feito utilizando uma expressão lambda que acessa o produto e sua
     * quantidade no item, multiplicando esses valores com o método multiply() da classe BigDecimal.
     *
     * Depois, o método reduce() é chamado para reduzir todos os valores do fluxo em um único valor. O primeiro argumento do método reduce() é o valor inicial para a operação de redução, que nesse caso é BigDecimal.ZERO, ou seja, o valor zero da classe BigDecimal. O segundo argumento é uma expressão lambda que realiza a operação de adição dos valores. Essa operação de adição é feita utilizando o método add() da classe BigDecimal.
     *
     * @return resultado da operação de redução, que é o subtotal do carrinho de compras.
     */
    public BigDecimal getSubTotal(){
        return itens.stream()
                .map(item -> item.getProduto().getPreco().multiply(BigDecimal.valueOf(item.getQuantidade())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    // esvazia a lista de itens
    public void clear() {
        itens.clear();
    }

}
