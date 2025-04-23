package elastic.code.empresa.cargos;

import elastic.code.empresa.Funcionario;

public class Vendedor extends Funcionario {
    private static final double COMISSAO = 250.00;

    public Vendedor(String nome, int codigoFuncional, double salarioBase) {
        super(nome, codigoFuncional, salarioBase);
        this.setComissao(COMISSAO);
        this.atualizarRendaTotal();
    }

    @Override
    public void exibirDados() {
        super.exibirDados();
        System.out.println("Cargo: Vendedor");
    }
}