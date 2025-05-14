package br.com.Desafio_Locadora.controller;

import br.com.Desafio_Locadora.dto.CarroDTO;
import br.com.Desafio_Locadora.dto.ListagemCarroDTO;
import br.com.Desafio_Locadora.entity.Carros;
import br.com.Desafio_Locadora.service.CarroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/carros")
public class CarroController {

    @Autowired
    private CarroService carroService;

    @PostMapping
    public ResponseEntity<String> cadastrarCarro(@RequestBody @Valid Carros carro) {
        try {
            carroService.cadastrarCarro(carro);
            return ResponseEntity.status(201).body("Carro cadastrado com sucesso!");
        } catch (RuntimeException e) {
            return ResponseEntity.status(400).body("Erro ao cadastrar carro: " + e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<ListagemCarroDTO>> listarCarros() {
        List<ListagemCarroDTO> carrosDTO = carroService.listarTodosCarros().stream()
                .map(carro -> new ListagemCarroDTO(carro.id(), carro.modeloCarro(), carro.placa()))
                .collect(Collectors.toList());

        return ResponseEntity.ok(carrosDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ListagemCarroDTO> buscarCarroPorId(@PathVariable Long id) {
        Optional<Carros> carro = carroService.buscarCarroPorId(id);
        if (carro.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        ListagemCarroDTO dto = new ListagemCarroDTO(
                carro.get().getId_carros(), carro.get().getModeloCarro(), carro.get().getPlaca()
        );
        return ResponseEntity.ok(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> atualizarCarro(@PathVariable Long id, @Valid @RequestBody Carros carroAtualizado) {
        try {
            carroService.atualizarCarro(id, carroAtualizado);
            return ResponseEntity.ok("Carro atualizado com sucesso!");
        } catch (RuntimeException e) {
            return ResponseEntity.status(400).body("Erro ao atualizar carro: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluirCarro(@PathVariable Long id) {
        try {
            carroService.excluirCarro(id);
            return ResponseEntity.ok("Carro excluído com sucesso!");
        } catch (RuntimeException e) {
            return ResponseEntity.status(400).body("Erro ao excluir carro: " + e.getMessage());
        }
    }
}