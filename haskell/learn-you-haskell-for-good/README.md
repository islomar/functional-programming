# Introduction

This is a playground for Haskell.

Currently, it includes notes and examples from "Learn you Haskell for good": learnyouhaskell.com

Webinar: https://www.dropbox.com/s/vyg4b96am0r6fhv/haskell-alejandro%20serrano.m4v?dl=0

# Starting out

## Ready, set, go!

In purely functional programming you don't tell the computer what to do as such but rather you tell it what stuff is.

So in purely functional languages, a function has no side-effects.

The only thing a function can do is calculate something and return it as a result.

Haskell is **lazy**. That means that unless specifically told otherwise, Haskell won't execute functions and calculate things until it's really forced to show you a result. The only thing a function can do is calculate something and return it as a result.

If a function is called twice with the same parameters, it's guaranteed to return the same result. That's called **referential transparency** and not only does it allow the compiler to reason about the program's behavior, but it also allows you to easily deduce (and even prove) that a function is correct and then build more complex functions by gluing simple functions together.

Haskell is **statically typed**.

Haskell uses a very good type system that has **type inference**. That means that you don't have to explicitly label every piece of code with a type because the type system can intelligently figure out a lot about it.

Work on Haskell began in 1987 when a committee of researchers got together to design a kick-ass language. In 2003 the Haskell Report was published, which defines a stable version of the language.

Haskell installation: /Library/Haskell/doc/start.htm

 * is a function that takes two numbers and multiplies them. As you've seen, we call it by sandwiching it between them. This is what we call an **infix function**. Most functions that aren't used with numbers are **prefix functions**.

In Haskell, functions are called by writing the function name, a space and then the parameters, separated by spaces.

Function application (calling a function by putting a space after it and then typing out the parameters) has the highest precedence of them all.

$ ghci
Prelude>

If a function takes two parameters, we can also call it as an infix function by surrounding it with **backticks**. For instance, the divfunction takes two integers and does integral division between them. Doing *div 92 10* results in a 9. But when we call it like that, there may be some confusion as to which number is doing the division and which one is being divided. So we can call it as an infix function by doing *92 `div` 10* and suddenly it's much clearer.


## Baby's first functions

Functions in Haskell don't have to be in any particular order, so it doesn't matter if you define doubleMe first and then doubleUs or if you do it the other way around.

We usually use ' to either denote a strict version of a function (one that isn't lazy) or a slightly modified version of a function or a variable.

When a function doesn't take any parameters, we usually say it's a *definition* (or a *name*).


## An intro to lists
Strings are just lists of characters. 
We can use the *let* keyword to define a name right in GHCI. Doing let a = 1 inside GHCI is the equivalent of writing a = 1 in a script and then loading it.

Lists are denoted by square brackets and the values in the lists are separated by commas.
A common task is putting two lists together. This is done by using the ++ operator.

