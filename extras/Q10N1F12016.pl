traves(P, T) :-
	T is 3 * (P-1).
custo(P, T, Pr) :- 
	Prp is P * 10.00,
	Prt is T * 5.00,
	Pr is Prp + Prt.
/*
Questão 10. Cada poste custa R$ 10,00 e cada trave custa R$ 5,00. Qual o custo de uma cerca com
oito postes?
(A) R$ 80,00
(B) R$ 105,00
(C) R$ 120,00
(D) R$ 205,00
(E) R$ 215,00
Esta questao nao possui alternativa correta:resposta = R$185,00

consulta:
?- traves(8,T), custo(8,T,Pr).
*/