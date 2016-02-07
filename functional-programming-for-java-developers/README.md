#Functional programming for Java developers
Annotations from the O'Reilly book.

##Chapter 2: what is functional programming?
* Functional programming, in its purest form, doesn't allow mutable values.
* **Closure**
 * A closure is formed when the body of a function refers to one or more free variables, variables that aren't pssed in as arguments or defined locally, but are defined in the enclosing scope where the function is defined.
* **Higher-Order functions**: functions which take functions as arguments.
* In mathematics, **functions** never have side effects, menaing the are *side-effect-free*
* **Referential transparency**: being able to replace a function call for a particular set of parameters with the value it returns.
* **Tail-call recursive**: the last call is to a recursive function. 

Pending:
* [Tail-call optimization](http://www.programmerinterview.com/index.php/recursion/tail-call-optimization/)