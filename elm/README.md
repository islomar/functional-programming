#Elm 101

https://github.com/vgaltes/SCBCN_ELM101

https://www.elm-tutorial.org/en/

http://elm-lang.org/

- Statically typed
- Inferred types: it searchs for types which accomplishes the defined one...
- All values are immutable
- No runtime exceptions

https://github.com/vgaltes


`elm reactor`: te arranca en localhost:8000

`elm make main.elm --output main.js` >> 8k lines of code!!!

http://localhost:8000/src/main.elm


`model | counter = model.counter + 1` >> it takes the model object and creates a new one changing the counter attribute (that's the | mission)

Install **elm-format**

Recommended: "Elm in Action"

In Elm, using **subscriptions** is how your application can listen for external input. Some examples are:

* Keyboard events
* Mouse movements
* Browser locations changes
* Websocket events

Pattern matching: is it really just a `switch`? O_o

Refactoring is easier:
* Type systems help you
* Not having nulls help you