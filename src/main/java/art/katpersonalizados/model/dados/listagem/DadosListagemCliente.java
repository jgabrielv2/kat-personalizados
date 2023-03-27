package art.katpersonalizados.model.dados.listagem;

import art.katpersonalizados.model.entity.Cliente;

public record DadosListagemCliente(Long id, String username) {
    public DadosListagemCliente(Cliente c){
        this(c.getId(), c.getUsername());
    }
}
