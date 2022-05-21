package game.items;

import game.actors.Drinker;
import game.grounds.fountains.Fountain;

public class Water{

    private Fountain fountain;

    public Water(Fountain fountain) {
        this.fountain = fountain;
    }

    public void useBuff(Drinker actor){
        fountain.buff(actor);
    }

    public String string(){
        return fountain.getWaterDescription();
    }

}


