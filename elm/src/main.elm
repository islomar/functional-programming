module Test exposing (..)

import Html exposing (div, text, h1)

type alias Model =
    { name : String
    , counter : Int
    }

initialModel = {name = "ELM 101", counter = 3}

view model =
    div [][
        h1 [][text model.name]
        , div [][text (toString model.counter)]
    ]

main =
    view initialModel