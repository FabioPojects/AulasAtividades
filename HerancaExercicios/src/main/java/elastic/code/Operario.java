package elastic.code;

public class Operario extends Empregado{

    private Double valorProducao;
    private Double Comissao;

    public Operario(String nome, Double salarioBase, Double valorProducao) {
        super(nome, salarioBase);
        this.valorProducao = valorProducao;
    }

    @Override
    public Double calcularSalario() {
        return super.calcularSalario() + getComissao();
    }

    public Double getValorProducao() {
        return valorProducao;
    }

    public void setValorProducao(Double valorProducao) {
        this.valorProducao = valorProducao;
    }

    public Double getComissao() {
        return valorProducao * 0.6;
    }
}
