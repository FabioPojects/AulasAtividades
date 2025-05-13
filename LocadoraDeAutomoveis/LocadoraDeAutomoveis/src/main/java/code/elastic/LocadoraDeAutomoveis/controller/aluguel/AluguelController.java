package code.elastic.LocadoraDeAutomoveis.controller.aluguel;

import code.elastic.LocadoraDeAutomoveis.dto.aluguel.AluguelMapper;
import code.elastic.LocadoraDeAutomoveis.dto.aluguel.AluguelRequestDto;
import code.elastic.LocadoraDeAutomoveis.dto.aluguel.AluguelResponseDto;
import code.elastic.LocadoraDeAutomoveis.model.aluguel.Aluguel;
import code.elastic.LocadoraDeAutomoveis.service.aluguel.AluguelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alugueis")
@RequiredArgsConstructor
public class AluguelController {
    private final AluguelService aluguelService;

    @GetMapping
    public ResponseEntity<List<AluguelResponseDto>> listarAlugueis(){
        List<Aluguel> alugueis = aluguelService.listarAlugueis();
        List<AluguelResponseDto> responseDtos = alugueis.stream().map(AluguelMapper::toResponse).toList();
        return responseDtos.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(responseDtos);
    }

    @PostMapping
    public ResponseEntity<AluguelResponseDto> cadastrarAluguel(@RequestBody AluguelRequestDto request){
        Aluguel aluguel = aluguelService.cadastrarAluguel(request);
        AluguelResponseDto responseDto = AluguelMapper.toResponse(aluguel);
        return ResponseEntity.ok(responseDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAluguel(@PathVariable Long id){
        aluguelService.deletarAluguel(id);
        return ResponseEntity.ok().build();
    }

}
