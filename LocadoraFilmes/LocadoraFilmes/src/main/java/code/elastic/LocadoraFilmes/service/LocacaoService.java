package code.elastic.LocadoraFilmes.service;

import code.elastic.LocadoraFilmes.exception.ClienteNaoEncontradoExcepetion;
import code.elastic.LocadoraFilmes.exception.FilmeNaoEncontradoException;
import code.elastic.LocadoraFilmes.exception.LocacaoNaoEncontradaException;
import code.elastic.LocadoraFilmes.model.Cliente;
import code.elastic.LocadoraFilmes.model.Filme;
import code.elastic.LocadoraFilmes.model.Locacao;
import code.elastic.LocadoraFilmes.model.locacaoDto.LocacaoMapper;
import code.elastic.LocadoraFilmes.model.locacaoDto.LocacaoRequestDto;
import code.elastic.LocadoraFilmes.model.locacaoDto.LocacaoResponseDto;
import code.elastic.LocadoraFilmes.repositorys.ClienteRepository;
import code.elastic.LocadoraFilmes.repositorys.FilmeRepository;
import code.elastic.LocadoraFilmes.repositorys.LocacaoRepository;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class LocacaoService {

    private final LocacaoRepository locacaoRepository;
    private final ClienteRepository clienteRepository;
    private final FilmeRepository filmeRepository;

    public LocacaoService(LocacaoRepository locacaoRepository, ClienteRepository clienteRepository, FilmeRepository filmeRepository) {
        this.locacaoRepository = locacaoRepository;
        this.clienteRepository = clienteRepository;
        this.filmeRepository = filmeRepository;
    }

    public List<LocacaoResponseDto> listarTodas(){
        List<Locacao> locacoes = locacaoRepository.findAll();
        return locacoes.stream().map(LocacaoMapper::toResponse).toList();
    }

    public LocacaoResponseDto alugarFilme(LocacaoRequestDto dto) {
        Cliente cliente = clienteRepository.findById(dto.cliente().id())
                .orElseThrow(() -> new ClienteNaoEncontradoExcepetion("Cliente não encontrado"));

        Filme filme = filmeRepository.findById(dto.filme().id())
                        .orElseThrow(() -> new FilmeNaoEncontradoException("Filme ID %d não encontrado".formatted(dto.filme().id())));

        Locacao locacao = LocacaoMapper.requestToEntity(dto, cliente, filme);
       locacaoRepository.save(locacao);
       return LocacaoMapper.toResponse(locacao);
    }

    public String devolverFilme(Long id, LocalDate dataDevolucao) {
        Locacao locacao = locacaoRepository.findById(id)
                .orElseThrow(() -> new LocacaoNaoEncontradaException("Locação ID %d não encontrada.".formatted(id)));

        if (!locacao.isDevolvido()){
            locacao.atualizarStatus();
            locacao.setDatadevolucao(dataDevolucao);

        }else {
            return "O filme não está alugado!";
        }

        locacaoRepository.save(locacao);
        return "Filme devolvido com sucesso!";
    }
}
