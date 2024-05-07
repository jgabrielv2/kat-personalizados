package art.katpersonalizados.model.dados;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * A DTO for the {@link art.katpersonalizados.model.entity.DadosPessoais} entity
 */
public record DadosPessoaisDto(@NotBlank String firstName, @NotBlank String lastName,
                               @Email String email, @CPF String cpf,
                               String telefone,
                               @NotBlank String celular, @NotNull LocalDate dataNascimento) implements Serializable {
}