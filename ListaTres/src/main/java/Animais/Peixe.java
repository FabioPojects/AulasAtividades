package Animais;

public class Peixe extends AnimalMarinhoAB {
    private int distanciaNadada;

    public Peixe(String nome, int idade, double altura, double peso) {
        super(nome, "Animais.Peixe", idade, "Marinho", altura, peso);
    }

    @Override
    public void nadar(int distancia) {
        distanciaNadada += distancia;
    }

    @Override
    public void comer(int quantidadeComida) {
    }

    @Override
    public void moverse(int distancia) {
        nadar(distancia);
    }

    @Override
    public void dormir(int horas) {
    }
}
