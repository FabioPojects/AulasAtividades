package br.com.Desafio_Locadora.tipos;

public enum Sexo {
    MASCULINO("masculino"),
    FEMININO("feminino");

    private String sexo;

    Sexo(String valor){
        this.sexo = valor;
    }

    public static Sexo fromString(String text) {
        for (Sexo sexo : Sexo.values()) {
            if (sexo.sexo.equalsIgnoreCase(text)) {
                return sexo;
            }
        }
        throw new IllegalArgumentException("Nenhum Sexo Encontrado");
    }
}
