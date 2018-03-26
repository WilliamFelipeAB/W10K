geraTabela :: Int -> [(Int,Int)]
geraTabela 0 = []
geraTabela x = (x,x*x):(geraTabela(x-1))

cont :: Char -> String -> Bool
cont c [] = False
cont c (x:xs) = if (c==x) then True else cont c xs  

translate :: [(Float, Float)] -> [(Float, Float)]
transalate [] = []
translate (x:xs) = (fst x+2.0, snd x+2.0) : translate xs

geraTabela'1 :: Int -> [(Int,Int)]
geraTabela'1 0 = []
geraTabela'1 x = reverse (geraTabela x)

auxiliar :: Int -> Int -> [(Int,Int)]
auxiliar n x = if (x>n) then [] else (x, x^2) : auxiliar n (x+1)

geraTabela' :: Int -> [(Int,Int)]
geraTabela' n = if (n<1) then [] else auxiliar n 1
