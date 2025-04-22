package elastic.code.animais.zoologico;

import elastic.code.animais.abstractclass.Animal;

public class Zoologico {
    private String nome;
    private Animal[] animais;

    public Zoologico(String nome, String[] animais) {
        this.nome = nome;
        this.animais = new Animal[10];
    }

    public String guardarNaJaula(Animal animal){
        for (int i = 0; i < animais.length; i++){
            if (animais[i] == null){
                animais[i] = animal;
                return "Animal inserido com sucesso!";
            }
        }
        return "Não há jaulas disponíveis";
    }

    public String emitirSons(){
        String resposta = "";
        for (int i = 0; i < animais.length; i++){
            resposta += "\n" + animais[i].getNome() + " " + animais[i].emitirSom();
;        }
        return resposta;
    }

}
