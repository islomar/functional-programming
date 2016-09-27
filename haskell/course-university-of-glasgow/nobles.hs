-- make people noble
-- From the ghci, run :l nobles.hs

mknoble :: Bool -> String -> String
mknoble female name = (if female then "Dame " else "Sir ") 
                        ++ name