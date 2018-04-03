--Você deverá implementar uma função isEanOk :: String -> Bool, que verifique se uma dada string representa um número EAN-13 com dígito verificador válido.

import Data.Char

trans :: String->[Int] 
trans "" = []
trans str = digitToInt(head str) : trans(tail str)

ult :: [Int] -> Int
ult ls = head(reverse ls)

soma :: [Int]->Int
soma ls = sum $ zipWith(*) ls [1,3,1,3,1,3,1,3,1,3,1,3]

isEanOk :: String->Bool
isEanOk str = if((10 - soma(trans(str)) `mod` 10) == ult(trans(str))) then True else False


