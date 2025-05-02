package com.example.demo.controller;


import com.example.demo.model.Locacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.service.LocacaoService;
import com.example.demo.Dto.LocacaoDTO;

import java.util.List;

@RestController
@RequestMapping("/locacoes")
public class LocacaoController {

    @Autowired
    private LocacaoService locacaoService;

    @PostMapping
    public ResponseEntity<Locacao> registrarLocacao(@RequestBody LocacaoDTO dto) {
        try {
            Locacao locacaoSalva = locacaoService.registrarLocacao(dto);
            return ResponseEntity.ok(locacaoSalva);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Locacao>> listarLocacoes() {
        List<Locacao> locacoes = locacaoService.listarLocacoes();
        return ResponseEntity.ok(locacoes);
    }

    @GetMapping("/{id}/devolucao")
    public ResponseEntity<Void> devolverFilme(@PathVariable Long id) {
        try {
            locacaoService.devolverFilme(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
