#Course "Functional programming in Haskell" - University of Glasgow

##Interesting links
https://www.futurelearn.com/courses/functional-programming-haskell/1/welcome
https://www.futurelearn.com/learning-guide
https://about.futurelearn.com/blog/6-social-learning-tips/
https://github.com/hemanth/functional-programming-jargon
https://es.wikipedia.org/wiki/Haskell
https://en.wikipedia.org/wiki/Glasgow_Haskell_Compiler

##MOOC source code
https://github.com/wimvanderbauwhede/HaskellMOOC

##HGCi installation
https://www.haskell.org/downloads
https://www.futurelearn.com/courses/functional-programming-haskell/1/steps/104770

##Online IDE
https://www.haskellmooc.co.uk/
http://tryhaskell.org/
https://www.haskellmooc.co.uk/#step14
https://www.haskellmooc.co.uk/tutorial11/#step25

##Haskell in Docker
https://hub.docker.com/_/haskell/
`docker run -it --rm haskell:7.10.3`
`docker run -it --rm haskell:8.0.1`

##Haskel history
https://www.youtube.com/watch?v=3bjXGrycMhQ
https://wiki.haskell.org/History_of_Haskell


##Week 1
Expressions are really all there is, there are no statements. An expression evaluates to a result
Functions:
`hello name = "Hello, "++name`

Haskell has much more powerful types than C >> type declaration and function definitions are separate.
* In an imperative language like C or Java,
  * there are expressions that denote small scale computations (2*x), and
  * statements that handle sequencing, looping, conditionals, and all the large scale operation of the program.
* Pure functional programming languages don’t have any statements — no assignments, no jumps.
* Instead, all computation is performed by evaluating expressions

https://www.haskell.org/onlinereport/exps.html

* Equations are used to give names to values.
`answer = 42`

- An equation in Haskell is a mathematical equation: it says that the left hand side and the right hand side denote the same value.

- The left hand side should be a name that you’re giving a value to.
  - Correct: x = 5*y
  - Incorrect: 2 * x = (3*x)**2 – Reassignment is not allowed in a pure FPL

**Equations are not assignments**
There are no equations in imperative languages like C and Java.
- In Haskell, it is valid to write n = n + 1.
    - This is an equation, not an assignment!

* It means: compute the value of n that has the property that n = n + 1.
* In a pure functional language, we never destroy old values.
* So in general it is best to enclose negative numbers with parentheses in expressions
* Function application binds tighter than anything else.

###Introduction to Expressions and Equations
https://www.futurelearn.com/courses/functional-programming-haskell/1/steps/71170

###Summary
* Expressions in Haskell are similar to those in other languages.
* There are only expressions in Haskell, i.e. no statements.
* Things that look like assignments are not updates of values but equations

###More Basic Elements by Example
https://www.futurelearn.com/courses/functional-programming-haskell/1/steps/110660
* Lambda functions
`f = \x y -> x*x + y*y`

* Block structures
`<functionName> <parameters> = let <expressions> in <return_code>`
Note that the let ... in ... construct is an expression, so it returns a value. That’s why there is no need for a return keyword.

* Higher order functions (with a lambda function):
`map (\x -> 2*x) [1..10]`

###Reduction, Functions and Lists
https://www.futurelearn.com/courses/functional-programming-haskell/1/steps/71180

####Reduction
**A model of program execution**
* A programmer needs a concrete model for how a program is executed.
* For imperative programs, we can execute statement by statement, keeping track of the values of variables (the stack) and where we are in the program (the program counter).
* Functional programs don’t have statements!
* The mechanism for executing functional programs is reduction.

**Reduction**
Reduction is the process of converting an expression to a simpler form. Conceptually, an expression is reduced by simplifying one reducible expression (called “redex”) at a time. Each step is called a reduction, and we’ll use -- > to show the result.

**The result doesn’t depend on reduction path!**
A fundamental theorem (the Church-Rosser theorem):
* Every terminating reduction path gives the same result

This means that
* Correctness doesn’t depend on order of evaluation.
* The compiler (or programmer) can change the order freely to improve performance, without affecting the result.
* Different expressions can be evaluated in parallel, without affecting the result. As a result, functional languages are leading contenders for programming future parallel systems.

