-- starman.hs
-- Jeremy Singer
-- based on a Functional Programming
-- exercise from Glasgow,
-- (inherited from John O'Donnell)
-- https://www.futurelearn.com/courses/functional-programming-haskell/1/steps/116475
-- https://github.com/wimvanderbauwhede/HaskellMOOC/blob/master/Starman/starman.hs


-- check whether a single char is in the mystery word
check :: String -> String -> Char -> (Bool,String)
check word display c
  = (c `elem` word, [if x==c
          then c
          else y | (x,y) <- zip word display])

-- single turn for user
turn :: String -> String -> Int -> IO ()
turn word display n =
  do if n==0
       then putStrLn "You lose"
       else if word==display
              then putStrLn "You win!"
              else mkguess word display n

-- user inputs a single char (first on the line)
mkguess :: String -> String -> Int -> IO ()
mkguess word display n =
  do putStrLn (display ++ "  " ++ take n (repeat '*'))
     putStr "  Enter your guess: "
     q <- getLine
     let (correct, display') = check word display (q!!0)
     let n' = if correct then n else n-1
     turn word display' n'

-- notice how turn and mkguess have the same signatures,
-- and are mutually recursive. Is this elegant?

-- top-level function. Usage: starman "WORD" NUM_TURNS
starman :: String -> Int -> IO ()
starman word n = turn word ['-' | x <- word] n