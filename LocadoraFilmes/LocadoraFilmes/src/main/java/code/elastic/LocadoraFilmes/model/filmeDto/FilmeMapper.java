package code.elastic.LocadoraFilmes.model.filmeDto;

import code.elastic.LocadoraFilmes.model.Filme;

public class FilmeMapper {

    public static FilmeResponseDto toResponseDto(Filme entity){
        return new FilmeResponseDto(entity.getId(), entity.getTitulo(), entity.getGenero());
    }

    public static Filme requestToEntity(FilmeRequestDto dto){
        return new Filme(dto.titulo(), dto.genero(), dto.diretor());
    }

}
