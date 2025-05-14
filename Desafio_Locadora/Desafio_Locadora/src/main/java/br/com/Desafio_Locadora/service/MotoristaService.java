package br.com.Desafio_Locadora.service;

import br.com.Desafio_Locadora.dto.CadastroMotoristaDTO;
import br.com.Desafio_Locadora.dto.ListagemMotoristaDTO;
import br.com.Desafio_Locadora.entity.Motorista;
import br.com.Desafio_Locadora.repository.MotoristaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MotoristaService {

    @Autowired
    private MotoristaRepository motoristaRepository;

    public ListagemMotoristaDTO saveMotorista(CadastroMotoristaDTO motoristaDTO) {
        if (motoristaRepository.existsByEmail(motoristaDTO.email())) {
            throw new RuntimeException("Este E-Mail já esta Cadastrado!");
        }
        var motorista = new Motorista(motoristaDTO);
        motoristaRepository.save(motorista);
        return toDto(motorista);
    }

    public ListagemMotoristaDTO toDto(Motorista motorista) {
        var listagemMotorista = new ListagemMotoristaDTO(motorista.getNome(), motorista.getCpf(), motorista.getEmail(), motorista.getNumeroCnh());
        return listagemMotorista;
    }

    public List<ListagemMotoristaDTO> listarMotoristas() {
        List<Motorista> motoristas = motoristaRepository.findAll();
        return motoristas.stream()
                .map(motorista -> new ListagemMotoristaDTO(motorista.getNome(), motorista.getCpf(), motorista.getEmail(), motorista.getNumeroCnh()))
                .toList();
    }

    public Motorista buscarPorId(Long id) {
        return motoristaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Motorista não encontrado!"));
    }

    public void atualizarMotorista(Long id, CadastroMotoristaDTO motoristaDTO) {
        Motorista motorista = motoristaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Motorista não encontrado!"));

        motorista.setNome(motoristaDTO.nome());
        motorista.setCpf(motoristaDTO.cpf());
        motorista.setEmail(motoristaDTO.email());
        motorista.setNumeroCnh(motoristaDTO.numeroCnh());

        motoristaRepository.save(motorista);
    }
}
