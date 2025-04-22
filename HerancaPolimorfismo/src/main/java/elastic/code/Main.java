package elastic.code;

import elastic.code.animais.abstractclass.Animal;
import elastic.code.animais.concreteclass.Cachorro;

public class Main {
    public static void main(String[] args) {
        Animal cachorro = new Cachorro("Tobias", 7);
        Animal cavalo = new Cachorro("Trovão", 21);
        Animal preguica = new Cachorro("Shampoo", 4);

        System.out.println(cachorro.emitirSom());
        System.out.println(cavalo.emitirSom());
        System.out.println(preguica.emitirSom());
    }
}