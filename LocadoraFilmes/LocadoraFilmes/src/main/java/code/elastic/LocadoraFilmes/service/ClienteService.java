package code.elastic.LocadoraFilmes.service;

import code.elastic.LocadoraFilmes.model.Cliente;
import code.elastic.LocadoraFilmes.model.clienteDto.ClienteMapper;
import code.elastic.LocadoraFilmes.model.clienteDto.ClienteRequestDto;
import code.elastic.LocadoraFilmes.model.clienteDto.ClienteResponseDto;
import code.elastic.LocadoraFilmes.repositorys.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository repository;

    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    public List<ClienteResponseDto> listarClientes() {
        List<Cliente> clientes = repository.findAll();
        return clientes.stream().map(ClienteMapper::toResponseDto).toList();
    }

    public ClienteResponseDto criarCliente(ClienteRequestDto dto) {
        Cliente novoCliente = repository.save(ClienteMapper.requestDtoToEntity(dto));
        return ClienteMapper.toResponseDto(novoCliente);
    }

}
