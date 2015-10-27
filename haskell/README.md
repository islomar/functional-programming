# Playground for Haskell

Notes and examples from "Learn you Haskell for good": learnyouhaskell.com

# Notes

http://learnyouahaskell.com/

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

## GHCI file
* https://downloads.haskell.org/~ghc/7.4.2/docs/html/users_guide/ghci-dot-files.html
* https://wiki.haskell.org/GHC/GHCi

## GHCI commands
* :l baby.hs   >> loads the file baby.hs

## Bookmark