package Exercicio1;

public class Administrador extends Empregado{
        private double ajudaDeCusto;

        public Administrador(){}

        public Administrador(double ajudaDeCusto){
            this.ajudaDeCusto = ajudaDeCusto;
        }

        public double getAjudaDeCusto() {return ajudaDeCusto;}

        public void setAjudaDeCusto(double ajudaDeCusto) {this.ajudaDeCusto = ajudaDeCusto;}

        @Override
        public double calcularSalario() {
            return super.calcularSalario() + ajudaDeCusto;
        }
    }
