package controller;


import dto.AtualizacaoPrecoDTO;
import dto.AtualizarEstoqueDTO;
import dto.ProdutoDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private  ProdutoController service;

    @GetMapping
    public List<ProdutoDTO> listarProdutos(){
        return service.listarProdutos();
    }

    @GetMapping("/{id}")
    public ProdutoDTO buscarProdutoPorId(@PathVariable Long id) {
        return service.buscarProdutoPorId(id);
    }

    @PostMapping
    public ResponseEntity<ProdutoDTO> salvarProduto(@Valid @RequestBody ProdutoDTO dto) {
        ProdutoDTO produtoSalvo = service.salvarProduto(dto).getBody();
        return new ResponseEntity<>(produtoSalvo, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ProdutoDTO atualizarProduto(@PathVariable Long id, @Valid @RequestBody ProdutoDTO dto) {
        return service.atualizarProduto(id, dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirProduto(@PathVariable Long id) {
        service.excluirProduto(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/preco/{id}")
    public ResponseEntity<ProdutoDTO> atualizarPreco(@PathVariable int id, @RequestBody AtualizacaoPrecoDTO dto) {
        var produtoDTO = service.atualizarPreco(id, dto);
        return ResponseEntity.ok(produtoDTO.getBody());
    }

    @PatchMapping("/quantidadeEstoque/{id}")
    public ResponseEntity<ProdutoDTO> atualizarEstoque(@PathVariable int id, @RequestBody AtualizarEstoqueDTO dto) {
        var produtoDTO = service.atualizarEstoque(id, dto);
        return ResponseEntity.ok(produtoDTO.getBody());
    }
}
