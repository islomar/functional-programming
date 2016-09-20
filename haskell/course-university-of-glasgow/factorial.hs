-- simple factorial definition

fact2 :: Int -> Int
fact2 0 = 1
fact2 n = n*fact2(n-1)