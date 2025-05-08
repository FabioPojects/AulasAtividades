package com.example.Lista_To_Do.controller;

import com.example.Lista_To_Do.entity.Tarefa;
import com.example.Lista_To_Do.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    @GetMapping
    public String listarTarefas() {
        return tarefaService.listarTarefas().toString();
    }

    @PostMapping
    public ResponseEntity<Tarefa> adicionarTarefa(@RequestBody Tarefa tarefa) {
        Tarefa novaTarefa = tarefaService.salvarTarefa(tarefa.getNome());
        return ResponseEntity.status(HttpStatus.CREATED).body(novaTarefa);
    }

    @DeleteMapping("/{nome}")
    public String deletarTarefa(@PathVariable String nome) {
        return tarefaService.deletarTarefa(nome);

    }
}
