package art.katpersonalizados.model.entity;

import art.katpersonalizados.model.dados.cadastro.DadosCadastroCliente;
import jakarta.persistence.*;

import java.util.Objects;

@Entity(name = "Cliente")
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    @Embedded
    private DadosPessoais dadosPessoais;

    @Embedded
    private Endereco endereco;

    private Boolean ativo;


    public Cliente(DadosCadastroCliente dados) {
        this.ativo = true;
        this.username = dados.username();
        this.dadosPessoais = new DadosPessoais(dados.dadosPessoais());
        this.endereco = new Endereco(dados.endereco());
    }

    public Cliente() {

    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public DadosPessoais getDadosPessoais() {
        return dadosPessoais;
    }

    public void setDadosPessoais(DadosPessoais dadosPessoais) {
        this.dadosPessoais = dadosPessoais;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cliente cliente)) return false;

        return Objects.equals(id, cliente.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", dadosPessoais=" + dadosPessoais +
                ", endereco=" + endereco +
                ", ativo=" + ativo +
                '}';
    }
}