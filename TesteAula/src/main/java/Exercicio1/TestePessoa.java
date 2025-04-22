package Exercicio1;

public class TestePessoa {
    public static void main(String[] args) {

        Pessoa pessoa1 = new Pessoa();
        System.out.println("Pessoa 1 - Nome: " + pessoa1.getNome());

        Pessoa pessoa2 = new Pessoa();
        pessoa2.setNome("Fabio");
        System.out.println("Pessoa 2 - Nome: " + pessoa2.getNome());

        Pessoa pessoa3 = new Pessoa("Fabio", "São Paulo", "11977164783");
        pessoa3.setNome("Trovo");
        pessoa3.setEndereco("Carapicuiba");
        pessoa3.setTelefone("11987876123");

        System.out.println("Pessoa 3 - Nome: " + pessoa3.getNome() +
                            " - Endereço: " + pessoa3.getEndereco() +
                            " - Telefone: " + pessoa3.getTelefone());


    }
}
