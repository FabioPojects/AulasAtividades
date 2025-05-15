package code.elastic.LocadoraDeAutomoveis.controller.pessoa;

import code.elastic.LocadoraDeAutomoveis.dto.funcionarioDto.FuncionarioCadastroDto;
import code.elastic.LocadoraDeAutomoveis.dto.mapper.FuncionarioMapper;
import code.elastic.LocadoraDeAutomoveis.dto.funcionarioDto.FuncionarioResponseDto;
import code.elastic.LocadoraDeAutomoveis.model.pessoa.Funcionario;
import code.elastic.LocadoraDeAutomoveis.service.pessoa.FuncionarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionarios")
@RequiredArgsConstructor
public class FuncionarioController {

    private final FuncionarioService funcionarioService;

    @GetMapping
    public ResponseEntity<List<FuncionarioResponseDto>> listarFuncionarios(){
        List<Funcionario> funcionarios = funcionarioService.listarFuncionarios();
        List<FuncionarioResponseDto> resposta = funcionarios.stream().map(FuncionarioMapper::toResponseDto).toList();
        return !resposta.isEmpty() ? ResponseEntity.ok(resposta) : ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<FuncionarioResponseDto> cadastrarFuncionario(@RequestBody FuncionarioCadastroDto dto){
        Funcionario funcionario = FuncionarioMapper.toEntity(dto);
        Funcionario funcCadastrado = funcionarioService.cadastrarFuncionario(funcionario);
        return ResponseEntity.status(201).body(FuncionarioMapper.toResponseDto(funcCadastrado));
    }

    @GetMapping("/matricula")
    public ResponseEntity<FuncionarioResponseDto> buscarPorMatricula(@RequestParam String matricula){
        FuncionarioResponseDto responseDto =
                FuncionarioMapper.toResponseDto(funcionarioService.buscarPorMatricula(matricula));
        return responseDto != null ? ResponseEntity.ok(responseDto) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{matricula}")
    public ResponseEntity<Void> deletarFuncionarioPorMatricula(@PathVariable String matricula){
        funcionarioService.deletarFuncionarioPorMatricula(matricula);
        return ResponseEntity.status(200).build();
    }

}
