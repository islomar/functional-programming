-- single turn for user
turn :: Int -> IO ()
turn number =
  do putStrLn ("You want to guess the number " ++ (show number))

-- top-level function. Usage: starman "WORD" NUM_TURNS
guess_number :: Int -> IO ()
guess_number number = turn number