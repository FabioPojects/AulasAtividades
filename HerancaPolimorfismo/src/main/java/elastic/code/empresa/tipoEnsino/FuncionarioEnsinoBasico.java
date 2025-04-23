package elastic.code.empresa.tipoEnsino;

import elastic.code.empresa.Funcionario;

public class FuncionarioEnsinoBasico extends Funcionario {
    protected String escolaBasico;

    public FuncionarioEnsinoBasico(String nome, int codigoFuncional, String escolaBasico) {
        super(nome, codigoFuncional, Double.parseDouble(escolaBasico));
        this.escolaBasico = escolaBasico;
        this.rendaTotal += rendaTotal * 0.10;
    }

    @Override
    public void exibirDados() {
        super.exibirDados();
        System.out.println("Ensino Básico na escola " + escolaBasico);
    }
}
