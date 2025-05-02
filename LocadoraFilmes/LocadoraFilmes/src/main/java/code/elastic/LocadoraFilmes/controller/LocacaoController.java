package code.elastic.LocadoraFilmes.controller;

import code.elastic.LocadoraFilmes.model.locacaoDto.LocacaoRequestDto;
import code.elastic.LocadoraFilmes.model.locacaoDto.LocacaoResponseDto;
import code.elastic.LocadoraFilmes.service.LocacaoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/locacoes")
public class LocacaoController {

    private final LocacaoService service;

    public LocacaoController(LocacaoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<LocacaoResponseDto>> listarLocacoes(){
        List<LocacaoResponseDto> locacoes = service.listarTodas();
        return locacoes.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(locacoes);
    }

    @PostMapping
    public ResponseEntity<LocacaoResponseDto> alugarFilme(@Valid @RequestBody LocacaoRequestDto dto){
        LocacaoResponseDto locacao = service.alugarFilme(dto);
        return ResponseEntity.status(201).body(locacao);
    }

    @PutMapping("/{id}/devolucao")
    public ResponseEntity<String> atualizarFilme(@PathVariable Long id, @RequestBody LocalDate dataDevolucao){
        return ResponseEntity.ok(service.devolverFilme(id, dataDevolucao));
    }

}
