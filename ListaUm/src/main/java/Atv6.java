public class Atv6 {
    public static void main(String[] args) {
        int ProdutoInt = 1;
        float ProdutoFloat = 1f;

        for (int i = 15; i <= 30 ; i++) {
            if (i % 2 != 0) {
                ProdutoInt *= i;
                ProdutoFloat *= i;
            }
        }

        System.out.println("Produto dos números ímpares (Int): " + ProdutoInt);
        System.out.println("Produto dos números ímpares (Float): " + ProdutoFloat);
    }
}
