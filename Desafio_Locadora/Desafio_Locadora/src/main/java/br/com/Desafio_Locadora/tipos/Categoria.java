package br.com.Desafio_Locadora.tipos;

public enum Categoria {
    HATCH_COMPACTO("hatch completo"),
    HATCH_MEDIO("hatch medio"),
    SEDAN_COMPACTO("sedan compacto"),
    SEDAN_MEDIO("sedan medio"),
    SEDAN_GRANDE("sedan grande"),
    MINIVAN("minivan"),
    ESPORTIVO("esportivo"),
    UTILITARIO_COMERCIAL("utilitario comercial");

    private String categoria;

    Categoria(String valor){
        this.categoria = valor;
    }

    public static Categoria fromString(String text) {
        for (Categoria categoria : Categoria.values()) {
            if (categoria.categoria.equalsIgnoreCase(text)) {
                return categoria;
            }
        }
        throw new IllegalArgumentException("Nenhuma Categoria Encontrada");
    }
}
