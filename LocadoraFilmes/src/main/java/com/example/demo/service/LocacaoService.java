package com.example.demo.service;

import com.example.demo.Dto.LocacaoDTO;
import com.example.demo.model.Filme;
import com.example.demo.model.Locacao;
import com.example.demo.model.Cliente;
import com.example.demo.repository.ClienteRepository;
import com.example.demo.repository.FilmeRepository;
import com.example.demo.repository.LocacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocacaoService {

    @Autowired
    private LocacaoRepository locacaoRepository;

    @Autowired
    private FilmeRepository filmeRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    public Locacao registrarLocacao(LocacaoDTO dto) throws Exception {
        Filme filme = filmeRepository.findById(dto.filmeId())
                .orElseThrow(() -> new Exception("Filme não encontrado."));

        if (filme.isAlugado()) {
            throw new Exception("O filme já está alugado.");
        }

        Cliente cliente = clienteRepository.findById(dto.clienteId())
                .orElseThrow(() -> new Exception("Cliente não encontrado."));

        filme.setAlugado(true);
        filmeRepository.save(filme);

        Locacao locacao = new Locacao();
        locacao.setFilme(filme);
        locacao.setCliente(cliente);
        locacao.setDataLocacao(dto.dataLocacao());
        locacao.setDataDevolucao(dto.dataDevolucao());
        locacao.setDevolvido(dto.devolvido() != null ? dto.devolvido() : false);

        return locacaoRepository.save(locacao);
    }

    public void devolverFilme(Long locacaoId) throws Exception {
        Locacao locacao = locacaoRepository.findById(locacaoId)
                .orElseThrow(() -> new Exception("Locação não encontrada."));
        Filme filme = locacao.getFilme();
        if (!locacao.getDevolvido()) {
            locacao.setDevolvido(true);
            filme.setAlugado(false);
            filmeRepository.save(filme);
            locacaoRepository.save(locacao);
        }
    }

    public List<Locacao> listarLocacoes() {
        return locacaoRepository.findAll();
    }
}
