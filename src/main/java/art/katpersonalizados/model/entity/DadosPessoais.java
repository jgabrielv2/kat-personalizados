package art.katpersonalizados.model.entity;

import art.katpersonalizados.model.dados.DadosPessoaisDto;
import jakarta.persistence.Embeddable;

import java.time.LocalDate;

@Embeddable
public class DadosPessoais {

    private String firstName;
    private String lastName;
    private String email;
    private String cpf;
    private String telefone;
    private String celular;
    private LocalDate dataNascimento;

    public DadosPessoais(DadosPessoaisDto dados) {
        this.firstName = dados.firstName();
        this.lastName = dados.lastName();
        this.email = dados.email();
        this.cpf = dados.cpf();
        this.telefone = dados.telefone();
        this.celular = dados.celular();
        this.dataNascimento = dados.dataNascimento();
    }

    public DadosPessoais() {

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public String toString() {
        return "DadosPessoais{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", cpf='" + cpf + '\'' +
                ", telefone='" + telefone + '\'' +
                ", celular='" + celular + '\'' +
                ", dataNascimento='" + dataNascimento + '\'' +
                '}';
    }
}
