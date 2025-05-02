package code.elastic.LocadoraFilmes.controller;

import code.elastic.LocadoraFilmes.model.filmeDto.FilmeRequestDto;
import code.elastic.LocadoraFilmes.model.filmeDto.FilmeResponseDto;
import code.elastic.LocadoraFilmes.service.FilmeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/filmes")
public class FilmeController {

    private final FilmeService service;

    public FilmeController(FilmeService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<FilmeResponseDto>> listarFilmes(){
        List<FilmeResponseDto> filmes = service.listarTodos();
        return filmes.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(filmes);
    }

    @PostMapping
    public ResponseEntity<FilmeResponseDto> cadastrarFilme(@RequestBody FilmeRequestDto dto){
        return service.cadastrarFilme(dto);
    }

}
