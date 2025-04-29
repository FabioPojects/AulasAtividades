package elastic.code.livrariavirtual;

import elastic.code.modelo.Eletronico;
import elastic.code.modelo.Impresso;
import elastic.code.modelo.Livro;
import elastic.code.modelo.Venda;
import jakarta.persistence.*;

import java.util.List;

public class LivrariaVirtual{
    EntityManagerFactory emf;
    EntityManager em;

    public LivrariaVirtual() {
        emf = Persistence.createEntityManagerFactory("livrariavirtual");
        em = emf.createEntityManager();
    }

    private final Integer MAX_IMPRESSOS = 10;
    private final Integer MAX_ELETRONICOS = 20;
    private final Integer  MAX_VENDAS = 50;

    private List<Impresso> impressos;
    private List<Eletronico> eletronicos;
    private Integer numImpressos;
    private Integer numEletronicos;
    private Integer numVendas;

    public Integer getMAX_IMPRESSOS() {
        return MAX_IMPRESSOS;
    }

    public Integer getMAX_ELETRONICOS() {
        return MAX_ELETRONICOS;
    }

    public Integer getMAX_VENDAS() {
        return MAX_VENDAS;
    }

    public void abrirConexao(){
        em.getTransaction().begin();
    }

    public void fecharConexao(){
        em.close();
    }

    public void cadastrarLivroImpresso(Impresso livroImpresso){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        livroImpresso.setFrete(livroImpresso.getFrete());
        em.persist(livroImpresso);
        em.getTransaction().commit();
    }

    public void atualizarEstoque(List<Livro> livros){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

            for (Livro livro : livros) {
                if (livro instanceof Impresso impresso) {
                    impresso.setEstoque(impresso.getEstoque() - 1);
                    em.merge(impresso);
                }
            }
             em.getTransaction().commit();
    }

    public void cadastrarLivroEletronico(Eletronico livroEletronico){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(livroEletronico);
        em.getTransaction().commit();
    }

    public List<Impresso> listarLivrosImpressos(){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        List<Impresso> impressos = em.createNativeQuery("SELECT * FROM livro where tipo_livro = 'livro_impresso'", Impresso.class).getResultList();
        return impressos;
    }

    public List<Eletronico> listarLivrosEletronicos(){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        List<Eletronico> eletronicos = em.createNativeQuery("SELECT * FROM livro where tipo_livro = 'livro_eletronico'", Eletronico.class).getResultList();
        return eletronicos;
    }

    public void realizarVenda(Venda venda){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(venda);
        em.getTransaction().commit();
    }

    public Livro getLivroById(Integer id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Livro livro = em.find(Livro.class, id);
        em.getTransaction().commit();
        return livro;
    }

    public List<Livro> listarAmbos() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        List<Livro> ambos = em.createNativeQuery("SELECT * FROM livro", Livro.class).getResultList();
        return ambos;
    }

    public List<Venda> listarVendas() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        List<Venda> vendas = em.createNativeQuery("SELECT * FROM venda", Venda.class).getResultList();
        return vendas;
    }

    public Integer contagemImpressos(){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Integer qtdImpressos = em.createNativeQuery("SELECT COUNT(*) FROM livro WHERE tipo_livro = 'livro_impresso'", Integer.class).getFirstResult();
        return qtdImpressos;
    }

    public Integer contagemEletronico(){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Integer qdtEletronicos = em.createNativeQuery("SELECT COUNT(*) FROM livro WHERE tipo_livro = 'livro_eletronico'", Integer.class).getFirstResult();
        return qdtEletronicos;
    }

    public Integer contagemTotalLivros(){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Integer qtdTotal = em.createNativeQuery("SELECT COUNT(*) FROM livro", Integer.class).getFirstResult();
        return qtdTotal;
    }

    public Integer contagemVendas(){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Integer qtdTotal = em.createNativeQuery("SELECT COUNT(*) FROM venda", Integer.class).getFirstResult();
        return qtdTotal;
    }


}
