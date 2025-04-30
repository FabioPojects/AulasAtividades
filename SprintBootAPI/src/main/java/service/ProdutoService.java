package service;

import dto.AtualizacaoPrecoDTO;
import dto.AtualizarEstoqueDTO;
import dto.ProdutoDTO;
import exception.ResourceNotFoundException;
import jakarta.persistence.criteria.CriteriaBuilder;
import model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ProdutoRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository repository;

    public List<ProdutoDTO> listarProdutos() {
        return repository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public ProdutoDTO buscarProdutoPorId(Integer id) {
        Produto produto = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado."));
        return toDTO(produto);
    }

    public ProdutoDTO salvarProduto(ProdutoDTO dto) {
        Produto produto = new Produto(dto);
        produto = repository.save(produto);
        return toDTO(produto);
    }

    public ProdutoDTO atualizarProduto(Integer id, ProdutoDTO dto) {
        Produto produto = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado."));
        produto.setNome(dto.nome());
        produto.setCategoria(dto.categoria());
        produto.setPreco(dto.preco());
        produto.setQuantidadeEstoque(dto.quantidade_estoq());
        produto.setDescricao(dto.descricao());
        produto.setDataValidade(dto.dataValidade());
        repository.save(produto);
        return toDTO(produto);
    }

    public void excluirProduto(Integer id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Produto não encontrado.");
        }
        repository.deleteById(id);
    }

    public ProdutoDTO toDTO(Produto produto) {
        ProdutoDTO dto = new ProdutoDTO(produto.getNome(),
                produto.getCategoria(),
                produto.getPreco(),
                produto.getQuantidadeEstoque(),
                produto.getDescricao(),
                produto.getDataValidade());
        return dto;
    }

    public ProdutoDTO atualizarPreco(Integer id, AtualizacaoPrecoDTO dto) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Produto não Encontrado.");
        }
        var produto =  repository.findById(id).get();
        produto.setPreco(dto.preco());
        repository.save(produto);
        return toDTO(produto);
    }

    public ProdutoDTO atualizarEstoque(Integer id, AtualizarEstoqueDTO dto) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Produto não Encontrado.");
        }
        var produto = repository.findById(id).get();
        produto.setQuantidadeEstoque(dto.quantidadeEstoque());
        repository.save(produto);
        return toDTO(produto);
    }
}