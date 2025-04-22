package elastic.code.animais.concreteclass;

import elastic.code.animais.abstractclass.Animal;
import elastic.code.animais.abstractclass.Quadrupede;

public class Cavalo extends Animal implements Quadrupede {

    public Cavalo(String nome, Integer idade) {
        super(nome, idade);
    }

    @Override
    public String emitirSom() {
        return "Bom Bom pruu";
    }

    @Override
    public String correr() {
        return "Pocotó";
    }
}
