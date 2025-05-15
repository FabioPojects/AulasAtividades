package code.elastic.LocadoraDeAutomoveis.controller.carro;

import code.elastic.LocadoraDeAutomoveis.dto.mapper.CarroMapper;
import code.elastic.LocadoraDeAutomoveis.dto.carro.CarroRequestDto;
import code.elastic.LocadoraDeAutomoveis.dto.carro.CarroResponseDto;
import code.elastic.LocadoraDeAutomoveis.model.carro.Carro;
import code.elastic.LocadoraDeAutomoveis.service.carro.CarroService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carros")
@RequiredArgsConstructor
public class CarroController {

    private final CarroService carroService;

    @GetMapping
    public ResponseEntity<List<CarroResponseDto>> listarCarros(){
        List<Carro> carros = carroService.listarTodosCarros();
        List<CarroResponseDto> response = carros.stream().map(CarroMapper::toResponse).toList();
        return response.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<CarroResponseDto> cadastrarCarro(@RequestBody CarroRequestDto dto){
        CarroResponseDto carroCadastrado = CarroMapper.toResponse(carroService.cadastrarCarro(dto));
        return ResponseEntity.ok(carroCadastrado);
    }

    @GetMapping("/{placa}")
    public ResponseEntity<CarroResponseDto> buscarCarroPorPlaca(@PathVariable String placa){
        CarroResponseDto responseDto = CarroMapper.toResponse(carroService.encontrarCarroPorPlaca(placa));
        return ResponseEntity.ok(responseDto);
    }

    @DeleteMapping("/{placa}")
    public ResponseEntity<Void> deletarPorPlaca(@PathVariable String placa){
        carroService.deletarCarroPorPlaca(placa);
        return ResponseEntity.ok().build();
    }

}
