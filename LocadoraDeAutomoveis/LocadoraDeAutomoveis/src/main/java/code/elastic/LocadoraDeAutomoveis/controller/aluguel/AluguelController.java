package code.elastic.LocadoraDeAutomoveis.controller.aluguel;

import code.elastic.LocadoraDeAutomoveis.dto.mapper.AluguelMapper;
import code.elastic.LocadoraDeAutomoveis.dto.aluguel.AluguelRequestDto;
import code.elastic.LocadoraDeAutomoveis.dto.aluguel.AluguelResponseDto;
import code.elastic.LocadoraDeAutomoveis.model.aluguel.Aluguel;
import code.elastic.LocadoraDeAutomoveis.model.aluguel.Pagamento;
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

    @GetMapping("/diponiveis")
    public ResponseEntity<List<AluguelResponseDto>> listarAlugueisDisponveis(){
        List<Aluguel> alugueis = aluguelService.listarAlugueisDisponiveis();
        List<AluguelResponseDto> responseDtos = alugueis.stream().map(AluguelMapper::toResponse).toList();
        return responseDtos.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(responseDtos);
    }

    @GetMapping("/carinho")
    public ResponseEntity<List<AluguelResponseDto>> listarAlugueisNoCarrinho(){
        List<Aluguel> alugueis = aluguelService.listarAluguelNoCarrinho();
        List<AluguelResponseDto> responseDtos = alugueis.stream().map(AluguelMapper::toResponse).toList();
        return responseDtos.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(responseDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AluguelResponseDto> buscarAluguelPorId(@PathVariable Long idAluguel){
        Aluguel aluguel = aluguelService.buscarPorId(idAluguel);
        AluguelResponseDto response = AluguelMapper.toResponse(aluguel);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/confirmar-carrinho/{id}")
    public ResponseEntity<List<AluguelResponseDto>> confirmarAlugueisNoCarrinho(@PathVariable Long idMotorista,@RequestBody Pagamento pagamento){
        List<Aluguel> alugueis = aluguelService.confirmarAlugueisDoCarrinho(idMotorista, pagamento);
        List<AluguelResponseDto> responseDtos = alugueis.stream().map(AluguelMapper::toResponse).toList();
        return responseDtos.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(responseDtos);
    }

    @GetMapping("/meus-alugueis/{id}")
    public ResponseEntity<List<AluguelResponseDto>> meusAlugueis(@PathVariable Long idMotorista){
        List<Aluguel> alugueis = aluguelService.listarMeusAlugueis(idMotorista);
        List<AluguelResponseDto> responseDtos = alugueis.stream().map(AluguelMapper::toResponse).toList();
        return responseDtos.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(responseDtos);
    }

    @PostMapping
    public ResponseEntity<AluguelResponseDto> cadastrarAluguel(@RequestBody AluguelRequestDto request){
        Aluguel aluguel = aluguelService.cadastrarAluguel(request);
        AluguelResponseDto responseDto = AluguelMapper.toResponse(aluguel);
        return ResponseEntity.ok(responseDto);
    }

    @PostMapping("/aluguel")
    public ResponseEntity<AluguelResponseDto> adicionarNoCarrinho(@RequestParam Long idAluguel){
      aluguelService.adicionarNoCarrinho(idAluguel);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/carrinho/{idCliente}")
    public ResponseEntity<Void> deletarCarrinho(@PathVariable Long idCliente){
        aluguelService.cancelarCarrinho(idCliente);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAluguel(@PathVariable Long idMotorista){
        aluguelService.deletarAluguel(idMotorista);
        return ResponseEntity.ok().build();
    }

}
