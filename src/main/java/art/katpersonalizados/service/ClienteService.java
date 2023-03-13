package art.katpersonalizados.service;

import art.katpersonalizados.model.entity.Cliente;
import art.katpersonalizados.model.dados.ClienteDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ClienteService {

    ResponseEntity<Cliente> salvar(ClienteDto clienteDto);

    ResponseEntity<Cliente> buscarPorCpf(String cpf);

    ResponseEntity<Cliente> buscarPorId(Long id);

    ResponseEntity<List<Cliente>> buscarTodos();

    ResponseEntity<Cliente> atualizar(Long id, ClienteDto clienteDto);

    void excluir(Long id);

}
