triangulo(X, P) :- 
    X=<0,
    P is 0.

triangulo(X, P) :-
    P is (3 + 2*(X-1)).

/*
Questão 2. Quantos palitos são necessários para
contruir o diagrama de número 60?
(A) 90
(B) 111
(C) 121 -> resposta correta
(D) 163
(E) 180

consulta:
?- triangulo(60,P).
*/