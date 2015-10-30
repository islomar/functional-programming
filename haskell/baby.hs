doubleMe x = x + x

doubleUs x y = doubleMe x + doubleMe y

doubleSmallNumber x = if x > 100  
                        then x  
                        else x*2  

doubleSmallNumber' x = (if x > 100 then x else x*2) + 1 

conanO'Brien = "It's a-me, Conan O'Brien!"


-- Lists

boomBangs xs = [ if x < 10 then "BOOM!" else "BANG!" | x <- xs, odd x]

removeNonUppercase st = [ c | c <- st, c `elem` ['A'..'Z']] 


-- List comprehensions
length' xs = sum [1 | _ <- xs]



-- PATTERN MATCHING --
lucky :: (Integral a) => a -> String  
lucky 7 = "LUCKY NUMBER SEVEN!"  
lucky x = "Sorry, you're out of luck, pal!" 

sayMe :: (Integral a) => a -> String  
sayMe 1 = "One!"  
sayMe 2 = "Two!"  
sayMe 3 = "Three!"  
sayMe 4 = "Four!"  
sayMe 5 = "Five!"  
sayMe x = "Not between 1 and 5"

factorial :: (Integral a) => a -> a  
factorial 0 = 1  
factorial n = n * factorial (n - 1) 

--Pattern matching can also be used on tuples. 
addVectors :: (Num a) => (a, a) -> (a, a) -> (a, a)  
addVectors (x1, y1) (x2, y2) = (x1 + x2, y1 + y2)

--Our own implementation of the head function using pattern matching.
head' :: [a] -> a  
head' [] = error "Can't call head on an empty list, dummy!"  
head' (x:_) = x

tell :: (Show a) => [a] -> String  
tell [] = "The list is empty"  
tell (x:[]) = "The list has one element: " ++ show x  
tell (x:y:[]) = "The list has two elements: " ++ show x ++ " and " ++ show y  
tell (x:y:_) = "This list is long. The first two elements are: " ++ show x ++ " and " ++ show y 

length2' :: (Num b) => [a] -> b  
length2' [] = 0  
length2' (_:xs) = 1 + length' xs

sum' :: (Num a) => [a] -> a  
sum' [] = 0  
sum' (x:xs) = x + sum' xs

-- Using patterns with @
capital :: String -> String  
capital "" = "Empty string, whoops!"  
capital all@(x:xs) = "The first letter of " ++ all ++ " is " ++ [x]

-- GUARDS --
bmiTell :: (RealFloat a) => a -> a -> String  
bmiTell weight height  
    | bmi <= skinny = "You're underweight, you emo, you!"  
    | bmi <= normal = "You're supposedly normal. Pffft, I bet you're ugly!"  
    | bmi <= fat    = "You're fat! Lose some weight, fatty!"  
    | otherwise     = "You're a whale, congratulations!"  
    where bmi = weight / height ^ 2  
          skinny = 18.5  
          normal = 25.0  
          fat = 30.0
--ghci> bmiTell 85 1.90  
--Using bindings to pattern match:
--where bmi = weight / height ^ 2  
--      (skinny, normal, fat) = (18.5, 25.0, 30.0) 

---Guards can also be written inline, but it's less readable
max' :: (Ord a) => a -> a -> a  
max' a b | a > b = a | otherwise = b 


myCompare :: (Ord a) => a -> a -> Ordering  
a `myCompare` b  
    | a > b     = GT  
    | a == b    = EQ  
    | otherwise = LT
-- ghci> 3 `myCompare` 2


-- WHERE!? --

initials :: String -> String -> String  
initials firstname lastname = [f] ++ ". " ++ [l] ++ "."  
    where (f:_) = firstname  
          (l:_) = lastname  

-- Just like we've defined constants in where blocks, you can also define functions.
calcBmis :: (RealFloat a) => [(a, a)] -> [a]  
calcBmis xs = [bmi w h | (w, h) <- xs]  
    where bmi weight height = weight / height ^ 2      


-- LET IT BE --
--The names that you define in the let part are accessible to the expression after the in part.
cylinder :: (RealFloat a) => a -> a -> a  
cylinder r h = 
    let sideArea = 2 * pi * r * h  
        topArea = pi * r ^2  
    in  sideArea + 2 * topArea

--You can also put let bindings inside list comprehensions.
--The names defined in a let inside a list comprehension are visible to the output function (the part before the |) and all predicates and sections that come after of the binding. So we could make our function return only the BMIs of fat people:
calcBmis2 :: (RealFloat a) => [(a, a)] -> [a]  
calcBmis2 xs = [bmi | (w, h) <- xs, let bmi = w / h ^ 2, bmi >= 25.0]  


-- CASE EXPRESSIONS --
-- Pattern matching on parameters in function definitions

head2' :: [a] -> a  
head2' xs = case xs of [] -> error "No head for empty lists!"  
                       (x:_) -> x 

--Whereas pattern matching on function parameters can only be done when defining functions, case expressions can be used pretty much anywhere
describeList :: [a] -> String  
describeList xs = "The list is " ++ case xs of [] -> "empty."  
                                               [x] -> "a singleton list."   
                                               xs -> "a longer list." 
-- They are useful for pattern matching against something in the middle of an expression. 
-- Because pattern matching in function definitions is syntactic sugar for case expressions, we could have also defined this like so:
describeList2 :: [a] -> String  
describeList2 xs = "The list is " ++ what xs  
    where what [] = "empty."  
          what [x] = "a singleton list."  
          what xs = "a longer list."