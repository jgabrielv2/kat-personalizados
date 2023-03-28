package art.katpersonalizados.repository;

import art.katpersonalizados.model.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    Categoria findByNomeIgnoreCase(String nome);

    List<Categoria> findByAtivoTrue();



}