package code.elastic.LocadoraFilmes.controller;

import code.elastic.LocadoraFilmes.model.clienteDto.ClienteRequestDto;
import code.elastic.LocadoraFilmes.model.clienteDto.ClienteResponseDto;
import code.elastic.LocadoraFilmes.service.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ClienteResponseDto>> listarTodos(){
        List<ClienteResponseDto> clientes = service.listarClientes();
        return clientes.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(clientes);
    }

    @PostMapping
    public ResponseEntity<ClienteResponseDto> cadastrarCliente(@RequestBody ClienteRequestDto clienteCadastro){
        return ResponseEntity.status(201).body(service.criarCliente(clienteCadastro));
    }
}
