package elastic.code.funcionarios;

public enum Ensino {
    NAO_ESTUDOU("Não estudou"),
    BASICO("Terminou o ensino básico."),
    MEDIO("Terminou o ensino médio."),
    GRADUACAO("Terminou a graduação.");

    private  String descricao;

    Ensino(String descricao){
        this.descricao = descricao;
    }
    public String getDescricao(){
        return descricao;
    }
}
