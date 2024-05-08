package art.katpersonalizados.model.dados.atualizacao;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

public record DadosAtualizacaoEndereco(String cep, String logradouro,
                                       String complemento, String bairro, String localidade, String uf, String numero){
}