package code.elastic.LocadoraDeAutomoveis.dto.motoristaDto;

import code.elastic.LocadoraDeAutomoveis.model.pessoa.Motorista;

public class MotoristaMapper {

    public static Motorista toEntity(MotoristaCadastroDto dto){
        return new Motorista(dto.cpf(), dto.email(), dto.numeroCNH(), dto.dataNascimento(), dto.sexo());
    }

    public static MotoristaResponseDto toResponse(Motorista entity) {
        return new MotoristaResponseDto(entity.getNumeroCNH(), entity.getEmail(), entity.getDataNascimento(), entity.getSexo());
    }
}
