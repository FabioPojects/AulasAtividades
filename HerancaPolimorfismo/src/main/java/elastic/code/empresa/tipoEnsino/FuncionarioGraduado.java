package elastic.code.empresa.tipoEnsino;

public class FuncionarioGraduado extends FuncionarioEnsinoMedio{
    protected String universidade;

    public FuncionarioGraduado(String nome, int codigoFuncional, String escolaBasico) {
        super(nome, codigoFuncional, escolaBasico);
        this.universidade = universidade;
        this.rendaTotal += rendaTotal;
    }

    @Override
    public void exibirDados() {
        super.exibirDados();
        System.out.println("Graduação na Universidade " + universidade);
    }
}
