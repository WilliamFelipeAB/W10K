import java.util.Scanner;

public class Extras3 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Entre com o numero do diagrama:");
        int D = s.nextInt();
        int Q = 4*D-3;
        System.out.println("A quantidade de qudrados que há no diagrama " + D + " é: " + Q);
    }
}

/*
Questão 2. Quantos quadrados há no diagrama de número 25?

(A) 71
(B) 75
(C) 79
(D) 97 -> resposta correta
(E) 100
*/