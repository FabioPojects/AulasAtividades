package elastic.code.livrariavirtual;

import elastic.code.modelo.Eletronico;
import elastic.code.modelo.Impresso;
import elastic.code.modelo.Venda;
import jakarta.persistence.*;

import java.util.List;
import java.util.Scanner;

public class LivrariaVirtual{
    EntityManagerFactory emf;
    EntityManager em;

    public LivrariaVirtual() {
        emf = Persistence.createEntityManagerFactory("livrariavirtual");
        em = emf.createEntityManager();
    }

    private final Integer MAX_IMPRESSOS = 10;
    private final Integer MAX_ELETRONICOS = 10;
    private final Integer  MAX_VENDAS = 10;

    private List<Impresso> impressos;

    private List<Eletronico> eletronicos;

    private Integer numImpressos;

    private Integer numEletronicos;

    private Integer numVendas;

    public void cadastrarLivroImpresso(Impresso livroImpresso){
        em.getTransaction().begin();
        livroImpresso.setFrete(livroImpresso.getFrete());
        em.persist(livroImpresso);
        em.getTransaction().commit();
    }

    public void cadastrarLivroEletronico(Eletronico livroEletronico){
        em.getTransaction().begin();
        em.persist(livroEletronico);
        em.getTransaction().commit();
    }

    public List<Impresso> listarLivrosImpressos(){
        em.getTransaction().begin();
        List<Impresso> impressos = em.createNativeQuery("SELECT * FROM livro where tipo_livro = livro_impresso", Impresso.class).getResultList();
        em.getTransaction().commit();
        return impressos;
    }

    public List<Eletronico> listarLivrosEletronicos(){
        em.getTransaction().begin();
        List<Eletronico> eletronicos = em.createNativeQuery("SELECT * FROM livro where tipo_livro = livro_eletronico", Eletronico.class).getResultList();
        em.getTransaction().commit();
        return eletronicos;
    }

    public void realizarVenda(Venda venda){
        em.getTransaction().begin();
        em.persist(venda);
        em.getTransaction().commit();
    }

}
