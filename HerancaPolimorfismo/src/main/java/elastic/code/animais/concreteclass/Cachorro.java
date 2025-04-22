package elastic.code.animais.concreteclass;

import elastic.code.animais.abstractclass.Animal;
import elastic.code.animais.abstractclass.Quadrupede;

public class Cachorro extends Animal implements Quadrupede {

    public Cachorro(String nome, Integer idade) {
        super(nome, idade);
    }

    @Override
    public String emitirSom() {
        return "Au Au";
    }

    @Override
    public String correr() {
        return "patinhas";
    }
}
