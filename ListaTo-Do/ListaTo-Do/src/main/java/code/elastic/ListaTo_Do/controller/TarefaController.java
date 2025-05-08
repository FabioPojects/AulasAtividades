package code.elastic.ListaTo_Do.controller;

import code.elastic.ListaTo_Do.exception.TarefaNaoEncontradaException;
import code.elastic.ListaTo_Do.model.Tarefa;
import code.elastic.ListaTo_Do.model.dto.TarefaMapper;
import code.elastic.ListaTo_Do.model.dto.TarefaRequestDto;
import code.elastic.ListaTo_Do.model.dto.TarefaResponseDto;
import code.elastic.ListaTo_Do.service.TarefaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/tarefas")
@RequiredArgsConstructor
public class TarefaController {

    private final TarefaService tarefaService;

    @GetMapping
    public ResponseEntity<List<TarefaResponseDto>> listar() {
        List<Tarefa> tarefas = tarefaService.listarTarefas();
        List<TarefaResponseDto> response = tarefas.stream().map(TarefaMapper::toResponseDto).toList();
        return !response.isEmpty() ? ResponseEntity.ok(response) : ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<String> inserirNovaTarefa(@RequestBody @Valid TarefaRequestDto dto){
        Tarefa tarefa = TarefaMapper.toEntity(dto);
        return ResponseEntity.status(201).body("Tarefa adicionada: " + TarefaMapper.toResponseDto(tarefaService.adicionarTarefa(tarefa)).titulo());
    }

    @DeleteMapping("/deletarTarefa")
    public ResponseEntity<String> deletarTarefaPorTitulo(@RequestParam String titulo) throws TarefaNaoEncontradaException {
        tarefaService.deletarTarefaPorTitulo(titulo);
        return ResponseEntity.ok("Tarefa removida: " + titulo);
    }

}
