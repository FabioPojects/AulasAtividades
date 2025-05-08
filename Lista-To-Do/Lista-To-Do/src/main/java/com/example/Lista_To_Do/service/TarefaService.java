package com.example.Lista_To_Do.service;


import com.example.Lista_To_Do.entity.Tarefa;
import com.example.Lista_To_Do.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;

    public List<Tarefa> listarTarefas() {
        return tarefaRepository.findAll();
    }

    public Tarefa salvarTarefa(String nome) {
        Tarefa tarefa = new Tarefa();
        tarefa.setNome(nome);
        return tarefaRepository.save(tarefa);
    }

    public String deletarTarefa(String nome) {
        Optional<Tarefa> tarefa = tarefaRepository.findByNome(nome);

        if (tarefa.isPresent()) {
            tarefaRepository.delete(tarefa.get());
            return "Tarefa removida: " + nome;
        } else {
            return "Tarefa não encontrada.";
        }
    }
}
