package elastic.code.menu;

import elastic.code.livrariavirtual.LivrariaVirtual;
import elastic.code.modelo.Eletronico;
import elastic.code.modelo.Impresso;
import elastic.code.modelo.Venda;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static LivrariaVirtual livraria = new LivrariaVirtual();

    public static void main(String[] args) {
        Main main = new Main();

        boolean continuar = true;

        while (continuar){

            System.out.println(main.exibirMenu());

            Integer opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao){
                case 1:
                    System.out.println("Deseja inserir impresso, eletronico ou ambos? ");
                    String cadastroLivro = scanner.nextLine();

                    switch (cadastroLivro){
                        case "impresso":
                            main.cadastroImpresso();
                            break;
                        case "eletronico":
                            main.cadastroEletronico();
                            break;
                        case "ambos":
                            main.cadastroAmbos();
                            break;
                    }

                    System.out.println("Livro cadastrado com sucesso!! \n");
                    break;

                case 2:


                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    System.out.println("Finalizando aplicação...");
                    continuar = false;
                    break;
            }
        }
    }

    public String exibirMenu(){
        return """
                Bem Vindo a livraria virtual FeFa's
                ####################################
                Opções:
                1 - Cadastrar Livro
                2 - Realizar Venda
                3 - Listar Livros
                4 - Lista Vendas
                5 - Sair do programa
                """;
    }

    public void cadastroImpresso(){
        System.out.println("Titulo: ");
        String titulo = scanner.nextLine();
        System.out.println("Autores: ");
        String autores = scanner.nextLine();
        System.out.println("Editora: ");
        String editora = scanner.nextLine();
        System.out.println("Preço: ");
        Float preco = scanner.nextFloat();
        System.out.println("Quantidade estoque: ");
        Integer qtd = scanner.nextInt();

        livraria.cadastrarLivroImpresso(new Impresso(titulo, autores, editora, preco,qtd));
    }

    public void cadastroEletronico(){
        System.out.println("Titulo: ");
        String titulo = scanner.nextLine();
        System.out.println("Autores: ");
        String autores = scanner.nextLine();
        System.out.println("Editora: ");
        String editora = scanner.nextLine();
        System.out.println("Preço: ");
        Float preco = scanner.nextFloat();
        System.out.println("Tamanho do livro em Gb: ");
        Integer tamanho = scanner.nextInt();

        livraria.cadastrarLivroEletronico(new Eletronico(titulo, autores, editora, preco, tamanho));
    }

    public void cadastroAmbos(){
        System.out.println("Titulo: ");
        String titulo = scanner.nextLine();
        System.out.println("Autores: ");
        String autores = scanner.nextLine();
        System.out.println("Editora: ");
        String editora = scanner.nextLine();
        System.out.println("Preço: ");
        Float preco = scanner.nextFloat();
        System.out.println("Tamanho do livro Eletronico em Gb: ");
        Integer tamanho = scanner.nextInt();
        System.out.println("Quantidade em estoque do livro físico: ");
        Integer qtd = scanner.nextInt();

        livraria.cadastrarLivroEletronico(new Eletronico(titulo, autores, editora, preco, tamanho));
        livraria.cadastrarLivroImpresso(new Impresso(titulo, autores, editora, preco, qtd));
    }

    public void realizarVenda(){
        System.out.println("Nome do Cliente: ");
        String clientes = scanner.nextLine();
        System.out.println("Quantidade de Livros: ");
        Integer quantidade = scanner.nextInt();


        Venda venda = new Venda(clientes, quantidade);
        livraria.realizarVenda(venda);
    }

}
