package Animais;

public class Pombo extends AnimalVoadorAB {
    private int distanciaVoada;

    public Pombo(String nome, int idade, double altura, double peso, int quantidadeAssas, double envergaduraAssa) {
        super(nome, "Animais.Pombo", idade, "Aéreo", altura, peso);
        this.quantidadeAssas = quantidadeAssas;
        this.envergaduraAssa = envergaduraAssa;
    }

    @Override
    public void voar(int distancia) {
        distanciaVoada += distancia;
    }

    @Override
    public void comer(int quantidadeComida) {
    }

    @Override
    public void moverse(int distancia) {
        voar(distancia);
    }

    @Override
    public void dormir(int horas) {
    }
}