`ghci> ['w','o'] ++ ['o','t']`
"woot"`

When you put together two lists (even if you append a singleton list to a list, for instance: [1,2,3] ++ [4]), internally, *Haskell has to walk through the whole list on the left side of ++*. That's not a problem when dealing with lists that aren't too big. But putting something at the end of a list that's fifty million entries long is going to take a while. However, putting something at the beginning of a list using *the : operator* (also called the cons operator) is instantaneous.
`ghci> 5:[1,2,3,4,5]  
[5,1,2,3,4,5]`
Notice how : takes a number and a list of numbers or a character and a list of characters, whereas ++ takes two lists. Even if you're adding an element to the end of a list with ++, you have to surround it with square brackets so it becomes a list.

If you want to get an element out of a list by index, use !!. The indices start at 0.
`ghci> "Steve Buscemi" !! 6  
'B'  
ghci> [9.4,33.2,96.2,11.2,23.25] !! 1  
33.2`

The lists within a list can be of different lengths but they can't be of different types. 

Basic functions on lists:
* head: takes a list and returns its head. The head of a list is basically its first element.
* tail: takes a list and returns its tail. In other words, it chops off a list's head.
* last:	takes a list and returns its last element.
* init: takes a list and returns everything except its last element
* length
* null:	checks if a list is empty. If it is, it returns True, otherwise it returns False.
* reverse
* take: takes number and a list. It extracts that many elements from the beginning of the list.
* drop
* maximum
* minimum
* sum
* product
* elem: takes a thing and a list of things and tells us if that thing is an element of the list. It's usually called as an infix function because it's easier to read that way.
`ghci> 4 `elem` [3,4,5,6]  
True  
ghci> 10 `elem` [3,4,5,6]  
False`


## Texas ranges
`ghci> [1..20]  
[1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20]`

You should better avoid using floating point numbers in ranges.
`ghci> [0.1, 0.3 .. 1]  
[0.1,0.3,0.5,0.7,0.8999999999999999,1.0999999999999999]`

You can also use ranges to make infinite lists by just not specifying an upper limit. Later we'll go into more detail on infinite lists. For now, let's examine how you would get the first 24 multiples of 13. Sure, you could do [13,26..24*13]. But there's a better way: **take 24 [13,26..]**. **Because Haskell is lazy, it won't try to evaluate the infinite list immediately because it would never finish.** It'll wait to see what you want to get out of that infinite lists. And here it sees you just want the first 24 elements and it gladly obliges.


## I'm a list comprehension
If you've ever taken a course in mathematics, you've probably run into set **comprehensions**. They're normally used for building more specific sets out of general sets. A basic comprehension for a set that contains the first ten even natural numbers is S = { 2 * x | x belongs to N, x<=10}. 
The part before the pipe is called the output function, x is the variable, N is the input set and x <= 10 is the **predicate**. That means that the set contains the doubles of all natural numbers that satisfy the predicate.
List comprehensions are very similar to set comprehensions:
`ghci> [x*2 | x <- [1..10]]  
[2,4,6,8,10,12,14,16,18,20]`

Now let's add a condition (or a predicate) to that comprehension:
`ghci> [x*2 | x <- [1..10], x*2 >= 12]  
[12,14,16,18,20]  `

`ghci> [ x | x <- [50..100], x `mod` 7 == 3]  
[52,59,66,73,80,87,94] `

We can include several predicates:
`ghci> [ x | x <- [10..20], x /= 13, x /= 15, x /= 19]  
[10,11,12,14,16,17,18,20]`

Let's say we want a comprehension that replaces each odd number greater than 10 with "BANG!" and each odd number that's less than 10 with "BOOM!". If a number isn't odd, we throw it out of our list. For convenience, we'll put that comprehension inside a function so we can easily reuse it.

boomBangs xs = [ if x < 10 then "BOOM!" else "BANG!" | x <- xs, odd x] 

`ghci> boomBangs [7..13]  
["BOOM!","BOOM!","BANG!","BANG!"] `

`
ghci> [ x*y | x <- [2,5,10], y <- [8,10,11]]  
[16,20,22,40,50,55,80,100,110]
`

`
ghci> [ x*y | x <- [2,5,10], y <- [8,10,11], x*y > 50]  
[55,80,100,110] 
`

Let's write our own version of length! We'll call it length'.
` length' xs = sum [1 | _ <- xs]   `
_ means that we don't care what we'll draw from the list anyway so instead of writing a variable name that we'll never use, we just write _. This function replaces every element of a list with 1 and then sums that up. This means that the resulting sum will be the length of our list.

`
ghci> let xxs = [[1,3,5,2,3,1,2,4,5],[1,2,3,4,5,6,7,8,9],[1,2,4,2,1,6,3,1,3,2,3,6]]  
ghci> [ [ x | x <- xs, even x ] | xs <- xxs]  
[[2,2,4],[2,4,6,8],[2,4,2,6,2,6]]
`

