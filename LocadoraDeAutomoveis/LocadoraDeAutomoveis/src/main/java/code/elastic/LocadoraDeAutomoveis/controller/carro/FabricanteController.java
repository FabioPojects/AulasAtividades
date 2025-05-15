package code.elastic.LocadoraDeAutomoveis.controller.carro;

import code.elastic.LocadoraDeAutomoveis.dto.carro.FabricanteDto;
import code.elastic.LocadoraDeAutomoveis.model.carro.Fabricante;
import code.elastic.LocadoraDeAutomoveis.service.carro.FabricanteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fabricantes")
@RequiredArgsConstructor
public class FabricanteController {

    private final FabricanteService fabricanteService;

    @GetMapping
    public ResponseEntity<List<FabricanteDto>> listarFabricantes(){
        List<Fabricante> fabricantes = fabricanteService.listarFabricantes();;
        List<FabricanteDto> response = fabricantes.stream()
                .map(f -> new FabricanteDto(f.getNome())).toList();

        return response.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<FabricanteDto> cadastrarFabricante(@RequestBody FabricanteDto dto){
        Fabricante fabricante = fabricanteService.cadastrarFabricante(new Fabricante(dto.nome()));
        FabricanteDto fabricanteCadastrado = new FabricanteDto(fabricante.getNome());
        return ResponseEntity.status(201).body(fabricanteCadastrado);
    }

    @GetMapping("/{nome}")
    public ResponseEntity<FabricanteDto> buscarPorNome(@PathVariable String nome){
        FabricanteDto response = new FabricanteDto(fabricanteService.buscarPorNome(nome).getNome());
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarFabricante(@PathVariable Long id){
        fabricanteService.deletarFabricantePorId(id);
        return ResponseEntity.ok().build();
    }

}
