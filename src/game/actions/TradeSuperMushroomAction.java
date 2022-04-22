package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.WalletManager;
import game.actors.Status;
import game.items.PowerStar;
import game.items.SuperMushroom;

public class TradeSuperMushroomAction extends Action {

    /**
     * Create a class of toad
     */
    protected Actor target;

    @Override
    public String execute(Actor actor, GameMap map) {
        if (WalletManager.getInstance().getBalance()>=400){
            WalletManager.getInstance().deductBalance(400);
            actor.addItemToInventory(new SuperMushroom());
            return this.menuDescription(actor);
        }
        else{
            return "Insufficient funds";
        }
    }

    @Override
    public String menuDescription(Actor actor) {
        for (Item item: target.getInventory()){
            if (item.hasCapability(Status.PURCHASABLE)){
                return actor + " buys " + item + (item);
            }
        }
        return "ADD SOMETHING HERE PLZ";
    }
}