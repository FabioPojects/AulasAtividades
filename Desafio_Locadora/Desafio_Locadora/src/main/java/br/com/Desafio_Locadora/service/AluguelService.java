package br.com.Desafio_Locadora.service;


import br.com.Desafio_Locadora.dto.FinalizacaoAluguelDTO;
import br.com.Desafio_Locadora.entity.Aluguel;
import br.com.Desafio_Locadora.entity.Carros;
import br.com.Desafio_Locadora.entity.Motorista;
import br.com.Desafio_Locadora.repository.AluguelRepository;
import br.com.Desafio_Locadora.repository.CarroRepository;
import br.com.Desafio_Locadora.repository.MotoristaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AluguelService {

    @Autowired
    private AluguelRepository aluguelRepository;

    @Autowired
    private MotoristaRepository motoristaRepository;

    @Autowired
    private CarroRepository carroRepository;

    public Aluguel efetivarAluguel(FinalizacaoAluguelDTO dto) {
        Optional<Motorista> motorista = motoristaRepository.findById(dto.motoristaId());
        Optional<Carros> carro = carroRepository.findById(dto.carroId());

        if (motorista.isEmpty() || carro.isEmpty()) {
            throw new RuntimeException("Motorista ou carro não encontrado!");
        }

        if (dto.dataEntrega().after(dto.dataDevolucao())) {
            throw new RuntimeException("A data de entrega não pode ser posterior à data de devolução!");
        }

        if (carro.get().isReservado()) {
            throw new RuntimeException("O veículo já está reservado para outro aluguel!");
        }

        carro.get().setReservado(true);
        carroRepository.save(carro.get());

        Calendar dataPedido = Calendar.getInstance();
        Date dataEntrega = dto.dataEntrega();
        Date dataDevolucao = dto.dataDevolucao();

        var aluguel = new Aluguel(
                null,
                dataPedido,
                dataEntrega,
                dataDevolucao,
                BigDecimal.valueOf(dto.valorTotal()),
                carro.get(),
                null,
                motorista.get()
        );

        aluguelRepository.save(aluguel);
        return aluguel;
    }

    public void cadastrarAluguel(Aluguel aluguel) {
        aluguelRepository.save(aluguel);
    }

    public List<Aluguel> listarAlugueis() {
        return aluguelRepository.findAll();
    }

    public Optional<Aluguel> buscarAluguelPorId(Long id) {
        return aluguelRepository.findById(id);
    }

    public void atualizarAluguel(Long id, Aluguel aluguelAtualizado) {
        Aluguel aluguel = aluguelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluguel não encontrado!"));

        aluguel.setDataEntrega(aluguelAtualizado.getDataEntrega());
        aluguel.setDataDevolucao(aluguelAtualizado.getDataDevolucao());
        aluguel.setValorTotal(aluguelAtualizado.getValorTotal());

        aluguelRepository.save(aluguel);
    }

    public void excluirAluguel(Long id) {
        Aluguel aluguel = aluguelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluguel não encontrado!"));
        aluguelRepository.delete(aluguel);
    }


}

