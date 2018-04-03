--1.Escreva uma função recursiva isBin :: String -> Bool para verificar se uma dada String representa um número binário, ou seja, contém apenas caracteres '0' ou '1'. As únicas funções pré-definidas autorizadas aqui são head e tail. 
isBin :: String -> Bool
isBin (x:xs) = if(x /= '0' && x /= '1')
then False else isBin xs
--2.Reescreva a função acima de forma não-recursiva. Dê outro nome para ela, por exemplo isBin'. Aqui você pode usar quaisquer funções auxiliares pré-definidas em Haskell.
isBin' :: String -> Bool
isBin' str = length ( filter(\x -> x == '1' || x == '0')str) == length str
--3.Encontra-se abaixo a definição parcial da função bin2dec :: [Int] -> Int, que converte uma lista de 0's e 1's (representando um número binário), em seu equivalente em decimal.
auxBin2Dec :: [Int]->Int->Int
auxBin2Dec [] e = 0
auxBin2Dec (x:xs) e = x*(2^e) + auxBin2Dec xs (e-1) 

bin2dec :: [Int] -> Int
bin2dec [] = undefined
bin2dec bits = auxBin2Dec bits ((length bits)-1)
--4.Reescreva a função do exercício anterior de forma não-recursiva, usando funções pré-definidas em Haskell. Dê outro nome para a função (por exemplo, bin2dec').
bin2dec' :: [Int] -> Int
bin2dec' [] = undefined
bin2dec' bits = sum (zipWith (*) bits (map (\x -> 2 ^ x) [(length bits)-1, (length bits)-2..0]))
--5.Crie uma função recursiva dec2bin :: Int -> [Int] que receba um número inteiro positivo e retorne sua representação em binário, sob forma de uma lista de 0's e 1's. As funções auxiliares autorizadas aqui são mod, div e reverse. Exemplos de uso da função:
aux2bin :: Int -> [Int]
aux2bin 0 = [0]
aux2bin x = (x `mod` 2):aux2bin (x `div` 2)

dec2bin :: Int -> [Int]
dec2bin x = reverse (aux2bin x)

--6.Implemente uma dessas funções: isHex :: String -> Bool ou hex2dec :: String -> Int ou dec2hex :: Int -> String, que são semelhantes às dos exercícios anteriores, porém com números hexadecimais no lugar de números binários. Aqui está tudo liberado: você pode escolher qual das funções irá implementar, sem restrições sobre como deve fazer isso.
isHex :: String -> Bool
isHex str = if(length(filter (\x ->elem x "0123456789abcdefABCDEF")str) == length(filter(\y -> y /= ' ')str)) then True else False



