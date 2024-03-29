package art.katpersonalizados.repository;

import art.katpersonalizados.model.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Optional<Cliente> findByDadosPessoais_Cpf(String cpf);

    List<Cliente> findByAtivoTrue();



}
