package elastic.code.empresa;

public class RegistroAcademico {
    public static void main(String[] args) {
        Funcionario funcionario = new Funcionario("Fabio", 12345, 5000);

        funcionario.setNome("Fabio Thiago");
        funcionario.setCodigoFuncional(46738);
        funcionario.setRendaTotal(1000);
        funcionario.setSalarioBase(5000);

        System.out.println("Nome Atualizado: " + funcionario.getNome());
        System.out.println("Código Funcional Atualizado: " + funcionario.getCodigoFuncional());

        funcionario.exibirDados();
    }
}
