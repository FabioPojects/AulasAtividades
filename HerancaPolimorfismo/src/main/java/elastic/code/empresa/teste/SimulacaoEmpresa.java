package elastic.code.empresa.teste;

import elastic.code.empresa.cargos.Gerente;
import elastic.code.empresa.cargos.Supervisor;
import elastic.code.empresa.cargos.Vendedor;
import elastic.code.empresa.Funcionario;
import elastic.code.empresa.tipoEnsino.FuncionarioEnsinoBasico;
import elastic.code.empresa.tipoEnsino.FuncionarioEnsinoMedio;
import elastic.code.empresa.tipoEnsino.FuncionarioGraduado;

public class SimulacaoEmpresa {
    public static void main(String[] args) {

        Funcionario[] funcionarios = new Funcionario[13];

        funcionarios[0] = new Gerente("Fabio", 5493, 5000.00);

        funcionarios[1] = new Supervisor("Fernando", 4589, 4000.00);
        funcionarios[2] = new Supervisor("Luzia", 4594, 3000.00);

        funcionarios[3] = new Gerente("Fabio", 5493, 5000.00);
        funcionarios[4] = new Supervisor("Pedro",3562, 3300.00);
        funcionarios[5] = new Supervisor("Mônica", 4903, 3100.00);
        funcionarios[6] = new Vendedor("Kendi", 3213, 8100.00);
        funcionarios[7] = new Vendedor("Matheus", 4567,3300.00);
        funcionarios[8] = new Vendedor("Davi", 1212, 2300.00);
        funcionarios[9] = new Vendedor("Lazaro", 9038,2100.00);

        System.out.println("Funcionários da Empresa: ");
        for (Funcionario funcionario : funcionarios) {
            System.out.println(funcionario.toString());
        }


        double custoTotal = 0.0;
        double custoGerente = 0.0;
        double custoSupervisor = 0.0;
        double custoVendedor = 0.0;
        double custoEnsinoBasico = 0.0;
        double custoEnsinoMedio = 0.0;
        double custoNivelSuperior = 0.0;

        for (Funcionario funcionario : funcionarios) {
            custoTotal += funcionario.getRendaTotal();

            if (funcionario instanceof Gerente) {
                custoGerente += funcionario.getRendaTotal();
            } else if (funcionario instanceof Supervisor) {
                custoSupervisor += funcionario.getRendaTotal();
            } else if (funcionario instanceof Vendedor) {
                custoVendedor += funcionario.getRendaTotal();
            } else if (funcionario instanceof FuncionarioEnsinoBasico) {
                custoEnsinoBasico += funcionario.getRendaTotal();
            } else if (funcionario instanceof FuncionarioEnsinoMedio) {
                custoEnsinoMedio += funcionario.getRendaTotal();
            } else if (funcionario instanceof FuncionarioGraduado) {
                custoNivelSuperior += funcionario.getRendaTotal();
            }
        }

        System.out.println("Custo Total com Salários: R$ " + custoTotal);
        System.out.println("Custo com Gerente: R$ " + custoGerente);
        System.out.println("Custo com Supervisor: R$ " + custoSupervisor);
        System.out.println("Custo com Vendedor: R$ " + custoVendedor);
        System.out.println("Custo com Funcionários de Ensino Básico: R$ " + custoEnsinoBasico);
        System.out.println("Custo com Funcionários de Ensino Médio: R$ " + custoEnsinoMedio);
        System.out.println("Custo com Funcionários de Ensino Superior: R$ " + custoNivelSuperior);
    }
}