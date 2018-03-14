-- Crie uma função isVowel :: Char -> Bool que verifique se um caracter é uma vogal ou não

import Data.Char 

isVowel :: Char -> Bool
isVowel x = elem (toLower(x)) ['a','e','i','o','u']

--Escreva uma função addComma, que adicione uma vírgula no final de cada string contida numa lista.

addComma :: [String] -> [String]
addComma ls = map(\l -> l ++ ",") ls

--Crie uma função htmlListItems :: [String] -> [String], que receba uma lista de strings e retorne outra lista contendo as strings formatadas como itens de lista em HTML. Resolva este exercício COM e SEM funções anônimas (lambda). Exemplo de uso da função:

htmlListItems :: [String] -> [String]
htmlListItems ls = map (\l -> "<LI>" ++ l ++ "</LI>")ls

--Defina uma função que receba uma string e produza outra retirando as vogais, conforme os exemplos abaixo. Resolva este exercício COM e SEM funções anônimas (lambda).

--com lambda
remove1 :: String -> String
remove1 str = filter(\y -> isVowel(y) == False)str

--sem lambda


--Defina uma função que receba uma string, possivelmente contendo espaços, e que retorne outra string substituindo os demais caracteres por '-', mas mantendo os espaços. Resolva este exercício COM e SEM funções anônimas (lambda). 

codifica :: String -> String
codifica str = map(\y->if(y /= ' ') then '-' else ' ')str  

--Escreva uma função lastName :: String -> String que, dado o nome completo de uma pessoa, obtenha seu último sobrenome. Suponha que cada parte do nome seja separada por um espaço e que não existam espaços no início ou fim do nome. Exemplos de uso da função:

prim :: String -> String 
prim str = takeWhile(/= ' ')str