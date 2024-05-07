package art.katpersonalizados.service.impl;

import art.katpersonalizados.model.dados.atualizacao.DadosAtualizacaoCategoria;
import art.katpersonalizados.model.dados.cadastro.DadosCadastroCategoria;
import art.katpersonalizados.model.dados.detalhamento.DadosDetalhamentoCategoria;
import art.katpersonalizados.model.dados.listagem.DadosListagemCategoria;
import art.katpersonalizados.model.entity.Categoria;
import art.katpersonalizados.repository.CategoriaRepository;
import art.katpersonalizados.service.CategoriaService;
import org.springframework.stereotype.Service;

import java.util.List;

@SuppressWarnings("ClassHasNoToStringMethod")
@Service
public class CategoriaServiceImpl implements CategoriaService {


    private final CategoriaRepository categoriaRepository;

    public CategoriaServiceImpl(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public DadosListagemCategoria salvar(DadosCadastroCategoria dadosCadastroCategoria) {
        Categoria c = new Categoria(dadosCadastroCategoria);
        categoriaRepository.save(c);
        return new DadosListagemCategoria(c);
    }

    @Override
    public DadosDetalhamentoCategoria detalhar(Long id) {
        Categoria c = categoriaRepository.getReferenceById(id);
        return new DadosDetalhamentoCategoria(c);
    }

    @Override
    public List<DadosListagemCategoria> listar() {
        return categoriaRepository.findByAtivoTrue().stream().map(DadosListagemCategoria::new).toList();
    }

    @Override
    public DadosDetalhamentoCategoria atualizar(DadosAtualizacaoCategoria dados) {
        Categoria c = categoriaRepository.getReferenceById(dados.idCategoria());
        c.setNome(dados.nome());
        categoriaRepository.save(c);
        return new DadosDetalhamentoCategoria(c);
    }

    @Override
    public void excluir(Long id) {
        Categoria c = categoriaRepository.getReferenceById(id);
        c.setAtivo(false);
    }
}
