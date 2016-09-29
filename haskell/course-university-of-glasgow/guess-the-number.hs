-- single turn for user
turn :: Int -> Int -> IO ()
turn number turns =
  do 
    putStrLn ("You want to guess the number " ++ (show number))
    putStrLn ("You have " ++ (show turns) ++ " turns")

-- top-level function. Usage: starman "WORD" NUM_TURNS
guess_number :: Int -> Int -> IO ()
guess_number number turns = turn number turns