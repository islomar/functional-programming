#Functional programming for Java developers
Annotations from the O'Reilly book.
June 2011 (I don't think Java 8 was officially released).


##Chapter 2: what is functional programming?
###The basic principles of functional programming
* Functional programming, in its purest form, doesn't allow mutable values.
* The **#{Action event e -> System.out.println("Hello there: " + e)}** expression is the literal syntax for lambda expressions.
 * The term **lambda** is another term for anonymous function. It comes from the use of the Greek lambda symbol to represent functions in lambda calculus.
* **Closure**
 * A closure is formed when the body of a function refers to one or more free variables, variables that aren't pssed in as arguments or defined locally, but are defined in the enclosing scope where the function is defined.
* **Higher-Order functions**: functions which take functions as arguments.
* In mathematics, **functions** never have side effects, menaing the are *side-effect-free*
* **Referential transparency**: being able to replace a function call for a particular set of parameters with the value it returns.
* **Tail-call recursive**: the last call is to a recursive function. 


###Designing types
* In a **pure** funcitonal language were values are immutable, each variable must be initialized to a a value that can be checked to make sure it is valid.
This suggests that we should never allow a variable to reference our old friend, *null*.
* **Option** interface with only two valid implementation types: **Some** and **None** (it reminds me the Java8 Optional with Absent).
* Algebraic Data Types and Abstract Data Types 
  * Algebraic Data Types 
    * **Option** is an algebraic data type, which means that there can be only a few well-defined types that implement the abstraction, and that there are well-defined rules for transitioning from an instance of one type to another.
    * Example: lists
    * An algebraicDT like **Option** constraints the number of possible subtypes that implement the abstraction.
  * Abstract Data Types
    * You define an interface for an abstraction and give it well-defined semantics. The abstraction is implemented by one or more types.
     Unlike algebraic data types, you might take these concrete classes private and hide them behind a factory, which could decide which class to instantiate based on the input arguments.
    * Example: a map of key-value pairs.
    * An abstractDT imposes no limit on the possible subtypes.
     
     
###Data structures and algorithms
This chapter looks at how the principles of functional programming influence the design of data structures and algorithms.
* Pure functional programming uses recursion instead of loops, since a loop counter would have to be mutable.
* **Combinator functions**
 * Filter
 * Map
 * Fold (=reduce): An example is summing a list of integers.

##Pending:
* [Tail-call optimization](http://www.programmerinterview.com/index.php/recursion/tail-call-optimization/)
