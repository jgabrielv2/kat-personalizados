package art.katpersonalizados.model.dados.detalhamento;

import art.katpersonalizados.model.entity.Cliente;
import art.katpersonalizados.model.entity.DadosPessoais;
import art.katpersonalizados.model.entity.Endereco;

public record DadosDetalhamentoCliente(Long id, String username, DadosPessoais dadosPessoais, Endereco endereco) {

    public DadosDetalhamentoCliente(Cliente c){
        this(c.getId(), c.getUsername(), c.getDadosPessoais(), c.getEndereco());
    }

}