**Functions**
* Haskell is a functional language so the function concept is the essential to the language. A function takes one or more arguments and computes a result. Given the same arguments, the result will always be the same. This is similar to a mathematical function and it means that in Haskell there are no side-effects. There are two fundamental operations on functions: function definition (creating a function) and function application (using a function to compute a result).
* In Haskell, many functions are pre-defined in a standard library called the **prelude**.
* A function is defined by an equation.

**How function application works**
* A function definition is an equation, e.g. 𝚏=∖𝚡→𝚡+𝟷f=∖x→x+1
* The left hand side gives the name of the function;
*The right hand side (the “body”) is an expression giving the formal parameters, and the value of the application. The expression may use the parameters.
* An application is an expression like f 31, where 3131 is the argument.
* The application is evaluated by replacing it with the body of the function, where the formal parameters are replaced by the arguments.

**Function returning several results**
* Actually, a function can return only one result.
* However, lists allow you to package up several values into one object, which can be returned by a function.

**Elements are evaluated lazily**: The elements can be expressions. They are evaluated only when they are used.

**List comprehensions**
* A list comprehension is a high level notation for specifying the computation of a list
* The compiler automatically transforms a list comprehensions into an expression using a family of basic functions that operate on lists
* List comprehensions were inspired by the mathematical notation set comprehension.

The !!!! operator takes a list and an index, and returns the corresponding element.
`[5,3,8,7]  !! 2    -- > 8`

There are two ways to define a function:
* You can either define a named function, e.g.f x = x+1
* You can also define a function without a name, known as a "lambda function" (or "anonymous function" in other languages), for example `\x -> x+1`.
  * Or you can use an equation to assign the lambda function to a variable: `fl = \x -> x+1`.
* You can of course also define lambda functions with multiple arguments, e.g. `add3numsl = \x y z -> x + y + z`

**Constructing lists**
The (:) ("cons") operator takes a scalar and an existing lists, and returns a new list containing all the elements.
For example, `23 : [48, 41, 44]`

* There are standard library functions to give the head of a list (its first element) or the tail (all the rest of the list): head [4,5,6] returns 4.

Tutorial 1.2:
https://www.haskellmooc.co.uk/tutorial12/#step11
* Defining a function: a function defines an expression with variables
* Lambda functions: functions don't need a name
* The list datastructure: the key datastructure in Haskell
* Constructing lists: the (:) and (++) operators, sequences, comprehensions
* Manipulating lists: indexing, head and tail

**Recommended readings**
https://www.futurelearn.com/courses/functional-programming-haskell/1/steps/115884
* Online help
Other online sites also provide advice to Haskell beginners. For instance, the Haskell Cafe mailing list is a friendly place to post queries. There are also sub-reddits like haskellquestions.

**Design patterns in Haskell**
http://blog.ezyang.com/2010/05/design-patterns-in-haskel/

##GHCi
`:quit`     >>  quit HGCi
`:set +m`   >>  enable multiline
`:t <function_name` >> gets the type of a function
`putStrLn "hello"`

