package code.elastic.LocadoraFilmes.model.locacaoDto;

import code.elastic.LocadoraFilmes.model.Cliente;
import code.elastic.LocadoraFilmes.model.Filme;
import code.elastic.LocadoraFilmes.model.clienteDto.ClienteLocacaoDto;
import code.elastic.LocadoraFilmes.model.filmeDto.FilmeLocacaoDto;

import java.time.LocalDate;
import java.util.List;

public record LocacaoRequestDto(ClienteLocacaoDto cliente, FilmeLocacaoDto filme, LocalDate dataLocacao) {
}
