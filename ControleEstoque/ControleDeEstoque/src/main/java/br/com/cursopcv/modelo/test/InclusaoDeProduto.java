package br.com.cursopcv.modelo.test;

import br.com.cursopcv.modelo.modelo.Produto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class InclusaoDeProduto {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("controleestoque");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            Produto panela = new Produto();
            panela.setNome("Palena");
            panela.setDescricao("Panela de Presão 10 Litros");
            panela.setPreco(56.80);
            em.persist(panela);

            Produto cama = new Produto();
            cama.setNome("Cama");
            cama.setDescricao("Cama de Casal Big");
            cama.setPreco(450.68);
            em.persist(cama);

            Produto caixaSom = new Produto();
            caixaSom.setNome("Caixa de Som");
            caixaSom.setDescricao("Caixa de Som JBL");
            caixaSom.setPreco(160.00);
            em.persist(caixaSom);

            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction();
        } finally {
            em.close();
            emf.close();
        }

        try {
            em.getTransaction().begin();
            Produto produtoExistente = em.find(Produto.class, 1);

            if (produtoExistente != null) {
                produtoExistente.setNome("Panela Atualizada");
                em.merge(produtoExistente);
            }

            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());;
        } finally {
            em.close();
            emf.close();
        }
    }
}
