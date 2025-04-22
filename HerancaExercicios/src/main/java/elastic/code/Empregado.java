package elastic.code;

public class Empregado extends Pessoa{
    private Integer codigoSetor;
    private Double salarioBase;
    private Double imposto;

    public Empregado(String nome, Double salarioBase) {
        super(nome);
        this.salarioBase = salarioBase;
    }

    public Integer getCodigoSetor() {
        return codigoSetor;
    }

    public void setCodigoSetor(Integer codigoSetor) {
        this.codigoSetor = codigoSetor;
    }

    public Double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(Double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public Double getImposto() {
        return salarioBase * 0.2;
    }

    public Double calcularSalario(){
        return salarioBase - getImposto();
    }

}
