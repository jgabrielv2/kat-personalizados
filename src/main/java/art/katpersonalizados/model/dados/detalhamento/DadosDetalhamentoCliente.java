package art.katpersonalizados.model.dados.detalhamento;

import art.katpersonalizados.model.entity.Cliente;
import art.katpersonalizados.model.entity.DadosPessoais;
import art.katpersonalizados.model.entity.Endereco;

import java.util.List;

public record DadosDetalhamentoCliente(Long id, String username, DadosPessoais dadosPessoais, List<Endereco> enderecos) {

    public DadosDetalhamentoCliente(Cliente c){
        this(c.getId(), c.getUsername(), c.getDadosPessoais(), c.getEnderecos());
    }

}
