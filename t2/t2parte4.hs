import Data.Char

-- Converte um caracter em um inteiro
encodeChar :: Char -> Int
encodeChar c = ord c - ord 'a'

-- Converte um inteiro em um caracter
decodeChar :: Int -> Char
decodeChar n = chr (ord 'a' + n)

-- Calcula percentagem: n/m*100
percent :: Int -> Int -> Float
percent n m = (fromIntegral n / fromIntegral m)*100

-- Rotacao de uma lista para esquerda em n posicoes
rotate :: Int -> [a] -> [a]
rotate n xs = drop n xs ++ take n xs

-- Tabela de frequencias das letras 'a'..'z' (lingua portuguesa)
-- https://pt.wikipedia.org/wiki/Frequ%C3%AAncia_de_letras
table :: [Float]
table = [14.6, 1.0, 3.9, 5.0, 12.6, 1.0, 1.3, 1.3, 6.2, 0.4, 0.1, 2.8, 4.7, 
         5.0, 10.7, 2.5, 1.2, 6.5, 7.8, 4.3, 4.6, 1.7, 0.1, 0.2, 0.1, 0.5]

-- Distancia entre 2 listas de frequencia
chi2 :: [Float] -> [Float] -> Float
chi2 os es = sum [((o-e)^2)/e | (o,e) <- zip os es]

-- Use esta funcao para decodificar uma mensagem!
crack :: String -> String
crack cs = encodeStr cs (-factor)
           where factor = head (positions (minimum chitab) chitab)
                 chitab = [ chi2 (rotate n table' ) table | n <- [0..25] ]
                 table' = freqs cs

-- Usando encodeChar e decodeChar, defina uma função shiftChar :: Char -> Int -> Char. Essa função, ao receber um caracter de 'a' a 'z', aplicará um deslocamento de 'n' unidades sobre ele, produzindo outro caracter no intervalo ['a'..'z'].
shiftChar :: Char -> Int -> Char
shiftChar carac r = if(elem carac ['a'..'z']) then decodeChar((r + encodeChar carac) `mod` 26) else carac 

-- Usando shiftChar, defina uma função encodeStr :: String -> Int -> String que codifique uma string usando um dado deslocamento.
encodeStr :: String -> Int -> String
encodeStr str r = map(\x->shiftChar x r)str

-- Defina uma função countValids :: String -> Int, que receba uma string e retorne a quantidade de seus caracteres contidos no intervalo ['a'..'z']
countValids :: String -> Int
countValids str = length(filter(\x->elem x ['a'..'z'])str)

-- Defina uma função countChar :: Char -> String -> Int, que retorne a quantidade de um dado caracter em uma string. 
countChar :: Char -> String -> Int
countChar carac str = length(filter(==carac)str)

-- Usando countValids, countChar e percent, defina uma função freqs :: String -> [Float] que retorne as frequências dos caracteres ['a'..'z'] numa dada string. Use list comprehension. A frequência de um caracter é dada pelo percentual deste caracter entre os caracteres válidos da string.
freqs :: String -> [Float]
freqs str = map(\x->(percent (countChar x str) (countValids str)))['a'..'z']

-- Defina uma função positions :: Float -> [Float] -> [Int], que retorne uma lista de posições de um dado número em uma lista. Considere que as posições comecem em zero. Use a função zip como auxiliar no seu código.
positions :: Float -> [Float] -> [Int]
positions n ls = map(\y-> fst y)(filter(\x-> snd x == n)(zip [0,1..length ls]ls))