-- single turn for user
turn :: Int -> Int -> Int -> IO ()
turn number_to_guess guess turns =
  do 
    putStrLn ("You have " ++ (show turns) ++ " turns to guess the number... Let's play!!!")
    do if turns==0
        then putStrLn "You lose"
        else if number_to_guess==guess
            then putStrLn "You win!"
            else mkguess number_to_guess guess turns

-- user inputs a single char (first on the line)
mkguess :: Int -> Int -> Int -> IO ()
mkguess number_to_guess guess turns =
    do  putStrLn "Making a guess"
        putStr "  Enter your guess: "
        guess' <- getLine
        let turns' = turns - 1
        turn number_to_guess (read guess' :: Int) turns'

-- top-level function. Usage: starman "WORD" NUM_TURNS
guess_number :: Int -> Int -> IO ()
guess_number number_to_guess turns = turn number_to_guess 999 turns