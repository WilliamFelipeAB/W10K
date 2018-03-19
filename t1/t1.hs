--1.Crie uma função isVowel :: Char -> Bool que verifique se um caracter é uma vogal ou não

import Data.Char 

isVowel :: Char -> Bool
isVowel x = elem (toLower(x)) ['a','e','i','o','u']

--2.Escreva uma função addComma, que adicione uma vírgula no final de cada string contida numa lista.

addComma :: [String] -> [String]
addComma ls = map(\l -> l ++ ",") ls

--3.Crie uma função htmlListItems :: [String] -> [String], que receba uma lista de strings e retorne outra lista contendo as strings formatadas como itens de lista em HTML. Resolva este exercício COM e SEM funções anônimas (lambda). Exemplo de uso da função:

--Lambda
htmlListItems1 :: [String] -> [String]
htmlListItems1 ls = map (\l -> "<LI>" ++ l ++ "</LI>")ls

--SemLambda
htmlListItems2 :: String -> String
htmlListItems2 str = "<LI>" ++ str ++ "</LI>"

htmlListItems22 :: [String] -> [String]
htmlListItems22 ls = map htmlListItems2 ls 

--4.Defina uma função que receba uma string e produza outra retirando as vogais, conforme os exemplos abaixo. Resolva este exercício COM e SEM funções anônimas (lambda).

--Lambda
remove1 :: String -> String
remove1 str = filter(\y -> isVowel(y) == False)str

--SemLambda
remove2 :: Char->Bool
remove2 c = isVowel(c) == False

remove22 :: String->String
remove22 str = filter remove2 str

--5.Defina uma função que receba uma string, possivelmente contendo espaços, e que retorne outra string substituindo os demais caracteres por '-', mas mantendo os espaços. Resolva este exercício COM e SEM funções anônimas (lambda). 

--Lambda
codifica :: String -> String
codifica str = map(\y->if(y /= ' ') then '-' else ' ')str  

--SemLambda

codifica2 :: Char->Char
codifica2 c 
 |c == ' ' = ' '
 |otherwise = '-'

codifica22 :: String->String
codifica22 str = map codifica2 str


--6.Escreva uma função firstName :: String -> String que, dado o nome completo de uma pessoa, obtenha seu primeiro nome. Suponha que cada parte do nome seja separada por um espaço e que não existam espaços no início ou fim do nome.


firstname :: String -> String 
firstname str = takeWhile(/= ' ')str

--7.Escreva uma função isInt :: String -> Bool que verifique se uma dada string só contém dígitos de 0 a 9.

isInt :: String -> Bool
isInt str = length (filter (\c->c < '0' || c  > '9') str) == 0

--8.Escreva uma função lastName :: String -> String que, dado o nome completo de uma pessoa, obtenha seu último sobrenome. Suponha que cada parte do nome seja separada por um espaço e que não existam espaços no início ou fim do nome.


lastName :: String -> String
lastName str = reverse (firstname (reverse str))

--9.Escreva uma função userName :: String -> String que, dado o nome completo de uma pessoa, crie um nome de usuário (login) da pessoa, formado por: primeira letra do nome seguida do sobrenome, tudo em minúsculas.

userName :: String -> String
userName str = map toLower ([head(firstname str)] ++ (lastName str)) 

--10.Escreva uma função encodeName :: String -> String que substitua vogais em uma string, conforme o esquema a seguir: a = 4, e = 3, i = 2, o = 1, u = 0.


cs :: Char->Char 
cs c 
 | c == 'a' = '4' 
 | c == 'e' = '3' 
 | c == 'i' = '2' 
 | c == 'o' = '1' 
 | c == 'u' = '0'

encodeName :: String -> String
encodeName str = map(\s->if(isVowel(s)) then (cs(s)) else s)str 

--11.Escreva uma função betterEncodeName :: String -> String que substitua vogais em uma string, conforme este esquema: a = 4, e = 3, i = 1, o = 0, u = 00.

--cs1 :: Char->String 
--cs1 c 
-- | c == 'a' = "4" 
-- | c == 'e' = "3" 
-- | c == 'i' = "1" 
-- | c == 'o' = "0" 
-- | c == 'u' = "00"

--betterEncodeName :: String -> String
--betterEncodeName str = map(\s->if(isVowel(s)) then (cs1 s) else s)str 

--12.Dada uma lista de strings, produzir outra lista com strings de 10 caracteres, usando o seguinte esquema: strings de entrada com mais de 10 caracteres são truncadas, strings com até 10 caracteres são completadas com '.' até ficarem com 10 caracteres.
