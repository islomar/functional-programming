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



##Bookmark
https://www.futurelearn.com/courses/functional-programming-haskell/1/steps/116038



##Glossary
* RHS:      Right Hand Side
* GHCi:     Glasgow Haskell Compiler Interactive