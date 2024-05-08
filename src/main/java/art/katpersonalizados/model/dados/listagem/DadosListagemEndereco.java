package art.katpersonalizados.model.dados.listagem;

import art.katpersonalizados.model.entity.Endereco;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record DadosListagemEndereco(String cep, String logradouro, String complemento, String bairro, String localidade, String uf, String numero) {
    public DadosListagemEndereco(Endereco e){
        this(e.getCep(), e.getLogradouro(), e.getComplemento() ,e.getBairro(), e.getLocalidade(), e.getUf(), e.getNumero());
    }

}
