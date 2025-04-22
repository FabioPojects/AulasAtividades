package Exercicio1;

public class FornecedorTeste {
    public static void main(String[] args) {

        Pessoa pessoaFinal = new Pessoa();
        pessoaFinal.setNome("Lázaro Ramos");
        pessoaFinal.setEndereco("Avenida Paulista");
        pessoaFinal.setTelefone("14366289183");
        System.out.println("Informações da Pessoa");
        System.out.println("Nome: " + pessoaFinal.getNome());
        System.out.println("Endereço: " + pessoaFinal.getEndereco());
        System.out.println("Telefone: " + pessoaFinal.getTelefone());

        Fornecedor fornecedorFinal = new Fornecedor();
        fornecedorFinal.setValorCredito(10000);
        fornecedorFinal.setValorDivida(1000);
        System.out.println("Seu crédito é de R$" + fornecedorFinal.getValorCredito());
        System.out.println("Sua dívida é de R$" + fornecedorFinal.getValorDivida());
        System.out.println("Saldo Restante: R$" + fornecedorFinal.obterSaldo());

        Administrador administradorFinal = new Administrador();
        administradorFinal.setSalarioBase(5000);
        administradorFinal.setAjudaDeCusto(700);
        administradorFinal.setImposto(0.2);
        System.out.println("Você tem um salário base de: R$" + administradorFinal.getSalarioBase());
        System.out.println("Sua ajuda de custo é de: R$" + administradorFinal.getAjudaDeCusto());
        System.out.println("Impostos a pagar: " + administradorFinal.getImposto() + "%");
        System.out.println("Com isso, seu salário líquido é de: R$" + administradorFinal.calcularSalario());

        Operario operarioFinal = new Operario();
        operarioFinal.setValorProducao(200);
        operarioFinal.setComissao(0.5);
        System.out.println("Valor total da produção: R$" + operarioFinal.getValorProducao());
        System.out.println("A comissão recebida é equivalente a: R$" + operarioFinal.getComissao());

        Vendedor vendedorFinal = new Vendedor();
        vendedorFinal.setSalarioBase(3000);
        vendedorFinal.setValorVendas(15000);
        vendedorFinal.setComissao(10);
        vendedorFinal.setImposto(0.15);
        System.out.println("Você tem um salário base de: R$" + vendedorFinal.getSalarioBase());
        System.out.println("Total de vendas realizadas: R$" + vendedorFinal.getValorVendas());
        System.out.println("Porcentagem de comissão: " + vendedorFinal.getComissao() + "%");
        System.out.println("Impostos a pagar: " + vendedorFinal.getImposto() + "%");
        System.out.println("Com isso, seu salário líquido é de: R$" + vendedorFinal.calcularSalario());
    }
}