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


##GHCi
`:quit`     >>  quit HGCi
`:set +m`   >>  enable multiline
`:t <function_name` >> gets the type of a function
`putStrLn "hello"`

**Bookmark**
https://www.futurelearn.com/courses/functional-programming-haskell/1/steps/110660


##Glossary
* RHS:      Right Hand Side
* GHCi:     Glasgow Haskell Compiler Interactive