* cycle: takes a list and cycles it into an infinite list. If you just try to display the result, it will go on forever so you have to slice it off somewhere.
`ghci> take 10 (cycle [1,2,3])  
[1,2,3,1,2,3,1,2,3,1]  
ghci> take 12 (cycle "LOL ")  
"LOL LOL LOL "`
* repeat: takes an element and produces an infinite list of just that element. It's like cycling a list with only one element.
`ghci> take 10 (repeat 5)  
[5,5,5,5,5,5,5,5,5,5]`



## Tuples
Unlike a list, a tuple can contain a combination of several types.
They are denoted with parentheses and their components are separated by commas.
ghci> let myTuple = [(1,2),(8,11),(4,5)]
Use tuples when you know in advance how many components some piece of data should have.
* fst: takes a pair and returns its first component.
* snd: takes a pair and returns its second component.
* zip: it produces a list of pairs
`
ghci> zip [1,2,3,4,5] [5,5,5,5,5]  
[(1,5),(2,5),(3,5),(4,5),(5,5)]  
ghci> zip [1 .. 5] ["one", "two", "three", "four", "five"]  
[(1,"one"),(2,"two"),(3,"three"),(4,"four"),(5,"five")] 
`

Which right triangle that has integers for all sides and all sides equal to or smaller than 10 has a perimeter of 24?:
`let rightTriangles' = [ (a,b,c) | c <- [1..10], b <- [1..c], a <- [1..b], a^2 + b^2 == c^2, a+b+c == 24] `
This is a common pattern in functional programming. You take a starting set of solutions and then you apply transformations to those solutions and filter them until you get the right ones.



# Types and Typeclasses

## Believe the type
Previously we mentioned that Haskell has a static type system. The type of every expression is known at compile time, which leads to safer code.
Unlike Java or Pascal, Haskell has type inference. If we write a number, we don't have to tell Haskell it's a number. It can infer that on its own.
You can use :t to evaluate the type of an expression, for example:
`ghci> :t 'a'  
'a' :: Char `

Here we see that doing :t on an expression prints out the expression followed by :: and its type. :: is read as "has type of".

Functions also have types. When writing our own functions, we can choose to give them an explicit type declaration. This is generally considered to be good practice except when writing very short functions.

removeNonUppercase :: [Char] -> [Char]
removeNonUppercase st = [ c | c <- st, c `elem` ['A'..'Z']] 
removeNonUppercase has a type of [Char] -> [Char], meaning that it maps from a string to a string.

addThree :: Int -> Int -> Int -> Int  
addThree x y z = x + y + z  
The parameters are separated with -> and there's no special distinction between the parameters and the return type. The return type is the last item in the declaration and the parameters are the first three. 

Some common types (types are written in capital case):
* Int: Usually on 32-bit machines the maximum possible Int is 2147483647 and the minimum is -2147483648.
* Integer: The main difference is that it's not bounded so it can be used to represent really really big numbers. I mean like really big. **Int, however, is more efficient.**
* Float: real floating point with single precision.
* Double: real floating point with double the precision!
* Bool
* Char
* Ordering
* Tuples are also a type



## Typeclasses 101
**A typeclass is a sort of interface that defines some behavior.** If a type is a part of a typeclass, that means that it supports and implements the behavior the typeclass describes. A lot of people coming from OOP get confused by typeclasses because they think they are like classes in object oriented languages. Well, they're not. You can think of them kind of as Java interfaces, only better.
`
ghci> :t (==)  
(==) :: (Eq a) => a -> a -> Bool 
`
We see a new thing here, the => symbol. Everything before the => symbol is called a class constraint. We can read the previous type declaration like this: the equality function takes any two values that are of the same type and returns a Bool. The type of those two values must be a member of the Eq class (this was the class constraint).


