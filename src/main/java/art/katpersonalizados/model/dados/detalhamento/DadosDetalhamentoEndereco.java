package art.katpersonalizados.model.dados.detalhamento;

import art.katpersonalizados.model.entity.Endereco;

public record DadosDetalhamentoEndereco(Long id, String cep, String logradouro, String complemento, String bairro,
                                        String localidade, String uf, String numero) {

    public DadosDetalhamentoEndereco(Endereco e) {
        this(e.getId(), e.getCep(), e.getLogradouro(), e.getComplemento(), e.getBairro(), e.getLocalidade(), e.getUf(), e.getNumero());
    }

}
