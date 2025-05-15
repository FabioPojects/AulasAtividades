package code.elastic.LocadoraDeAutomoveis.controller.carro;

import code.elastic.LocadoraDeAutomoveis.model.carro.Acessorio;
import code.elastic.LocadoraDeAutomoveis.service.carro.AcessorioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/acessorios")
@RequiredArgsConstructor
public class AcessoriaController {

    private final AcessorioService service;

    @GetMapping
    public ResponseEntity<List<Acessorio>> listarAcessorios(){
        List<Acessorio> acessorios = service.listarAcessorios();
        return acessorios.isEmpty() ? ResponseEntity.noContent().build() :
                ResponseEntity.ok(acessorios);
    }

    @PostMapping
    public ResponseEntity<Acessorio> cadastrarAcessorio(Acessorio acessorio){
        return ResponseEntity.status(201).body(service.cadastrarAcessorio(acessorio));
    }


}
