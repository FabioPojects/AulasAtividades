package elastic.code;

public class Administrador extends Empregado{
    private Double ajudaDeCusto;

    public Administrador(String nome, Double salarioBase, Double ajudaDeCusto) {
        super(nome, salarioBase);
        this.ajudaDeCusto = ajudaDeCusto;
    }

    @Override
    public Double calcularSalario() {
        return super.calcularSalario() + ajudaDeCusto;
    }
}
