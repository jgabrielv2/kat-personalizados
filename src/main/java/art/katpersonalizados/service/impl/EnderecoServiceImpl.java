package art.katpersonalizados.service.impl;

import art.katpersonalizados.model.dados.atualizacao.DadosAtualizacaoEndereco;
import art.katpersonalizados.model.dados.cadastro.DadosCadastroEndereco;
import art.katpersonalizados.model.dados.detalhamento.DadosDetalhamentoEndereco;
import art.katpersonalizados.model.dados.listagem.DadosListagemEndereco;
import art.katpersonalizados.model.entity.Endereco;
import art.katpersonalizados.repository.ClienteRepository;
import art.katpersonalizados.repository.EnderecoRepository;
import art.katpersonalizados.service.EnderecoService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoServiceImpl implements EnderecoService {

    private final EnderecoRepository enderecoRepository;
    private final ClienteRepository clienteRepository;

    public EnderecoServiceImpl(EnderecoRepository enderecoRepository, ClienteRepository clienteRepository) {
        this.enderecoRepository = enderecoRepository;
        this.clienteRepository = clienteRepository;
    }

    @Transactional
    @Override
    public DadosDetalhamentoEndereco salvar(DadosCadastroEndereco dados) {
        var cliente = clienteRepository.findById(dados.idCliente()).orElseThrow(EntityNotFoundException::new);
        var endereco = new Endereco(dados);
        endereco.setCliente(cliente);
        enderecoRepository.save(endereco);
        return new DadosDetalhamentoEndereco(endereco);
    }

    @Override
    public DadosDetalhamentoEndereco buscarPorId(Long id) {
        var endereco = enderecoRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return new DadosDetalhamentoEndereco(endereco);
    }

    @Override
    public List<DadosListagemEndereco> buscarTodos() {
        return enderecoRepository.findAll().stream().map(DadosListagemEndereco::new).toList();
    }

    @Transactional
    @Override
    public DadosDetalhamentoEndereco atualizar(DadosAtualizacaoEndereco dados, Long id) {
        Endereco e = enderecoRepository.findById(id).orElseThrow(EntityNotFoundException::new);

        if (dados.cep() != null)
            e.setCep(dados.cep());
        if (dados.logradouro() != null)
            e.setLogradouro(dados.logradouro());
        if (dados.complemento() != null)
            e.setComplemento(dados.complemento());
        if (dados.bairro() != null)
            e.setBairro(dados.bairro());
        if (dados.localidade() != null)
            e.setLocalidade(dados.localidade());
        if (dados.uf() != null)
            e.setUf(dados.uf());
        if (dados.numero() != null)
            e.setNumero(dados.numero());

        enderecoRepository.save(e);

        return new DadosDetalhamentoEndereco(e);

    }

    @Transactional
    @Override
    public void excluir(Long id){
        var endereco = enderecoRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        endereco.setAtivo(false);
        enderecoRepository.save(endereco);
    }

}
