package elastic.code;

public class Vendedor extends Empregado{

    private Double valorVendas;
    private Double comissao;

    public Vendedor(String nome, Double salarioBase, Double valorVendas) {
        super(nome, salarioBase);
        this.valorVendas = valorVendas;
    }

    public void setValorVendas(Double valorVendas) {
        this.valorVendas = valorVendas;
    }

    public Double getValorVendas() {
        return valorVendas;
    }

    public Double getComissao() {
        return getValorVendas() * 0.8;
    }
}
