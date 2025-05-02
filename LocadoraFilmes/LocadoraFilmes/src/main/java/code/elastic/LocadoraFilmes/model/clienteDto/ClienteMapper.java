package code.elastic.LocadoraFilmes.model.clienteDto;

import code.elastic.LocadoraFilmes.model.Cliente;

public class ClienteMapper {

    public static Cliente requestDtoToEntity(ClienteRequestDto dto){
        return new Cliente(dto.nome(), dto.email());
    }

    public static ClienteResponseDto toResponseDto(Cliente entity){
        return new ClienteResponseDto(entity.getId(), entity.getNome(), entity.getEmail());
    }

}
