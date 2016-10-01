module Test exposing (..)

import Html exposing (div, text, h1)

view model =
    div[][
        h1[][text model]
    ]

main =
    view "Hello Barcelona!"