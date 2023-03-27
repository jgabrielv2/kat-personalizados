package art.katpersonalizados.model.entity;

import art.katpersonalizados.model.dados.DadosEndereco;
import jakarta.persistence.Embeddable;

@SuppressWarnings("unused")
@Embeddable
public class Endereco {


    private String cep;

    private String logradouro;

    private String complemento;

    private String bairro;

    private String localidade;

    private String uf;

    private String numero;

    public Endereco(DadosEndereco dados) {
        this.cep = dados.cep();
        this.logradouro = dados.logradouro();
        this.complemento = dados.complemento();
        this.bairro = dados.bairro();
        this.localidade = dados.localidade();
        this.uf = dados.uf();
        this.numero = dados.numero();
    }

    public Endereco() {

    }


    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNumero() {
        return numero;
    }

    @Override
    public String toString() {
        return "Endereco{" +
                "cep='" + cep + '\'' +
                ", logradouro='" + logradouro + '\'' +
                ", complemento='" + complemento + '\'' +
                ", bairro='" + bairro + '\'' +
                ", localidade='" + localidade + '\'' +
                ", uf='" + uf + '\'' +
                ", numero='" + numero + '\'' +
                '}';
    }
}
