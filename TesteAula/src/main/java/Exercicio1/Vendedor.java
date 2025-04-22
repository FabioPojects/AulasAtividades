package Exercicio1;

public class Vendedor extends Empregado {
    private double valorVendas;
    private double comissao;

    public Vendedor() {}

    public Vendedor(double valorVendas, double comissao) {
        this.valorVendas = valorVendas;
        this.comissao = comissao;
    }

    public double getValorVendas() { return valorVendas; }

    public void setValorVendas(double valorVendas) { this.valorVendas = valorVendas; }

    public double getComissao() { return comissao; }

    public void setComissao(double comissao) { this.comissao = comissao; }

    @Override
    public double calcularSalario() {
        return super.calcularSalario() + (valorVendas * (comissao / 100));
    }
}