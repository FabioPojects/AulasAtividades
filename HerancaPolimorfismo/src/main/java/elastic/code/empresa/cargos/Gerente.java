package elastic.code.empresa.cargos;

import elastic.code.empresa.Funcionario;

public class Gerente extends Funcionario {
    private static final double COMISSAO = 1500.00;

    public Gerente(String nome, int codigoFuncional, double salarioBase) {
        super(nome, codigoFuncional, salarioBase);
        this.setComissao(COMISSAO);
        this.atualizarRendaTotal();
    }

    @Override
    public void exibirDados() {
        super.exibirDados();
        System.out.println("Cargo: Gerente");
    }
}