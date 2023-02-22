package art.katpersonalizados.service.impl;

import art.katpersonalizados.exception.NotFoundException;
import art.katpersonalizados.model.entity.Cliente;
import art.katpersonalizados.dto.ClienteDto;
import art.katpersonalizados.model.entity.Endereco;
import art.katpersonalizados.dto.EnderecoDto;
import art.katpersonalizados.repository.ClienteRepository;
import art.katpersonalizados.service.ClienteService;
import art.katpersonalizados.validator.TelefoneValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("ClassHasNoToStringMethod")
@Service
public class ClienteServiceImpl implements ClienteService {

    // Constante para o status HTTP 404 not fouund
    private static final HttpStatus NOT_FOUND = HttpStatus.NOT_FOUND;
    private final ClienteRepository clienteRepository;

    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    // Cria um novo Cliente, salva e retorna um status HTTP

    @Override
    public ResponseEntity<Cliente> salvar(ClienteDto clienteDto) {


        EnderecoDto enderecoDto = clienteDto.endereco();
        Endereco e = new Endereco();
        e.setLogradouro(enderecoDto.logradouro());
        e.setCep(enderecoDto.cep());
        e.setComplemento(enderecoDto.complemento());
        e.setBairro(enderecoDto.bairro());
        e.setLocalidade(enderecoDto.localidade());
        e.setUf(enderecoDto.uf());

        String telefone = clienteDto.telefone();
        if (!TelefoneValidator.isValid(telefone)) {
            throw new IllegalArgumentException("Número de telefone inválido");
        }

        Cliente c = new Cliente();
        c.setCpf(clienteDto.cpf());
        c.setNome(clienteDto.nome());
        c.setSobrenome(clienteDto.sobrenome());
        c.setTelefone(telefone);
        c.setEmail(clienteDto.email());
        c.setEndereco(e);

        return ResponseEntity.ok(c);
    }

    // Busca um Cliente, dado o cpf informado. Se não houver, é lançada uma NotFoundException
    @Override
    public ResponseEntity<Cliente> buscarPorCpf(String cpf) {
        Optional<Cliente> optionalCliente = clienteRepository.findByCpf(cpf);
        return optionalCliente.map(ResponseEntity::ok).orElseThrow(() -> new NotFoundException("Cliente não encontrado com o CPF informado."));
    }

    // Busca um Cliente, dado o id informado. Se não houver, é lançada uma NotFoundException
    @Override
    public ResponseEntity<Cliente> buscarPorId(Long id) {
        Optional<Cliente> optionalCliente = clienteRepository.findById(id);
        return optionalCliente.map(ResponseEntity::ok).orElseThrow(() -> new NotFoundException("Cliente não encontrado com o id " + id));
    }

    // Lista de Clientes cadastrados. Se não houver, retorna o HTTP status Not Found
    @Override
    public ResponseEntity<List<Cliente>> buscarTodos() {
        List<Cliente> clientes = clienteRepository.findAll();
        if (clientes.isEmpty()) {
            return ResponseEntity.status(NOT_FOUND).build();
        }
        return ResponseEntity.ok(clientes);
    }

    // Atualiza o Cliente, dado o id informado.
    @Override
    public ResponseEntity<Cliente> atualizar(Long id, ClienteDto clienteDto) {
        Cliente c = clienteRepository.findById(id).orElseThrow(() -> new NotFoundException("Cliente não encontrado com a id " + id));

        String telefone = clienteDto.telefone();
        if (!TelefoneValidator.isValid(telefone)) {
            throw new IllegalArgumentException("Número de telefone inválido");
        }

        c.setNome(clienteDto.nome());
        c.setSobrenome(clienteDto.sobrenome());
        c.setEmail(clienteDto.email());
        c.setTelefone(clienteDto.telefone());

        EnderecoDto enderecoDto = clienteDto.endereco();
        Endereco e = c.getEndereco();
        e.setLogradouro(enderecoDto.logradouro());
        e.setCep(enderecoDto.cep());
        e.setComplemento(enderecoDto.complemento());
        e.setBairro(enderecoDto.bairro());
        e.setLocalidade(enderecoDto.localidade());
        e.setUf(enderecoDto.uf());


        return ResponseEntity.ok(c);


    }

    //    Excliu o Cliente, dado o Id informado
    @Override
    public void excluir(Long id) {
        if (!clienteRepository.existsById(id)) {
            throw new NotFoundException("Cliente não encontrado com a id " + id);
        } else {
            clienteRepository.deleteById(id);
        }

    }
}
