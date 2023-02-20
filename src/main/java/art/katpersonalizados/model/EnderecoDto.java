package art.katpersonalizados.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link Endereco} entity
 */
public class EnderecoDto implements Serializable {
    @NotBlank
    private final String cep;
    @NotBlank
    @Size(max = 100)
    private final String logradouro;
    @NotBlank
    @Size(max = 100)
    private final String complemento;
    @NotBlank
    @Size(max = 20)
    private final String bairro;
    @NotBlank
    @Size(max = 20)
    private final String localidade;
    @NotBlank
    @Size(max = 20)
    private final String uf;
    private final Cliente cliente;

    public EnderecoDto(String cep, String logradouro, String complemento, String bairro, String localidade, String uf, Cliente cliente) {
        this.cep = cep;
        this.logradouro = logradouro;
        this.complemento = complemento;
        this.bairro = bairro;
        this.localidade = localidade;
        this.uf = uf;
        this.cliente = cliente;
    }

    public String getCep() {
        return cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public String getLocalidade() {
        return localidade;
    }

    public String getUf() {
        return uf;
    }

    public Cliente getCliente() {
        return cliente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EnderecoDto entity = (EnderecoDto) o;
        return Objects.equals(this.cep, entity.cep) &&
                Objects.equals(this.logradouro, entity.logradouro) &&
                Objects.equals(this.complemento, entity.complemento) &&
                Objects.equals(this.bairro, entity.bairro) &&
                Objects.equals(this.localidade, entity.localidade) &&
                Objects.equals(this.uf, entity.uf) &&
                Objects.equals(this.cliente, entity.cliente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cep, logradouro, complemento, bairro, localidade, uf, cliente);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "cep = " + cep + ", " +
                "logradouro = " + logradouro + ", " +
                "complemento = " + complemento + ", " +
                "bairro = " + bairro + ", " +
                "localidade = " + localidade + ", " +
                "uf = " + uf + ", " +
                "cliente = " + cliente + ")";
    }
}