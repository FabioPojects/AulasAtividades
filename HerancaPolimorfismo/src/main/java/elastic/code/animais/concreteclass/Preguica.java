package elastic.code.animais.concreteclass;

import elastic.code.animais.abstractclass.Animal;
import elastic.code.animais.abstractclass.Quadrupede;

public class Preguica extends Animal {
    public Preguica(String nome, Integer idade) {
        super(nome, idade);
    }

    @Override
    public String emitirSom() {
        return "...";
    }

    public String subirArvore(){
        return "escalando";
    }
}