##Week 2
* Not-equals operator: Use the /= operator (it's supposed to look like an equals sign with a line through it), to test for inequality, e.g. `1 /= 2`
* We want a boolean function that returns true if a value is part of a list, and false otherwise. This is the elem function. Try `elem 1 [1,2,3]`
* The elem function can be written infix, like an arithmetic operator, by enclosing its name in backquotes ``. Try 3 `elem` [1, 2, 3, 4, 5].
* any Haskell infix operator, e.g. +, can be written as a prefix operator by enclosing it in parentheses, like (+) 1 1`

###Zip that list
The zip function is used to combine a pair of lists into a list of pairs. 
```
Prelude> zip [1, 2, 3] [4, 5, 6]
[(1,4),(2,5),(3,6)]
```
```
Prelude> zip3 "glasgow" "beijing" "nairobi"
[('g','b','n'),('l','e','a'),('a','i','i'),('s','j','r'),('g','i','o'),('o','n','b'),('w','g','i')]
```

The output is so long as the shortest list:
```
Prelude> zip [1..10] ['a'..'z']
[(1,'a'),(2,'b'),(3,'c'),(4,'d'),(5,'e'),(6,'f'),(7,'g'),(8,'h'),(9,'i'),(10,'j')]
```
You can pass the function to apply to the zip:
```
Prelude> zipWith max [1,2,3] [0,2,4]
[1,2,4]
```
Lambda expressions:
```
Prelude> zipWith (\x->(\y->(x,y))) [1,2,3] [0,2,4]
[(1,0),(2,2),(3,4)]
```

###Booleans
* Use the && infix operator as a boolean conjunction (AND function). This only evaluates to True when both its inputs are 
* Haskell also defines the **xor function**, which returns true when its two boolean arguments are different (one is True and the other is False)
```
λ map (\inputs -> xor (fst inputs) (snd inputs)) [(x,y) | x<-[False, True], y<-[False, True]]
[False,True,True,False]
```
`if 2*2==4 then "happy" else "sad"`

###Input/Output
* input (with getLine) and output (with putStrLn)
* you can sequence IO operations with the do construct:
`do { putStrLn "what is your name?"; x <- getLine; putStrLn ("hello " ++ x) }`
* `do { putStrLn "what is your name?"; n<-getLine; let nUpper = map toUpper n in putStrLn ("HELLO " ++ nUpper) }`
* Convert types:
```
λ read "42" :: Int
42
:: Int
```
* The **show** function is the dual of the read function. show takes a value and returns a String representation of that value. 
* In fact, there is a single function called print that does the composition of putStrLn and show .... try `print 42`.

Let's recap what we've discovered:
* getLine and putStrLn for console input/output
* using do to sequence IO actions
* <- for binding values to variables with IO
* show and read for converting from and to String values

####Sequencing actions
Input and output (I/O) operations are impure. They influence and interact with the ‘outside world’. 

Order of function evaluation doesn’t matter in pure code
However this is not the case where I/O is concerned. Sequencing is vital for I/O actions.

`do { planet <- getLine; home <- getLine; putStrLn ("greetings " ++ planet ++ "ling."); putStrLn ("I am from " ++ home ++ "."); putStrLn "Take me to your leader."}`
`let a= reverse "winston"; b = reverse "churchill"  in "sir " ++a ++" "++ b`
One more thing to notice: inside the do, we associate results of IO functions with names using <-. Inside the let, we associate pure function results with names using =.

####Monads are Hiding Below
The do notation allows us to sequence actions. This looks just like a sequence of commands in an imperative programming language. However, do is only syntactic sugar. Underneath, it is rewritten as a chain of function calls where the output of the first function becomes the input of the second function.

Monads are a powerful tool for sequencing operations.

For now, all we need to understand is:
* I/O operations are impure
* use do to specify a sequence of actions
* use <- inside a do to associate input values with names
* any value or function that involves I/O has IO in its type
* a sequence of I/O actions is described as being **in the IO Monad**

##Challenges
* Guess the number
* Mastermind


##Week 3: list data structure
###Recursion on Lists
https://www.futurelearn.com/courses/functional-programming-haskell/1/steps/96238
Every list must be either
* [] or
* (x:xs) for some x (the head of the list) and xs (the tail).
, where (x:xs) is an alternative syntax for x cons xs

The recursive definition follows the structure of the data:
* Base case of the recursion is [][].
* Recursion (or induction) case is (x:xs)(x:xs).

**filter** is given a predicate (a function that gives a Boolean result) and a list, and returns a list of the elements that satisfy the predicate.
`filter :: (a->Bool) -> [a] -> [a]`
Filtering is useful for the “generate and test” programming paradigm.
`filter (<5) [3,9,2,12,6,4] -- > [3,2,4]`

**generate and test programming paradigm**
https://www.siggraph.org/education/materials/HyperVis/concepts/gen_test.htm

###Computations over lists
Many computatations that would be for/while loops in an imperative language are naturally expressed as list computations in a functional language.
There are some common cases:
* Perform a computation on each element of a list: mapmap
* Iterate over a list, from left to right: foldlfoldl
* Iterate over a list, from right to left: foldr

Function composition:
* We can express a large compution by “chaining together” a sequence of functions that perform smaller computations
* This is traditional mathematical notation; just remember that in f∘gf∘g, the functions are used in right to left order.
* Haskell uses . as the function composition operator

**Composition of maps**
`map f [x0,x1,x2] -- > [f x0, f x1, f x2]`

A common style is to define a set of simple computations using map, and to compose them.

`map f (map g xs) = map (f . g) xs`
This theorem is frequently used, in both directions.

Recursive definition of map
```
map :: (a -> b) -> [a] -> [b]
map _ []     = []
map f (x:xs) = f x : map f xs
```

###Folding a list (reduction)
An iteration over a list to produce a singleton value is called a fold
`foldl :: (b->a->b) -> b -> [a] -> b`

**point free**: instead of writing
`sum xs = foldr (+) 0 xs
product xs = foldr (*) 1 xs`

, you can “factor out” the xs that appears at the right of each side of the equation, and write:
```
sum      = foldr (+) 0
product  = foldr (*) 1
```


###Functional Maps and Folds versus Imperative Loops
https://github.com/wimvanderbauwhede/HaskellMOOC/tree/master/MapsFoldsLoopsTutorial

* **map**: loop over list element-by-element, append new element to new list
* **foldl**: loop over list element-by-element, update accumulator using current accumulator and element
* **foldr**: loop over reverse list element-by-element, update accumulator using current accumulator and element
* Note:
```
    map :: (a -> b) -> [a] -> [b]
    foldl :: (b -> a -> b) -> b -> [a] -> b 
    foldr :: (a -> b -> b) -> b -> [a] -> b
```

###Defining conditional functions
Option 1:
```
length [] = 0
length x:xs = 1 + length xs
```

Option 2:
```
length lst =
  if lst == []
    then 0
    else let x:xs = lst in 1 + length xs
```

Option 3: Alternatively, you can use what is known as "guards" (the pipe), e.g.
```
length lst
  | lst == [] = 0
  | otherwise = let x:xs = lst in 1 + length xs
```

Option 4:
```
f = f' where f' 1 = 0; f' x = x + f' (x-1)
```

Filter example:
```
λ filter (\x -> 2*x>10) [3,9,2,12,6,4]
[9,12,6]
```
**Recursive definition for filter**
```
filter pred lst
  | null lst = []
  | otherwise = if pred x 
     then x:filter pred xs
     else filter pred xs
       where x:xs=lst
```

A recursive function must have at least two cases:
* base case
* induction case

**Summary**
For list operations, it is usually easier to use higher-order functions like map (performing an operation on every element of a list) and foldl/foldr (reducing a list to a single value). Sometimes these functions are referred to as list combinators.


##Define your own data types
`data SimpleNum = One | Two | Many deriving Show`
```
Prelude> :t One
One :: SimpleNum

Prelude> :set +m    >> to be able to format a function through several lines

Prelude> let convert 1 = One
Prelude|     convert 2 = Two
Prelude|     convert _ = Many
```

**Type constructors to build record types (product data types)**:
```
Prelude> data CricketScore = Score [Char] Int Int deriving Show
Prelude> 
Prelude> let x = Score "New Zealand" 350 4
Prelude| 
Prelude> x
Score "New Zealand" 350 4
Prelude> :t x
x :: CricketScore
```

The alternative values relate to **algebraic sums**, and the record values relate to **algebraic products**.

###Grow a tree
https://www.futurelearn.com/courses/functional-programming-haskell/1/steps/116718
```
data Tree = Leaf | Node Int Tree Tree deriving Show
```

Let’s write a function to compute the depth of a Tree — this is the maximum number of branches from the root to any leaf. To write this function, we will do pattern matching on the different kinds of Tree, i.e. Leaf and Node values.
```
treeDepth :: Tree -> Int
treeDepth Leaf = 0
treeDepth (Node _ leftSubtree rightSubtree) = 
  1 + max (treeDepth leftSubtree) (treeDepth rightSubtree)
```

**Purely Functional Data Structures**
https://www.cs.cmu.edu/~rwh/theses/okasaki.pdf
https://en.wikipedia.org/wiki/Purely_functional_data_structure
A persistent data structure that does not rely on mutable state


###Type Classes
https://www.futurelearn.com/courses/functional-programming-haskell/1/steps/120260
Int, Float, Integer

Type classes: (+), (==), (<), show, read
```
read "1" :: Int
read "True" :: Bool
```
`data SimpleNum = One | Two | Many deriving (Show, Read, Eq)`

Type classes were one of the early innovations of the Haskell programming language. 
* The type class constrains member types to provide functions that conform to certain type signatures effectively, API constraints.
* Type classes are like interfaces in C# and Java. 
* Types in the type class are like concrete implementations of the interface. 
* Type classes provide a neat mechanism to enable operator overloading in the Haskell language. 


##Week 4: When programs get bigger

###Keep your programs tidy
https://www.futurelearn.com/courses/functional-programming-haskell/1/steps/120283

**let**
In Haskell, a let expression provides local scope. 
```
let x = 2
    y = 3
in x+y
```

```
let diameter = 2*radius
    circumference = pi*diameter
in (diameter, circumference)
```

**where**
There is another syntax for introducing local variables, called the where clause. The where keyword, inside an equation, provides definitions for variables that are used in the equation.
```
squareplusone :: Int -> Int
squareplusone x = xsquared + 1
 where xsquared = x*x
```

**Differences between let and where**
* `let` expressions are expressions; let can be used anywhere an expression is allowed.
* `where` clauses are not expressions; they can be used only to provide some local variables for a top level equation.

###Guards, guards!
https://www.futurelearn.com/courses/functional-programming-haskell/1/steps/120286
Haskell provides a notation for defining functions based on predicate values.

`absolute x = if (x<0) then (-x) else x`
or with guards
```
absolute x
  | x<0 = -x
  | otherwise = x
```
Guards are easier to read than if/then/else if there are more than two conditional outcomes

####Example
```
holeScore :: Int -> Int -> String
holeScore strokes par
  | strokes < par = show (par-strokes) ++ " under par"
  | strokes == par = "level par"
  | strokes > par = show(strokes-par) ++ " over par"
```

How could we tidy this up? Maybe we could turn the final guard into otherwise and also refactor with a where clause.
```
holescore :: Int -> Int -> String
holeScore strokes par
  | score < 0 = show (abs score) ++ " under par"
  | score == 0 = "level par"
  | otherwise = show(score) ++ " over par"
 where score = strokes-par
```

####Case expressions
The case expression examines the value, and chooses the corresponding clause. It’s like a guard, but it selects based on the form of the value, i.e. it does **pattern matching**.
Here is a sum data type for my pets.
`data Pet = Cat | Dog | Fish`

And here is how I greet my pets.
```
hello :: Pet -> String
hello x = 
  case x of
    Cat -> "meeow"
    Dog -> "woof"
    Fish -> "bubble"
```

Note that each pattern is followed by an arrow and then a value.


Let’s add a Parrot with a String name.
```
data Pet = Cat | Dog | Fish | Parrot String

hello :: Pet -> String
hello x = 
  case x of
    Cat -> "meeow"
    Dog -> "woof"
    Fish -> "bubble"
    Parrot name -> "pretty " ++ name
```
We could redefine hello as:
```
hello :: Pet -> String
hello x =
  case x of
    Parrot name -> "pretty " ++ name
    _ -> "grunt"
```

The `if` expression is just syntactic sugar that is rewritten automatically.

**GUARDS dispatch based on the outcome of Boolean expressions, whereas CASES dispatch based on the _structure_ of the expression (this is pattern matching).**

###Dealing with Uncertainty
https://www.futurelearn.com/courses/functional-programming-haskell/1/steps/120264

**Maybe**: equivalent to Optional in Java 8.




##Bookmark
https://www.futurelearn.com/courses/functional-programming-haskell/1/steps/120258



##Glossary
* RHS:      Right Hand Side
* GHCi:     Glasgow Haskell Compiler Interactive