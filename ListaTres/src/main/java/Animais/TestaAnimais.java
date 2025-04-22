package Animais;

public class TestaAnimais {
    public static void main(String[] args) {

        Cachorro cachorro = new Cachorro("Max", 5, 0.6, 20);
        cachorro.comer(100);
        cachorro.moverse(10);
        cachorro.dormir(8);
        System.out.println("Cachorro criado: " + cachorro.nome + ", idade: " + cachorro.idade);


        Pombo pombo = new Pombo("Pombo Azul", 2, 0.3, 1, 2, 0.5);
        pombo.comer(20);
        pombo.voar(50);
        pombo.dormir(5);
        System.out.println("Pombo criado: " + pombo.nome + ", tipo: " + pombo.tipoAnimal);
    }
}