package art.katpersonalizados.service.impl;

import art.katpersonalizados.model.dados.atualizacao.DadosAtualizacaoCliente;
import art.katpersonalizados.model.dados.cadastro.DadosCadastroCliente;
import art.katpersonalizados.model.dados.detalhamento.DadosDetalhamentoCliente;
import art.katpersonalizados.model.dados.listagem.DadosListagemCliente;
import art.katpersonalizados.model.entity.Cliente;
import art.katpersonalizados.model.entity.DadosPessoais;
import art.katpersonalizados.repository.ClienteRepository;
import art.katpersonalizados.service.ClienteService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@SuppressWarnings("ClassHasNoToStringMethod")
@Service
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Transactional
    @Override
    public DadosDetalhamentoCliente salvar(DadosCadastroCliente dados) {
        var cliente = new Cliente();
        cliente.setAtivo(true);
        cliente.setUsername(dados.username());
        cliente.setDadosPessoais(new DadosPessoais(dados.dadosPessoais()));
        clienteRepository.save(cliente);
        return new DadosDetalhamentoCliente(cliente);

    }

    @Override
    public DadosDetalhamentoCliente buscarPorCpf(String cpf) {
        Cliente c = clienteRepository.findByDadosPessoais_Cpf(cpf).orElseThrow(EntityNotFoundException::new);
        return new DadosDetalhamentoCliente(c);
    }

    @Override
    public DadosDetalhamentoCliente buscarPorId(Long id) {
        Cliente c = clienteRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return new DadosDetalhamentoCliente(c);
    }

    @Override
    public List<DadosListagemCliente> buscarTodos() {
        return clienteRepository.findByAtivoTrue().stream().map(DadosListagemCliente::new).toList();
    }

    @Transactional
    @Override
    public DadosDetalhamentoCliente atualizar(DadosAtualizacaoCliente dados) {
        Cliente c = clienteRepository.findById(dados.idCliente()).orElseThrow(EntityNotFoundException::new);
        atualizarDadosPessoaisCliente(dados, c);
        return new DadosDetalhamentoCliente(c);
    }


    private static void atualizarDadosPessoaisCliente(DadosAtualizacaoCliente dados, Cliente c) {
        if (dados.username() != null)
            c.setUsername(dados.username());
        if (dados.dadosPessoais().email() != null)
            c.getDadosPessoais().setEmail(dados.dadosPessoais().email());
        if (dados.dadosPessoais().telefone() != null)
            c.getDadosPessoais().setTelefone(dados.dadosPessoais().telefone());
        if (dados.dadosPessoais().celular() != null)
            c.getDadosPessoais().setCelular(dados.dadosPessoais().celular());
    }

    @Transactional
    @Override
    public void excluir(Long id) {
        Cliente c = clienteRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        c.setAtivo(false);
    }
}
