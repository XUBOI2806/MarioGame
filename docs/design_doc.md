#Design Rationale
##Req 3
###Goomba:
Goomba is a subclass of the Actor class as it shares several attributes. Any actor is spawned by the ActorLocationsIterator,
since a Goomba will spawn from a Tree there is an implied dependency of Goomba to Tree.

Goomba will implement several behaviours. First is the WanderBehaviour, which makes the actor wander to a random location.
Second is the FollowBehaviour, when the player enters the Goombas proximity, it will move towards the player. Third is
AttackBehaviour, when the player is within the range of the Goombas attack, then the Goomba will automatically try
attack the player. The attack can be implemented with AttackAction and its base damage will be given by the InstrinsicWeapon.
Fourth, the DestructBehaviour is for giving it a 10% chance of being removed from the map every turn. The DestructBehaviour
will use the DestructAction to remove the Goomba.

The above has been implemented as behaviours since only NPCs will have the DestructBehaviour and AttackBehaviour, but not
the player. In addition, adding these as behaviours adheres to the open close principle, making it easier to implement
for future Actors.

###Koopa:
Koopa is also a subclass of the Actor class, however when it is killed it is put into a dormant state. Koopa also
has a WanderBehaviour, FollowBehaviour and AttackBehaviour like Goomba. However, the Koopa does not have a DestructBehaviour
and instead has a DormantBehaviour. When in DormantBehaviour, it will stop the Wander, Attack and Follow Behaviour.

A Koopa can be destroyed in its Dormant State by an Actor that uses a Wrench. The Wrench
adds the capability of DestroyKoopaAble and that adds the Action DestroyKoopaAction. Doing this
will remove the Koopa from the map and drop a SuperMushroom.


##Req 4
###Super Mushroom
An actor can pick up a SuperMushroom by using PickUpItemAction. If an Actor picks up an Item that implements
ConsumeAble, then the Actor can use ConsumeItemAction to eat the Item. Eating a SuperMushroom will increase
the Actor's HP for a specific amount, therefore is IncreaseHealthCapable. The SuperMushroom gives
the enum status TALL and JumpCapable allowing the Actor to jump over high grounds.

###Power Star
A PowerStar is an expirable Item therefore implements ExpireAble, which makes it disappear within 10
turns of it being spawned. Eating a PowerStar will grant the user the STAR status. This gives the user
HighGroundCapable, which makes the Actor able to walk on high ground and turn them into coins.
The Actor also gains ImmuneCapable, making any incoming damage zero. 

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