Some basic typeclasses:
* Eq
The **Eq** typeclass provides an interface for testing for equality. Any type where it makes sense to test for equality between two values of that type should be a member of the Eq class. All standard Haskell types except for IO (the type for dealing with input and output) and functions are a part of the Eq typeclass.
* Ord
* Show
Members of Show can be presented as strings. All types covered so far except for functions are a part of Show. 
* Read
* Enum: members are sequentially ordered types
Types in this class: (), Bool, Char, Ordering, Int, Integer, Float and Double.
* Bounded
* Num
* Integral
* Floating

we can use explicit type annotations. Type annotations are a way of explicitly saying what the type of an expression should be. We do that by adding :: at the end of the expression and then specifying a type. Observe:
`
ghci> read "5" :: Int  
5  
ghci> read "5" :: Float  
5.0  
`

A very useful function for dealing with numbers is fromIntegral.
If we try to get a length of a list and then add it to 3.2, we'll get an error because we tried to add together an Int and a floating point number. So to get around this, we do fromIntegral (length [1,2,3,4]) + 3.2 and it all works out.


# Syntax in functions

## Pattern matching
(See example code on baby.hs)
Pattern matching consists of specifying patterns to which some data should conform and then checking to see if it does and deconstructing the data according to those patterns.
When defining functions, you can define separate function bodies for different patterns. This leads to really neat code that's simple and readable.
 When making patterns, we should always include a catch-all pattern so that our program doesn't crash if we get some unexpected input.


## Guards, guards!!
* Whereas patterns are a way of making sure a value conforms to some form and deconstructing it, guards are a way of testing whether some property of a value (or several of them) are true or false.
* Guards are indicated by pipes that follow a function's name and its parameters: see example code.
* This is very reminiscent of a big if else tree in imperative languages, only this is far better and more readable. 
* Many times, the last guard is otherwise. otherwise is defined simply as otherwise = True and catches everything. This is very similar to patterns, only they check if the input satisfies a pattern but guards check for boolean conditions.


## Where!?
* it avoids duplicating code and improves readibility.
* where bindings can also be nested. It's a common idiom to make a function and define some helper function in its where clause and then to give those functions helper functions as well, each with its own where clause.


## Let it be
Very similar to where bindings are let bindings. Where bindings are a syntactic construct that let you bind to variables at the end of a function and the whole function can see them, including all the guards. Let bindings let you bind to variables anywhere and are expressions themselves, but are very local, so they don't span across guards.
The form is let <bindings> in <expression>. The names that you define in the let part are accessible to the expression after the in part.
The difference between "where" and "let" is that let bindings are expressions themselves. where bindings are just syntactic constructs.

They can also be used to introduce functions in a local scope:
ghci> [let square x = x * x in (square 5, square 3, square 2)]  
[(25,9,4)] 

If let bindings are so cool, why not use them all the time instead of where bindings, you ask? Well, since let bindings are expressions and are fairly local in their scope, they can't be used across guards. Some people prefer where bindings because the names come after the function they're being used in. That way, the function body is closer to its name and type declaration and to some that's more readable.


## Case expressions
It's pattern matching on parameters in function definitions!
case expression of pattern -> result  
                   pattern -> result  
                   pattern -> result  
                   ... 

# Recursion
## Hello recursion!
* Recursion is actually a way of defining functions in which the function is applied inside its own definition.
* Having an element or two in a recursion definition defined non-recursively is also called the edge condition and is important if you want your recursive function to terminate. 
* Recursion is important to Haskell because unlike imperative languages, you do computations in Haskell by declaring what something is instead of declaring how you get it. That's why there are no while loops or for loops in Haskell and instead we many times have to use recursion to declare what something is.


# Others
## Naming conventions
Functions can't begin with uppercase letters.


## GHCI file
* https://downloads.haskell.org/~ghc/7.4.2/docs/html/users_guide/ghci-dot-files.html
* https://wiki.haskell.org/GHC/GHCi


## GHCI commands
* `:l baby.hs`   >> loads the file baby.hs

## Bookmark
http://learnyouahaskell.com/syntax-in-functions
