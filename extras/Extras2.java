import java.util.Scanner;

public class Extras2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Entre com o numero do diagrama:");
        int X = s.nextInt();
        int P = 3 + 2*(X-1);
        System.out.println("A quantidade de palitos necessarias para construir o diagrama de numero " + X + " é: " + P);
    }
}

/*
Questão 2. Quantos palitos são necessários para
contruir o diagrama de número 60?
(A) 90
(B) 111
(C) 121 -> resposta correta
(D) 163
(E) 180
*/