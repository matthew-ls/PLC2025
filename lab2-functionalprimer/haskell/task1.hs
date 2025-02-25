module Main where

main =
    do
    print (myFunc1 5)
    print (myFunc2 10)
    print (_3rdFunc)

-- function only starts with lower case or underscore
-- function only contains letters, underscore, digits or apostrophes
myFunc1 x = x*10
myFunc2 x = x*2
_3rdFunc = "Hello, this is 3rd Func"