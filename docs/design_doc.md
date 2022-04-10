#Requirements Documentation



##Req 5

Toad and the Player will make a trade, 
which will be a new behaviour. This behaviour will need to be checked if this action 
is able to be executed. If so, the player will check if they have enough money and if 
Toad has the available Item

An interact behaviour and action must be implemented first so that 
the player is able to interact with toad. Additionally, a new behaviour class will allow toad 
to have a possible trade action with 
the player. The behaviour class will determine whether the trade can be complete or not. 
Depending on the value of the player's wallet, the specific item wanted could be transacted 
through checking the capabilities class. If the value is not enough in the wallet, 
the transaction will be canceled and a sentence will be printed stating that the player does 
not have the required amount of coins.

##Req 6
Similar to the behaviour in req 5, the interact behaviour and action will be implemented. 
However, a new behaviour class will allow the player to have a possible speak action with toad. 
The behaviour class will determine whether the  speak action can be complete or not. 
Before printing the random statement, the capabilities class will check which statements can be 
printed or not. The capabilities will check through their players items and status change from 
consuming the super mushroom.

##Req 7
The reset manager will be activated once the button r is pressed. To erase the coins and enemies,
the locations of these items and enemies will be located and then they’ll be erased from the 
location. The trees will follow the same concept, however, it’ll have a 50% chance of not turning 
back into dirt. The player's status will also be reset back to none.