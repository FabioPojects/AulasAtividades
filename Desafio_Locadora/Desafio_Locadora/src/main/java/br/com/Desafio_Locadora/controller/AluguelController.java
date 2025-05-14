package br.com.Desafio_Locadora.controller;


import br.com.Desafio_Locadora.dto.CadastroAluguelDTO;
import br.com.Desafio_Locadora.dto.ListagemAluguelDTO;
import br.com.Desafio_Locadora.entity.Aluguel;
import br.com.Desafio_Locadora.entity.Carros;
import br.com.Desafio_Locadora.entity.Motorista;
import br.com.Desafio_Locadora.repository.AluguelRepository;
import br.com.Desafio_Locadora.repository.CarroRepository;
import br.com.Desafio_Locadora.repository.MotoristaRepository;
import br.com.Desafio_Locadora.service.AluguelService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/alluguel")
public class AluguelController {

    @Autowired
    private AluguelService aluguelservice;

    @Autowired
    private MotoristaRepository motoristaRepository;

    @Autowired
    private CarroRepository carroRepository;


    @PostMapping
    public ResponseEntity<String> cadastrarAluguel(@RequestBody @Valid CadastroAluguelDTO aluguelDTO) {
        try {
            Motorista motorista = motoristaRepository.findById(aluguelDTO.idMotorista())
                    .orElseThrow(() -> new RuntimeException("Motorista não encontrado!"));

            Carros carro = carroRepository.findById(aluguelDTO.idCarro())
                    .orElseThrow(() -> new RuntimeException("Carro não encontrado!"));

            Aluguel aluguel = new Aluguel();
            aluguel.setDataEntrega(Date.from(aluguelDTO.dataInicio().atStartOfDay(ZoneId.systemDefault()).toInstant()));
            aluguel.setDataDevolucao(Date.from(aluguelDTO.dataFim().atStartOfDay(ZoneId.systemDefault()).toInstant()));
            aluguel.setMotorista(motorista);
            aluguel.setVeiculo(carro);

            aluguelservice.cadastrarAluguel(aluguel);

            return ResponseEntity.status(201).body("Aluguel cadastrado com sucesso! ID: " + aluguel.getId_aluguel());
        } catch (RuntimeException e) {
            return ResponseEntity.status(400).body("Erro ao cadastrar aluguel: " + e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<ListagemAluguelDTO>> listarAlugueis() {
        List<ListagemAluguelDTO> alugueisDTO = aluguelservice.listarAlugueis().stream()
                .map(aluguel -> new ListagemAluguelDTO(
                        aluguel.getId_aluguel(),
                        aluguel.getDataPedido().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
                        aluguel.getDataDevolucao().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
                        aluguel.getValorTotal().doubleValue()
                ))
                .collect(Collectors.toList());
        return ResponseEntity.ok(alugueisDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ListagemAluguelDTO> buscarAluguelPorId(@PathVariable Long id) {
        Optional<Aluguel> aluguel = aluguelservice.buscarAluguelPorId(id);
        if (aluguel == null) {
            return ResponseEntity.notFound().build();
        }
        ListagemAluguelDTO dto = new ListagemAluguelDTO(
                aluguel.get().getId_aluguel(),
                aluguel.get().getDataPedido().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
                aluguel.get().getDataDevolucao().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
                aluguel.get().getValorTotal().doubleValue()
        );
        return ResponseEntity.ok(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> atualizarAluguel(@PathVariable Long id, @Valid @RequestBody Aluguel aluguelAtualizado) {
        try {
            aluguelservice.atualizarAluguel(id, aluguelAtualizado);
            return ResponseEntity.ok("Aluguel atualizado com sucesso!");
        } catch (RuntimeException e) {
            return ResponseEntity.status(400).body("Erro ao atualizar aluguel: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarAluguel(@PathVariable Long id) {
        try {
            aluguelservice.excluirAluguel(id);
            return ResponseEntity.ok("Aluguel deletado com sucesso!");
        } catch (RuntimeException e) {
            return ResponseEntity.status(400).body("Erro ao deletar aluguel: " + e.getMessage());
        }
    }


}
