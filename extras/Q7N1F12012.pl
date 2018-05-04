cachorro(X) :- 
	X =:= (X - 4) + (X - 4) + (X - 4).

/*
Questão 7. Pedro comprou cachorros de presente para seus filhos. Apenas três raças estavam a
venda: pastor alemão, labrador e pequinês.
• Todos os cachorros comprados, exceto quatro, são da raça pastor alemão.
• Todos os cachorros comprados, exceto quatro, são da raça labrador.
• Todos os cachorros comprados, exceto quatro, são da raça pequinês.
Olimpíada Brasileira de Informática – OBI2012 4
Quantos cachorros Pedro comprou?
(A) 6 -> resposta correta
(B) 5
(C) 4
(D) 3
(E) 2

consulta:
?- cachorro(6).
?- cachorro(5).
?- cachorro(4).
?- cachorro(3).
?- cachorro(2).

*/