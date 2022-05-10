package game.actors;

import edu.monash.fit2099.engine.actors.Actor;

public class Monologue {
    private Actor actor;

    public Monologue(Actor actor) {
        this.actor = actor;
    }

    public void getStatement() {


    }



            if (actor.hasCapability(Status.WRENCH)){
                statement = this.spokenBy(actor);
            }
            else{
                statement = "You might need a wrench to smash Koopa's hard shells.";
            }
            break;
        case 1:
            if (actor.hasCapability(Status.INVINCIBLE)){
                statement = this.spokenBy(actor);
            }
            else{
                statement ="You better get back to finding the Power Stars.";
            }
            break;
        case 2:
            statement = "The Princess is depending on you! You are our only hope.";
            break;
        case 3:
            statement = "Being imprisoned in these walls can drive a fungus crazy :(";
            break;
    }
            return statement;
}

}
