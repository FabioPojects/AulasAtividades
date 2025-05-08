package code.elastic.ListaTo_Do.model.dto;

import code.elastic.ListaTo_Do.model.Tarefa;

public class TarefaMapper {

    public static Tarefa toEntity(TarefaRequestDto dto){
        return new Tarefa(dto.titulo(), dto.descricao());
    }

    public static TarefaResponseDto toResponseDto(Tarefa tarefa){
        return new TarefaResponseDto(tarefa.getTitulo());
    }

}
