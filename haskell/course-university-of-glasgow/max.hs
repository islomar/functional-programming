-- find the max value in an Int list
-- maxhelper 42 []          >> 42
-- maxhelper (-1) [1,2,3]   >> 3

maxhelper :: Int -> [Int] -> Int
maxhelper x [] = x
maxhelper x (y:ys) = maxhelper
    (if x>y then x else y) ys

maxfromlist :: [Int] -> Maybe Int
maxfromlist [] = Nothing
maxfromlist (x:xs) = Just (maxhelper x xs)