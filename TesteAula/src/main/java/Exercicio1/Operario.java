package Exercicio1;

public class Operario extends Empregado{

    private double valorProducao;
    private double comissao;

    public Operario(){}

    public Operario(double valorProducao, double comissao){
        this.valorProducao = valorProducao;
        this.comissao = comissao;
    }

    public double getValorProducao() {return valorProducao;}

    public void setValorProducao(double valorProducao) {this.valorProducao = valorProducao;}

    public double getComissao() {return comissao;}

    public void setComissao(double comissao) {this.comissao = comissao;}

    @Override
    public double calcularSalario() {
        return super.calcularSalario() + (valorProducao * comissao);
    }
}
