#Req 1
It is crucial that there is no actors other then players that can enter the Lava ground other then the player, we want
to ensure this as we only want the player to take damage and not have damaged enemy from the lava as the game design is
to maximise a fun playing opportunity meaning not killing enemies when they are almost dead.

Warp pipe is to ensure that Piranha plant is spawned after one round to give players lee way on the first turn of not
being attacked by a warp plant after 1 round, allows for Players to teleport on Warp pipe from the original game map
onto a hard game map governed by burning grounds such as lava mentioned above, the severe reduction in the dimension of
the game map is to raise the difficulty for players who want a challenge by having the players have more interactions with
the enemies.

Teleport action additionally allows for teleportation back to the previous warp pipe as there might be a desired location
near the warp pipe, this option allows for instant kill on the piranha plant that is stationed on the warp pipe.

##Req 2
###More Allies and enemies!
This requirement adds Princess Peach, who is an ally and doesn't implement any of the behaviours like the enemies.
PrincessPeach allows an EndGameAction which will remove the player from the map to end the game. Princess Peach extends
the actor class following the Open-Closed Principle.

Bowser is an enemy that inherits the Actor class. Bowser

##Req 3
###Magical Fountain
Magical Fountain will have child classes of Health Fountain and Power Fountain. Magical Fountain will also extend from
the ground class as it has attribute of a terrain on the map. Within the optional challenge a capacity and refill age
will be needed to keep track of variables. It will implement the allowable actions method from the ground class and
restrict any interaction with it except if the actor has a bottle. Buff, getWaterDescription and getFountainDescription
are methods within fountain as they differ depending on the specific fountain. Tick and getCapacity method will allow
assist in refilling the water capacity is has been used completely. The getWater method will interact with the
BottleManager instance which was utilised for the purpose of when another actor that is able to use a bottle appears in
the system since the engine can not be modified.

Bottle is also an item however the only use of it is to provide a status and be able to obtained through toad. This
obtaining of the bottle is executed through an obtain action where the bottle implements the obtainable interface.
This allows the obtain item action to be executed where the parameters the item and the actor giving the item are needed
so that when the actor obtaining the item knows what the item is and the target also removes the item from their inventory,
removing the ability to obtain from the target ever again.

A bottle manager was implemented so that if there was another actor, or another player, the bottle manager is able to
handle that. This reduces the need to access the item in the players inventory as well as the bottle manager can handle
the contents of what is inside the bottle and all actions related to it. A stack was used for the water to allow it to
push and pop water. Additionally, to ensure that a new bottle manager won't be created again, it will instantiate itself
once and will only retrieve that instance.

A drinker interface has been implemented so that people that drink from the fountain are able to receive the specific buff
from the fountain it came from. To prevent overlapping, a parameter will be added in the method for buffing so that if the
buff value of the fountain changed, it can be changed immediately, instead of going through all actors that utilise the
method, which adheres to the open-closed principle.

#Req 4
The fire flower allows for growth of fire flower through each stage of cycle, without the restriction of having only one
per location. This means maximal of 2 fire flower per location and such that there always have to be a 50% chance of
spawning so.


##Req 5
###Speaking
A speakable interface is implemented for all actors that can talk, which follows the dependency inversion principle.
They will all have a list of monologues that they are able to say, which parameters needed for when the action is executed.
The monologue class will be implemented to check the condition of whether it can be said by the actor
depending on the target's conditions. The speak action will then randomly generate the sentences that may be able to be
said and returned.

For an actor to return a sentence every two turns, actors will have a status talk when they can talk. This status will
be removed once a sentence has been said or if the actor did not say anything, they will add the talk status, which
adheres to the every 2 turn concept.

For the actor to be able to have more than one action on a turn, since playturn only allows one turn to be returned,
the action will be executed and the line that it returns will only be printed.


