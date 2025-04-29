package elastic.code.menu;

import elastic.code.livrariavirtual.LivrariaVirtual;
import elastic.code.modelo.Eletronico;
import elastic.code.modelo.Impresso;
import elastic.code.modelo.Livro;
import elastic.code.modelo.Venda;

import java.util.List;
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
                    main.realizarVenda();
                    break;

                case 3:
                    System.out.println("Deseja listar impresso, eletronico ou ambos? ");
                    String listarLivros = scanner.nextLine();

                    switch (listarLivros){
                        case "impresso":
                            main.listarImpressos();
                            break;
                        case "eletronico":
                            main.listarEletronicos();
                            break;
                        case "ambos":
                            main.listarAmbos();
                            break;
                    }
                    break;

                case 4:
                    main.listarVendas();
                    break;

                case 5:
                    System.out.println("Finalizando aplicação...");
                    continuar = false;
                    break;
            }
        }
        livraria.fecharConexao();
    }

    public String exibirMenu(){
        return """
                
                Bem Vindo a livraria virtual FeFa's
                ===================================
                Opções:
                1 - Cadastrar Livro
                2 - Realizar Venda
                3 - Listar Livros
                4 - Listar Vendas
                5 - Sair do programa
                ===================================
                
                Selecione Sua opção: """;
    }

    public void cadastroImpresso(){
        if (livraria.contagemImpressos() >= livraria.getMAX_IMPRESSOS()){
            System.out.println("Limite de livros impressos cadastrados atingido!");
        }else {
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
    }

    public void cadastroEletronico(){
        if (livraria.contagemEletronico() >= livraria.getMAX_ELETRONICOS()){
            System.out.println("Limite de livros eletrônicos cadastrados atingido!");
        }else {
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
        scanner.nextLine();

        System.out.println("Tamanho do livro Eletronico em Gb: ");
        Integer tamanho = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Quantidade em estoque do livro físico: ");
        Integer qtd = scanner.nextInt();
        scanner.nextLine();

        if (livraria.contagemImpressos() < livraria.getMAX_IMPRESSOS()){
            livraria.cadastrarLivroImpresso(new Impresso(titulo, autores, editora, preco,qtd));
        }else {
            System.out.println("Limite de livros impressos cadastrados já foi atingido!");
        }

        if (livraria.contagemEletronico() < livraria.getMAX_ELETRONICOS()){
            livraria.cadastrarLivroEletronico(new Eletronico(titulo, autores, editora, preco, tamanho));
        }else {
            System.out.println("Limite de livros eletrônicos cadastrados já foi atingido!");
        }
    }

    public void realizarVenda(){
        if (livraria.contagemVendas() >= livraria.getMAX_VENDAS()){
            System.out.println("Limite de vendas atingido!");
        }else {

            Venda venda = new Venda();
            System.out.println("Nome do Cliente: ");
            venda.setClientes(scanner.nextLine());

            System.out.println("Insira a quantidade de Livros que Deseja Comprar");
            int quantidade = scanner.nextInt();

            for (int i = 1; i <= quantidade; i++) {
                System.out.println("""
                    ===============================
                    ESCOLHA UMA OPÇÃO
                    
                    1 -> Impresso.
                    2 -> Eletrônico
                    3 -> Cancelar compra
                    
                    ===============================
                    """);
                int opcao = scanner.nextInt();

                if (opcao == 1) {
                    List<Impresso> impressos = livraria.listarLivrosImpressos();
                    impressos.forEach(livroDaVez -> System.out.println("ID: " + livroDaVez.getId_livro() +
                            " Título: " + livroDaVez.getTitulo() +
                            " Preço: R$" + livroDaVez.getPreco()));
                    System.out.print("Selecione o Livro Desejado pelo ID: ");
                    int livroSelecionado = scanner.nextInt();
                    venda.addLivro(livraria.getLivroById(livroSelecionado));

                }else if(opcao == 2){
                    List<Eletronico> eletronicos = livraria.listarLivrosEletronicos();
                    eletronicos.forEach(livroDaVez -> System.out.println("ID: " + livroDaVez.getId_livro() +
                            " Título: " + livroDaVez.getTitulo() +
                            " Preço: R$" + livroDaVez.getPreco()));
                    System.out.print("Selecione o Livro Desejado pelo ID: ");
                    int livroSelecionado = scanner.nextInt();
                    venda.addLivro(livraria.getLivroById(livroSelecionado));

                }else{
                    break;
                }
            }

            venda.setValor(venda.getLivros().stream()
                    .map(Livro::getPreco)
                    .reduce(0.00f, Float::sum));

            livraria.atualizarEstoque(venda.getLivros());
            livraria.realizarVenda(venda);
            System.out.println("Venda realizada com sucesso!!");
        }
    }

    public void listarImpressos(){
        System.out.println("##############################");
        System.out.println("Listando livros impressos:");
        List<Impresso> impressos = livraria.listarLivrosImpressos();
        impressos.forEach(livroDaVez -> System.out.println("ID: " + livroDaVez.getId_livro() +
                " Título: " + livroDaVez.getTitulo() +
                " Preço: R$" + livroDaVez.getPreco()));
    }

    public void listarEletronicos(){
        System.out.println("##############################");
        System.out.println("Listando livros eletrônicos:");
        List<Eletronico> eletronicos = livraria.listarLivrosEletronicos();
        eletronicos.forEach(livroDaVez -> System.out.println("ID: " + livroDaVez.getId_livro() +
                " Título: " + livroDaVez.getTitulo() +
                " Preço: R$" + livroDaVez.getPreco()));
    }

    public void listarAmbos() {
        System.out.println("##############################");
        System.out.println("Listando todos os Livros:");
        List<Livro> livrosAmbos = livraria.listarAmbos();

        livrosAmbos.forEach(livroDaVez -> {
            String tipo = (livroDaVez instanceof Impresso) ? "Impresso" : "Eletrônico";
            System.out.println("""
        ==============================
        Tipo: %s
        ID: %d
        Título: %s
        Preço: R$ %.2f
        ==============================
        """.formatted(
                    tipo,
                    livroDaVez.getId_livro(),
                    livroDaVez.getTitulo(),
                    livroDaVez.getPreco()
            ));
            });

    }

    public void listarVendas() {
        System.out.println("##############################");
        System.out.println("Listando Todas as Vendas:");
        List<Venda> listaVenda = livraria.listarVendas();
        listaVenda.forEach(vendaDaVez -> {
            System.out.printf(
                    """
                            ==============================
                            ID: %s
                            Cliente: %s
                            Valor: R$ %.2f
                            ==============================
                            %n""", vendaDaVez.getNumero(),
                    vendaDaVez.getClientes(),
                    vendaDaVez.getValor()
        );
            });

    }

}
