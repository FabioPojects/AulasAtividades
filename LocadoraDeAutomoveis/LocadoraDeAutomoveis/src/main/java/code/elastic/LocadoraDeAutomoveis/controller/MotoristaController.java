package code.elastic.LocadoraDeAutomoveis.controller;

import code.elastic.LocadoraDeAutomoveis.dto.motoristaDto.MotoristaCadastroDto;
import code.elastic.LocadoraDeAutomoveis.dto.motoristaDto.MotoristaMapper;
import code.elastic.LocadoraDeAutomoveis.dto.motoristaDto.MotoristaResponseDto;
import code.elastic.LocadoraDeAutomoveis.model.pessoa.Motorista;
import code.elastic.LocadoraDeAutomoveis.service.pessoa.MotoristaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/motoristas")
@RequiredArgsConstructor
public class MotoristaController {

    private final MotoristaService motoristaService;

    @GetMapping
    public ResponseEntity<List<MotoristaResponseDto>> listarMotoristas(){
        List<Motorista> motoristas = motoristaService.listarMotoristas();
        List<MotoristaResponseDto> resposta = motoristas.stream().map(MotoristaMapper::toResponse).toList();
        return !resposta.isEmpty() ? ResponseEntity.ok(resposta) : ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<MotoristaResponseDto> cadastrarMotorista(MotoristaCadastroDto dto){
        return ResponseEntity.status(201).body(MotoristaMapper.toResponse(motoristaService.cadastrarMotorista(dto)));
    }

    @DeleteMapping
    public ResponseEntity<Void> deletarMotorista(String cnh){
        motoristaService.deletarMotoristaPelaCNH(cnh);
        return ResponseEntity.status(200).build();
    }

}
