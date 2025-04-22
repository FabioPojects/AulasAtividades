package elastic.code.animais.veterinario;

import elastic.code.animais.abstractclass.Animal;

public class Veterinario {
    protected String nome;
    protected String cnpj;
    protected Integer idade;

    public String examinar(Animal animal){
        return "Examinando o " + animal.getNome() + " " + animal.emitirSom();
    }

}
