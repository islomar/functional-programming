-- simple factorial definition

fact2 :: Int -> Int
fact2 n = if n == 0 then 1 else n*fact2(n-1)