package com.example.demo.service;

import com.example.demo.entity.Task;
import com.example.demo.repository.TaskRepository;
import jakarta.persistence.EntityNotFoundException;
import org.hibernate.dialect.unique.CreateTableUniqueDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task criarTask(Task task) {
        return taskRepository.save(task);
    }

    public Iterable<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task getTaskById(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Tarefa não encontrada"));
    }

    public Task updateTask(Long id, Task task) {
        Task taskExistente = taskRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Tarefa não encontrada"));

        taskExistente.setTitulo(task.getTitulo());
        taskExistente.setDescricao(task.getDescricao());
        taskExistente.setStatus(task.getStatus());

        return taskRepository.save(taskExistente);
    }

    public void deletarTarefa(Long id) {
        taskRepository.deleteById(id);
    }
}
