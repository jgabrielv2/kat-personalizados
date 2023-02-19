package art.katpersonalizados.repository;

import art.katpersonalizados.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    Categoria findByNomeIgnoreCase(String nome);

}