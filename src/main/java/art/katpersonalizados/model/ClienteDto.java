package art.katpersonalizados.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * A DTO for the {@link Cliente} entity
 */
public class ClienteDto implements Serializable {
    @NotBlank
    @Size(max = 100)
    private final String nome;
    @NotBlank
    @Size(max = 100)
    private final String sobrenome;
    @NotBlank
    @Pattern(regexp = "\\(\\d{2}\\)\\d{5}-\\d{4}", message = "O número de telefone deve estar no formato (XX)XXXXX-XXXX")
    private final String telefone;
    @NotBlank
    @Email
    @Size(max = 100)
    private final String email;
    @NotBlank
    @Pattern(regexp = "\\d{11}")
    private final String cpf;
    private final List<Endereco> enderecos;

    public ClienteDto(String nome, String sobrenome, String telefone, String email, String cpf, List<Endereco> enderecos) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.telefone = telefone;
        this.email = email;
        this.cpf = cpf;
        this.enderecos = enderecos;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public String getCpf() {
        return cpf;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClienteDto entity = (ClienteDto) o;
        return Objects.equals(this.nome, entity.nome) &&
                Objects.equals(this.sobrenome, entity.sobrenome) &&
                Objects.equals(this.telefone, entity.telefone) &&
                Objects.equals(this.email, entity.email) &&
                Objects.equals(this.cpf, entity.cpf) &&
                Objects.equals(this.enderecos, entity.enderecos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, sobrenome, telefone, email, cpf, enderecos);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "nome = " + nome + ", " +
                "sobrenome = " + sobrenome + ", " +
                "telefone = " + telefone + ", " +
                "email = " + email + ", " +
                "cpf = " + cpf + ", " +
                "enderecos = " + enderecos + ")";
    }
}