package code.elastic.LocadoraFilmes.model.locacaoDto;

import code.elastic.LocadoraFilmes.model.clienteDto.ClienteLocacaoDto;
import code.elastic.LocadoraFilmes.model.filmeDto.FilmeLocacaoDto;

import java.time.LocalDate;
import java.util.List;

public record LocacaoResponseDto(Long id, ClienteLocacaoDto cliente, FilmeLocacaoDto filme, LocalDate dataLocacao, boolean devolvido) {
}
