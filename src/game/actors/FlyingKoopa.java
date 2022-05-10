package game.actors;

public class FlyingKoopa extends Koopa{

    public FlyingKoopa(){
        super();
        this.setDisplayChar('F');
        this.resetMaxHp(150);
        this.addCapability(Status.FLY);
    }

}
