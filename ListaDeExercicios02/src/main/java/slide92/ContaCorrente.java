package slide92;

public class ContaCorrente {
    private Long numero;
    private String tipo;
    private Cliente titular;
    private Cliente segundoTitular;
    private Double saldo;
    private Double limiteTotal;

    public void credito(Double valor){
        this.saldo += valor;
    }
    public void debito(Double valor){
        this.saldo -= valor;
    }
    public boolean estaDevedor(){
        return saldo >= 0;
    }
    public String resumo(Double valor){
        if (estaDevedor()){
            return toString() + "Procure seu gerente!";
        }
        return toString();
    }

    @Override
    public String toString() {
        return "Conta Corrente{" +
                "Numero: " + numero +
                ", Titular: " + titular +
                ", Segundo Titular: " + segundoTitular +
                ", Saldo: " + saldo +
                ", Limite Total: " + limiteTotal +
                '}';
    }
}
