package art.katpersonalizados.dto;

import art.katpersonalizados.model.entity.Cliente;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

/**
 * A DTO for the {@link Cliente} entity
 */
public record ClienteDto(@NotBlank @Size(max = 100) String nome, @NotBlank @Size(max = 100) String sobrenome,
                         @NotBlank @Pattern(regexp = "\\(\\d{2}\\)\\d{5}-\\d{4}", message = "O número de telefone deve estar no formato (XX)XXXXX-XXXX") String telefone,
                         @NotBlank @Email @Size(max = 100) String email, EnderecoDto endereco,
                         @NotBlank @Pattern(regexp = "\\d{11}") String cpf) implements Serializable {
}