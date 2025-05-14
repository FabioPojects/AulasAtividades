package br.com.Desafio_Locadora.service;


import br.com.Desafio_Locadora.dto.CarroDTO;
import br.com.Desafio_Locadora.entity.Carros;
import br.com.Desafio_Locadora.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarroService {

    @Autowired
    private CarroRepository carroRepository;


    public List<Carros> listarCarrosDisponiveis() {
        return carroRepository.findAll();
    }

    public List<CarroDTO> listarTodosCarros() {
        return carroRepository.findAll().stream()
                .map(carro -> new CarroDTO(carro.getId_carros(), carro.getModeloCarro(), carro.getPlaca(), carro.getReservado()))
                .toList();
    }

    public Optional<Carros> buscarCarroPorId(Long id) {
        return carroRepository.findById(id);
    }

    public void cadastrarCarro(Carros carro) {
        carroRepository.save(carro);
    }

    public void reservarCarro(Long idCarro) {
        Optional<Carros> carro = carroRepository.findById(idCarro);

        if (carro.isEmpty()) {
            throw new RuntimeException("Carro não encontrado!");
        }

        if (carro.get().isReservado()) {
            throw new RuntimeException("O veículo já está reservado para outro aluguel!");
        }

        carro.get().setReservado(true);
        carroRepository.save(carro.get());
    }

    public void atualizarCarro(Long id, Carros carroAtualizado) {
        Carros carro = carroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Carro não encontrado!"));

        carro.setModeloCarro(carroAtualizado.getModeloCarro());
        carro.setPlaca(carroAtualizado.getPlaca());
        carro.setReservado(carroAtualizado.isReservado());

        carroRepository.save(carro);
    }

    public void excluirCarro(Long id) {
        Carros carro = carroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Carro não encontrado!"));
        carroRepository.delete(carro);
    }
}
