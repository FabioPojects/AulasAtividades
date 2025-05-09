package code.elastic.LocadoraDeAutomoveis.controller;

import code.elastic.LocadoraDeAutomoveis.dto.funcionarioDto.FuncionarioCadastroDto;
import code.elastic.LocadoraDeAutomoveis.dto.funcionarioDto.FuncionarioMapper;
import code.elastic.LocadoraDeAutomoveis.dto.funcionarioDto.FuncionarioResponseDto;
import code.elastic.LocadoraDeAutomoveis.model.pessoa.Funcionario;
import code.elastic.LocadoraDeAutomoveis.service.pessoa.FuncionarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
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
    public ResponseEntity<FuncionarioResponseDto> cadastrarFuncionario(FuncionarioCadastroDto dto){
        return ResponseEntity.status(201).body(FuncionarioMapper.toResponseDto(funcionarioService.cadastrarFuncionario(dto)));
    }

    @DeleteMapping
    public ResponseEntity<Void> deletarFuncionarioPorMatricula(String matricula){
        funcionarioService.deletarFuncionarioPorMatricula(matricula);
        return ResponseEntity.status(200).build();
    }

}
