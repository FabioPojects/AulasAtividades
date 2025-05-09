package code.elastic.LocadoraDeAutomoveis.dto.funcionarioDto;

import code.elastic.LocadoraDeAutomoveis.model.pessoa.Funcionario;
import code.elastic.LocadoraDeAutomoveis.model.pessoa.Pessoa;

public class FuncionarioMapper {

    public static Funcionario toEntity(FuncionarioCadastroDto dto){
        return new Funcionario(dto.cpf(), dto.dataNascimento(), dto.sexo(), dto.email());
    }

    public static FuncionarioResponseDto toResponseDto(Funcionario entity){
        return new FuncionarioResponseDto(entity.getMatricula(), entity.getEmail(),
                entity.getDataNascimento(), entity.getSexo());
    }

}
