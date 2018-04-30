OBI 2016 Modalidade Inicialização, Nivel 1, Fase 1

triangulo(X, P) :- 
    X=<0,
    P is 0.

triangulo(X, P) :-
    P is (3 + 2*(X-1)).

/*
Questão 1. Quantos palitos são necessários para construir o diagrama de número 5?
Solução
Aplicando a equação, o número de palitos é 2 × 5 + 1 = 11. Se você não tivesse conseguido chegar
à equação, poderia ter respondido a esta questão desenhando o diagrama de número 5 e contando
manualmente o número de palitos.
(A) 9
(B) 11 -> correta
(C) 13
(D) 15
(E) 18

consultas:
?- triangulo(5, P).
P = 11.

*/