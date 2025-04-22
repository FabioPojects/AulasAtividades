package elastic.code;

public class Main {
    public static void main(String[] args) {
        Pessoa pessoa = new Fornecedor("fernando", 1000.0, 400.0);
        Pessoa empregado = new Empregado("Tales", 2000.0);
        Pessoa adm = new Administrador("jorge", 3500.0, 700.0);
        Pessoa operario = new Operario("Jão", 2000.0, 500.0);
        Pessoa vendedor = new Vendedor("Matheus", 2000.0, 1500.0);

        System.out.println(pessoa);
        System.out.println(empregado);
        System.out.println(adm);
        System.out.println(operario);
        System.out.println(vendedor);

    }
}