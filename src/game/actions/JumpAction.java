package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.actors.Status;
import game.grounds.State;

public class JumpAction extends Action {

    protected  Location location; //location the actor is jumping to

    protected Actor actor; //the actor that is jumping

    public JumpAction(Actor actor, Location location) {
        this.actor = actor;
        this.location = location;
    }

    /**
     * execute determines whether or not the actor has jumped to a particular terrain and if damage is taken
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return a string that describes whether or not jump is a success
     */
    @Override
    public String execute(Actor actor, GameMap map) {
       String result = actor + " is attempting to jump onto " + location;

       if(map.locationOf(actor).getGround().hasCapability(State.FERTILE)) //checks current terrain of the actor
       {
           if(actor.hasCapability(Status.TALL)&& location.canActorEnter(actor)){//consumed super mushroom
               map.moveActor(actor,location); //move instantly
               result += System.lineSeparator() + actor + "has jumped to " + location;

           }
           else {

               //Options of terrain that the actor can jump to
               if (location.getGround().hasCapability(State.SPROUT) && location.canActorEnter(actor)) { //if actor wants to jump onto a sprout
                   if (Math.random() <= 0.9) {
                       map.moveActor(actor, location); //moves actors to the new location
                       result += System.lineSeparator() + actor + "has jumped to " + location;

                   }
                   if (!actor.isConscious()){
                       result += System.lineSeparator() + actor + "has died from jumping to" + location;
                   }
                   else{
                       result += System.lineSeparator() + actor + "has failed to jump to " + location;
                   }
               }

               if (location.getGround().hasCapability(State.SAPLING) || location.getGround().hasCapability(State.WALL) && location.canActorEnter(actor)) {
                   if (Math.random() <= 0.8) {
                       map.moveActor(actor, location);
                       result += System.lineSeparator() + actor + "has jumped to " + location;
                   }
                   actor.hurt(20);
                   if (!actor.isConscious()){
                        result += System.lineSeparator() + actor + "has died from jumping to" + location;
                   }
                   else{
                       result += System.lineSeparator() + actor + "has failed to jump to " + location;
                   }

               }

               if (location.getGround().hasCapability(State.MATURE) && location.canActorEnter(actor)) {
                   if (Math.random() <= 0.7) {
                       map.moveActor(actor, location);
                       result += System.lineSeparator() + actor + "has jumped to " + location;
                   }
                   actor.hurt(30);
                   if (!actor.isConscious()){
                       result += System.lineSeparator() + actor + "has died from jumping to" + location;
                   }
                   else{
                       result += System.lineSeparator() + actor + "has failed to jump to " + location;
                   }
               }
           }
       }
        if(map.locationOf(actor).getGround().hasCapability(State.SPROUT))
        {
            if(actor.hasCapability(Status.TALL)&& location.canActorEnter(actor)){//consumed super mushroom
                map.moveActor(actor,location); //move instantly
                result += System.lineSeparator() + actor + "has jumped to " + location;
            }
            else{
                if (location.getGround().hasCapability(State.SAPLING) || location.getGround().hasCapability(State.WALL) && location.canActorEnter(actor)) {
                    if (Math.random() <= 0.8) {
                        map.moveActor(actor, location);
                        result += System.lineSeparator() + actor + "has jumped to " + location;
                    }
                    actor.hurt(20);
                    if (!actor.isConscious()){
                        result += System.lineSeparator() + actor + "has died from jumping to" + location;
                    }
                    else{
                        result += System.lineSeparator() + actor + "has failed to jump to " + location;
                    }
                }

                if (location.getGround().hasCapability(State.MATURE) && location.canActorEnter(actor)) {
                    if (Math.random() <= 0.7) {
                        map.moveActor(actor, location);
                        result += System.lineSeparator() + actor + "has jumped to " + location;
                    }
                    actor.hurt(30);
                    if (!actor.isConscious()){
                        result += System.lineSeparator() + actor + "has died from jumping to" + location;
                    }
                    else{
                        result += System.lineSeparator() + actor + "has failed to jump to " + location;
                    }
                }
            }
        }
        if(map.locationOf(actor).getGround().hasCapability(State.SAPLING))
        {
            if(actor.hasCapability(Status.TALL)&& location.canActorEnter(actor)){//consumed super mushroom
                map.moveActor(actor,location); //move instantly
                result += System.lineSeparator() + actor + "has jumped to " + location;
            }
            else{
                if (location.getGround().hasCapability(State.WALL) && location.canActorEnter(actor)) {
                    if (Math.random() <= 0.8) {
                        map.moveActor(actor, location);
                        result += System.lineSeparator() + actor + "has jumped to " + location;
                    }
                    actor.hurt(20);
                    if (!actor.isConscious()){
                        result += System.lineSeparator() + actor + "has died from jumping to" + location;
                    }
                    else{
                        result += System.lineSeparator() + actor + "has failed to jump to " + location;
                    }
                }

                if (location.getGround().hasCapability(State.MATURE) && location.canActorEnter(actor)) {
                    if (Math.random() <= 0.7) {
                        map.moveActor(actor, location);
                        result += System.lineSeparator() + actor + "has jumped to " + location;
                    }
                    actor.hurt(30);
                    if (!actor.isConscious()){
                        result += System.lineSeparator() + actor + "has died from jumping to" + location;
                    }
                    else{
                        result += System.lineSeparator() + actor + "has failed to jump to " + location;
                    }
                }
            }
        }

        if(map.locationOf(actor).getGround().hasCapability(State.MATURE))
        {
            if(actor.hasCapability(Status.TALL)&& location.canActorEnter(actor)){//consumed super mushroom
                map.moveActor(actor,location); //move instantly
                result += System.lineSeparator() + actor + "has jumped to " + location;
            }
            else{
                if (location.getGround().hasCapability(State.WALL) && location.canActorEnter(actor)) {
                    if (Math.random() <= 0.8) {
                        map.moveActor(actor, location);
                        result += System.lineSeparator() + actor + "has jumped to " + location;
                    }
                    actor.hurt(20);
                    if (!actor.isConscious()){
                        result += System.lineSeparator() + actor + "has died from jumping to" + location;
                    }
                    else{
                        result += System.lineSeparator() + actor + "has failed to jump to " + location;
                    }

                }
            }
        }

        if(map.locationOf(actor).getGround().hasCapability(State.WALL)){
            result += System.lineSeparator() + actor + "can not jump anywhere higher!!! " + location;
        }


        return result;
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " has jumped all the way to " + location;
    }

    @Override
    public String hotkey() {
        return super.hotkey();
    }

    @Override
    public Action getNextAction() {
        return super.getNextAction();
    }
}
