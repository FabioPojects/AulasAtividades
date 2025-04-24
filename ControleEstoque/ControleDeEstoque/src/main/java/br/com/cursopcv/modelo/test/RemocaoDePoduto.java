package br.com.cursopcv.modelo.test;

import br.com.cursopcv.modelo.modelo.Produto;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class RemocaoDePoduto {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("controleestoque");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            Produto produto = em.find(Produto.class, 1);

            if (produto != null) {
                em.remove(produto);
                System.out.println("Produto Removido com sucessso!");
            } else {
                System.out.println("Produto Com Código 3 não Encontrado.");
            }

            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        em.close();
        emf.close();
    }
}
