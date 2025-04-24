package br.com.cursopcv.modelo.test;

import br.com.cursopcv.modelo.modelo.Produto;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class AlteracaoDeProduto {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("controleestoque");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            Produto produto = em.find(Produto.class, 2);

            if (produto != null) {
                produto.setPreco(345.00);
                System.out.println("Preço Atualizado para R$345.00");
                em.merge(produto);
            } else {
                System.out.println("Produto com Código 2 não Encontrado");
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
