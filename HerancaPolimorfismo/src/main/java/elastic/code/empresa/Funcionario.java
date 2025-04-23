package elastic.code.empresa;

public class Funcionario {
    protected String nome;
    protected int codigoFuncional;
    protected double rendaTotal;
    protected double salarioBase;
    protected double comissao;

    public Funcionario(String nome, int codigoFuncional, double salarioBase) {
        this.nome = nome;
        this.codigoFuncional = codigoFuncional;
        this.salarioBase = salarioBase;
        this.comissao = 0.0;
        this.rendaTotal = salarioBase + comissao;
    }

    @Override
    public String toString() {
        return "Nome: " + nome +
                ", Comissão: R$" + comissao +
                ", Salário Total: R$" + rendaTotal;
    }

        public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodigoFuncional() {
        return codigoFuncional;
    }

    public void setCodigoFuncional(int codigoFuncional) {
        this.codigoFuncional = codigoFuncional;
    }

    public double getRendaTotal() {
        return rendaTotal;
    }

    public void setRendaTotal(double rendaTotal) {
        this.rendaTotal = rendaTotal;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
        atualizarRendaTotal();
    }

    public double getComissao() {
        return comissao;
    }

    public void setComissao(double comissao) {
        this.comissao = comissao;
        atualizarRendaTotal();
    }

    protected void atualizarRendaTotal() {
        this.rendaTotal = this.salarioBase + this.comissao;
    }

    public void exibirDados() {
        System.out.println("Nome: " + nome);
        System.out.println("Código Funcional: " + codigoFuncional);
        System.out.println("Salário Base: R$" + salarioBase);
        System.out.println("Comissão: R$" + comissao);
        System.out.println("Renda Total: R$" + rendaTotal);
    }
}