import java.util.Scanner;

public class Extras4 {
    public static void main(String[] args) {
        int Q = 42;
        int D = (int)Math.floor((Q-4)/12) + 1;
        System.out.println("O numero do maior quadrado que pode ser construido com" + Q + " palitos é: " + D);
    }
}

/*
Questão 3. Qual o número do maior diagrama que é possível construir com uma caixa de palitos de fósforo que contém 42 palitos?

(A) 3
(B) 4  -> resposta correta
(C) 5
(D) 6
(E) 7
*/