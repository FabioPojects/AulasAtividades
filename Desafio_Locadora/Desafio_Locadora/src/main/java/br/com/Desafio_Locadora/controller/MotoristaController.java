package br.com.Desafio_Locadora.controller;


import br.com.Desafio_Locadora.dto.CadastroMotoristaDTO;
import br.com.Desafio_Locadora.dto.ListagemMotoristaDTO;
import br.com.Desafio_Locadora.entity.Motorista;
import br.com.Desafio_Locadora.service.MotoristaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/motorista")
public class MotoristaController {

    @Autowired
    private MotoristaService motoristaService;

    @PostMapping
    public ResponseEntity<String> cadastrarMotorista(@RequestBody CadastroMotoristaDTO motorista) {
        try {
            motoristaService.saveMotorista(motorista);
            return ResponseEntity.status(201).body("Motorista cadastrado com sucesso!");
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<ListagemMotoristaDTO>> listarMotoristas() {
        List<ListagemMotoristaDTO> motoristas = motoristaService.listarMotoristas();
        return ResponseEntity.ok(motoristas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ListagemMotoristaDTO> buscarMotoristaPorId(@PathVariable Long id) {
        Motorista motorista = motoristaService.buscarPorId(id);
        if (motorista == null) {
            return ResponseEntity.notFound().build();
        }
        ListagemMotoristaDTO dto = new ListagemMotoristaDTO(
                motorista.getNome(), motorista.getCpf(),
                motorista.getEmail(), motorista.getNumeroCnh()
        );
        return ResponseEntity.ok(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> atualizarMotorista(@PathVariable Long id, @Valid @RequestBody CadastroMotoristaDTO motorista) {
        try {
            motoristaService.atualizarMotorista(id, motorista);
            return ResponseEntity.ok("Motorista atualizado com sucesso!");
        } catch (RuntimeException e) {
            return ResponseEntity.status(400).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarMotorista(@PathVariable Long id) {
        try {
            motoristaService.buscarPorId(id);
            motoristaService.atualizarMotorista(id, null);
            return ResponseEntity.ok("Motorista deletado com sucesso!");
        } catch (RuntimeException e) {
            return ResponseEntity.status(400).build();
        }
    }
}
