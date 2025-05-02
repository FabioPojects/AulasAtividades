package code.elastic.LocadoraFilmes.service;

import code.elastic.LocadoraFilmes.model.Filme;
import code.elastic.LocadoraFilmes.model.filmeDto.FilmeMapper;
import code.elastic.LocadoraFilmes.model.filmeDto.FilmeRequestDto;
import code.elastic.LocadoraFilmes.model.filmeDto.FilmeResponseDto;
import code.elastic.LocadoraFilmes.repositorys.FilmeRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Service
public class FilmeService {

    private final FilmeRepository repository;

    public FilmeService(FilmeRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<FilmeResponseDto> listarTodos() {
        List<Filme> filmes = repository.findAll();
        return filmes.stream().map(FilmeMapper::toResponseDto).toList();
    }

    @PostMapping
    public ResponseEntity<FilmeResponseDto> cadastrarFilme(FilmeRequestDto dto) {
        Filme filme = repository.save(FilmeMapper.requestToEntity(dto));
        return ResponseEntity.ok(FilmeMapper.toResponseDto(filme));
    }
}
