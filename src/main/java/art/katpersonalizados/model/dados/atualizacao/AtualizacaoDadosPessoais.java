package art.katpersonalizados.model.dados.atualizacao;

import jakarta.validation.constraints.Email;

public record AtualizacaoDadosPessoais(@Email String email, String telefone,
                                       String celular) {
}
