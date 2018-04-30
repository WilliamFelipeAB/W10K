regra1(CD) :- 
nth0(3, CD, s).

regra2(CD) :-
nth0(Iw, CD, w),
nth0(It, CD, y),
Iw < 3,
It < 3.

regra3(CD) :- 
nth0(Iw, CD, w),
nth0(It, CD, t),
It < Iw.

regra4(CD, X) :-
nth1(6,CD,X).

regra6(CD) :- regra4(CD, z).

perm(List, [H|Perm]) :- delete(H, List, Rest), perm(Rest, Perm).
perm([],[]).

delete(H, [H|T], T).
delete(H, [H1|T], [H1|NT]) :- delete(H, T, NT).

cdIndependente(CD) :-
CD = [_,_,_,_,_,_,_],
Musicas = [s,t,v,w,x,y,z],
perm(Musicas, CD),
regra1(CD),
regra2(CD), 
regra3(CD), 
regra6(CD).

/*
 Questão 11. Qual das seguintes alternativas poderia
 ser a ordem das músicas no CD, da primeira
 para a sétima faixa?

 (A) T, W, V, S, Y, X, Z
 (B) V, Y, T, S, W, Z, X
 (C) X, Y, W, S, T, Z, S
 (D) Y, T, W, S, X, Z, V
 (E) Z, T, X, W, V, Y, S

 Consultas:

 ?- cdIndependente([t,w,v,s,y,x,z]).
 ?- cdIndependente([v,y,t,s,w,z,x]).
 ?- cdIndependente([x,y,w,s,t,z,s]).
 ?- cdIndependente([y,t,w,s,x,z,v]).->correta
 ?- cdIndependente([z,t,x,w,v,y,s]).
*/