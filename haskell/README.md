# Playground for Haskell

Notes and examples from "Learn you Haskell for good": learnyouhaskell.com
URL:	http://learnyouahaskell.com/


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


## Naming conventions
Functions can't begin with uppercase letters.



## GHCI file
* https://downloads.haskell.org/~ghc/7.4.2/docs/html/users_guide/ghci-dot-files.html
* https://wiki.haskell.org/GHC/GHCi



## GHCI commands
* :l baby.hs   >> loads the file baby.hs

## Bookmark