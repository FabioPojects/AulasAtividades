package code.elastic.LocadoraDeAutomoveis.controller.aluguel;

import code.elastic.LocadoraDeAutomoveis.dto.mapper.ApoliceMapper;
import code.elastic.LocadoraDeAutomoveis.dto.aluguel.ApoliceRequestDto;
import code.elastic.LocadoraDeAutomoveis.dto.aluguel.ApoliceResponseDto;
import code.elastic.LocadoraDeAutomoveis.model.aluguel.ApoliceSeguro;
import code.elastic.LocadoraDeAutomoveis.service.aluguel.ApoliceSeguroService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apolices")
@RequiredArgsConstructor
public class ApoliceSeguroController {
    private final ApoliceSeguroService service;

    @GetMapping
    public ResponseEntity<List<ApoliceResponseDto>> listarApolices(){
        List<ApoliceSeguro> apoliceSeguros = service.listarApolices();
        List<ApoliceResponseDto> response = apoliceSeguros.stream().map(ApoliceMapper::toResponseDto).toList();
        return response.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<ApoliceResponseDto> cadastrarApolice(@RequestBody ApoliceRequestDto dto){
        ApoliceSeguro apolice = ApoliceMapper.toEntity(dto);
        ApoliceSeguro apoliceSeguro = service.salvarApolice(apolice);
        ApoliceResponseDto responseDto = ApoliceMapper.toResponseDto(apoliceSeguro);
        return ResponseEntity.status(201).body(responseDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApoliceResponseDto> atualizarSeguro(@PathVariable Long id, @RequestBody ApoliceRequestDto dto){
        ApoliceSeguro apolice = ApoliceMapper.toEntity(dto);
        ApoliceSeguro apoliceSeguro = service.atualizarSeguro(id, apolice);
        ApoliceResponseDto responseDto = ApoliceMapper.toResponseDto(apoliceSeguro);
        return ResponseEntity.ok(responseDto);
    }
}
