%1.Defina um predicado zeroInit(L) que é verdadeiro se L for uma lista que inicia com o número 0 (zero).

zeroInit(L):-
L = [H|_],
H=:=0. 

%2.Defina um predicado has5(L) que é verdadeiro se L for uma lista de 5 elementos. Resolva este exercício sem usar um predicado auxiliar.

has5(L) :-  L = [_,_,_,_,_].

%3.Defina um predicado hasN(L,N) que é verdadeiro se L for uma lista de N elementos.

hasN(L,N) :- length(L, N).

%4.Defina um predicado potN0(N,L), de forma que L seja uma lista de potências de 2, com expoentes de N a 0.

potN0(0,[]).
potN0(N,L) :- 
N>=0,
L = [H|T],
H is 2^N, 
X is N-1,
potN0(X,T).

%5.Defina um predicado zipmult(L1,L2,L3), de forma que cada elemento da lista L3 seja o produto dos elementos de L1 e L2 na mesma posição do elemento de L3.

zipmult([],[],[]).
zipmult(L1,L2,L3) :- 
L1 = [H1|T1],
L2 = [H2|T2],
L3 = [H3|T3],
H3 is H1*H2, 
zipmult(T1,T2,T3).

%6.Defina um predicado potencias(N,L), de forma que L seja uma lista com as N primeiras potências de 2, sendo a primeira 2^0 e assim por diante.
potencias(N,L) :- potencias_aux(0,N,L).

potencias_aux(N, N, []).
potencias_aux(X, N, L) :- 
X=<N,
L = [H|T],
H is 2^X,
Y is X+1,
potencias_aux(Y, N, T).

%7.Defina um predicado positivos(L1,L2), de forma que L2 seja uma lista só com os elementos positivos de L1.

positivos([],[]).
positivos(L1,L2) :-
L1 = [H1|T1],
L2 = [H2|T2],
(H1>0 -> H2 is H1, X = T2;X = L2),
positivos(T1, X).

%8.Considere que L1 e L2 sejam permutações de uma lista de elementos distintos, sem repetições. Sabendo disso, defina um predicado mesmaPosicao(A,L1,L2) para verificar se um elemento A está na mesma posição nas listas L1 e L2.

mesmaPosicao(A, [A|_], [A|T]).
mesmaPosicao(A,L1,L2) :- 
L1 = [H1|T1],
L2 = [H2|T2],
mesmaPosicao(A, T1, T2).


%9.Dada uma lista de N alunos, deseja-se escolher NP alunos (NP < N) para formar uma comissão. Para isso, defina um predicado comissao(NP,LP,C), que permita gerar as possíveis combinações C com NP elementos da lista LP.
comissao(0, _, []).

comissao(NP,LP,C) :- 
NP > 0,
LP = [H1|T1],
C = [H1|T2],
NP1 is NP - 1,
comissao(NP1, T1, T2).

comissao(NP, [_|T1], T2) :-
NP > 0,
comissao(NP, T1, T2).


%10.(Adaptado de OBI2006-F1N1) Tem-se N azulejos 10cm x 10cm e, com eles, deve-se montar um conjunto de quadrados de modo a utilizar todos os azulejos dados, sem sobrepô-los. Inicialmente, deve-se montar o maior quadrado possível; então, com os azulejos que sobraram, deve-se montar o maior quadrado possível, e assim sucessivamente. Por exemplo, se forem dados 31 azulejos, o conjunto montado terá 4 quadrados. Para resolver este problema, você deverá definir um predicado azulejos(NA, NQ), de forma que NQ seja o número de quadrados que se deve montar com NA azulejos.

azulejos(NA, NQ) :- 
azulejos_aux(NA, L),
length(L, NQ).


azulejos_aux(0,[]).
azulejos_aux(A, [H|T]) :-
A>0,
sqrt(A, X),
floor(X, Y),
A1 is A - (Y*Y),
azulejos_aux(A1, T).




