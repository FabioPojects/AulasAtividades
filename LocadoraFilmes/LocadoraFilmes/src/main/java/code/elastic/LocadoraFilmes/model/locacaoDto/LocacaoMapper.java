package code.elastic.LocadoraFilmes.model.locacaoDto;

import code.elastic.LocadoraFilmes.model.Cliente;
import code.elastic.LocadoraFilmes.model.Filme;
import code.elastic.LocadoraFilmes.model.Locacao;
import code.elastic.LocadoraFilmes.model.clienteDto.ClienteLocacaoDto;
import code.elastic.LocadoraFilmes.model.filmeDto.FilmeLocacaoDto;

import java.util.List;

public class LocacaoMapper {

    public static LocacaoResponseDto toResponse(Locacao entity){
        if (entity == null){
            return null;
        }
        ClienteLocacaoDto cliente = new ClienteLocacaoDto(entity.getCliente().getId());

        FilmeLocacaoDto filme = new FilmeLocacaoDto(entity.getFilme().getId());

        return new LocacaoResponseDto(entity.getId(), cliente, filme, entity.getDataLocacao(), entity.isDevolvido());
    }

    public static Locacao requestToEntity(LocacaoRequestDto dto, Cliente cliente, Filme filme){
        if (dto == null){
            return null;
        }

        return new Locacao(cliente, filme, dto.dataLocacao());
    }

}
