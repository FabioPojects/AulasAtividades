package Animais;

public class Cachorro extends AnimalAB {
    private int comidaIngerida;
    private int caminhoPercorrido;
    private int horasDormidas;

    public Cachorro(String nome, int idade, double altura, double peso) {
        super(nome, "Animais.Cachorro", idade, "Terrestre", altura, peso);
    }

    @Override
    public void comer(int quantidadeComida) {
        comidaIngerida += quantidadeComida;
    }

    @Override
    public void mover(int distancia) {

    }

    @Override
    public void moverse(int distancia) {
        caminhoPercorrido += distancia;
    }

    @Override
    public void dormir(int horas) {
        horasDormidas += horas;
    }
}
