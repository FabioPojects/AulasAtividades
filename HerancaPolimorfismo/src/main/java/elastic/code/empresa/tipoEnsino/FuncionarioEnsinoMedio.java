package elastic.code.empresa.tipoEnsino;

public class FuncionarioEnsinoMedio extends FuncionarioEnsinoBasico {
    protected String escolaMedio;

    public FuncionarioEnsinoMedio(String nome, int codigoFuncional, String escolaBasico) {
        super(nome, codigoFuncional, escolaBasico);
        this.escolaMedio = escolaMedio;
        this.rendaTotal += rendaTotal * 0.50;
    }

    @Override
    public void exibirDados() {
        super.exibirDados();
        System.out.println("Ensino Médio na escola " + escolaMedio);
    }
}
