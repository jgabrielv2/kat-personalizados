package art.katpersonalizados.repository;

import art.katpersonalizados.model.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {


    List<Produto> findByCategoria_NomeIgnoreCase(String nome);

    List<Produto> findByDescricaoContainsIgnoreCase(String descricao);


}