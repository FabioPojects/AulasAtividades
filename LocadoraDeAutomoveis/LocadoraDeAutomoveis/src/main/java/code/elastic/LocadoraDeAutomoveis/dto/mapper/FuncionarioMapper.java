package code.elastic.LocadoraDeAutomoveis.dto.mapper;

import code.elastic.LocadoraDeAutomoveis.dto.funcionarioDto.FuncionarioCadastroDto;
import code.elastic.LocadoraDeAutomoveis.dto.funcionarioDto.FuncionarioResponseDto;
import code.elastic.LocadoraDeAutomoveis.model.pessoa.Funcionario;

public class FuncionarioMapper {

    public static Funcionario toEntity(FuncionarioCadastroDto dto){
        return new Funcionario(dto.cpf(), dto.email(), dto.dataNascimento(), dto.sexo());
    }

    public static FuncionarioResponseDto toResponseDto(Funcionario entity){
        return new FuncionarioResponseDto(entity.getMatricula(), entity.getEmail(),
                entity.getDataNascimento(), entity.getSexo());
    }

}
