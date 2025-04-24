package br.com.cursopcv.modelo.test;

import br.com.cursopcv.modelo.modelo.Produto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class ListarProdutos {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("controleestoque");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            List<Produto> produtos = em.createQuery("SELECT p FROM Produto p", Produto.class).getResultList();

            if (!produtos.isEmpty()) {
                for (Produto produto : produtos) {
                    System.out.println(
                            "<--------------->" + "\n" +
                            "Código: " + produto.getCod()  + "\n" +
                            "Nome: " + produto.getNome() + "\n" +
                            "Preço: R$" + produto.getPreco() + "\n") ;
                }
            } else {
                System.out.println("Nenhum Produto foi Encontrado");
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            em.close();
            emf.close();
        }
    }
}

