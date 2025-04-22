package elastic.code.funcionarios;

public class Funcionario {
    private Integer codigo;
    private String nome;
    private Ensino nivelEnsino;
    private Escola escola;
    private Universidade universidade;
    public final Double rendaBasica = 1000.0;
    private Double rendaTotal;


    public Funcionario(Integer codigo, String nome, Escola escola, Ensino ensino) {
        this.codigo = codigo;
        this.nome = nome;
        this.nivelEnsino = ensino;
        this.escola = escola;
    }

    public Funcionario(Integer codigo, String nome, Escola escola, Universidade universidade, Ensino ensino) {
        this.codigo = codigo;
        this.nome = nome;
        this.nivelEnsino = ensino;
        this.escola = escola;
        this.universidade = universidade;
    }

    public Double getRendaTotal() {
      if (nivelEnsino.equals(Ensino.BASICO)){
          return rendaBasica * 1.1;
      }else if (nivelEnsino.equals(Ensino.MEDIO)){
          return (rendaBasica * 1.1) + ((rendaBasica * 1.1) * 0.5);
      } else if (nivelEnsino.equals(Ensino.GRADUACAO)) {
          return (rendaBasica * 1.1) + ((rendaBasica * 1.1) * 0.5) + rendaBasica;
      }
        return rendaBasica;
    }

    public void setEscola(Escola escola) {
        this.escola = escola;
    }

    public void setUniversidade(Universidade universidade) {
        this.universidade = universidade;
    }

    public void atualizarVidaAcademica(Ensino ensino){
        this.nivelEnsino = ensino;
    }

    @Override
    public String toString() {
        String resposta = "Funcionario: " +
                "Codigo=" + codigo +
                ", Nome= '" + nome + '\'' +
                ", Renda = " + getRendaTotal() +
                ", Nivel de Ensino= " + nivelEnsino;

        if (nivelEnsino.equals(Ensino.BASICO) || nivelEnsino.equals(Ensino.MEDIO)){
            resposta += ", Escola = " + escola;
        } else if (nivelEnsino.equals(Ensino.GRADUACAO)) {
            resposta += ", Universidade = " + universidade;
        }
        return resposta;
    }
}
