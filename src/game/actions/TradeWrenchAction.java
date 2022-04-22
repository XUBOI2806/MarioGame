package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.WalletManager;
import game.items.PowerStar;
import game.items.Wrench;

public class TradeWrenchAction extends Action {

    /**
     * Create a class of toad
     */
    protected Actor target;

    @Override
    public String execute(Actor actor, GameMap map) {
        if (WalletManager.getInstance().getBalance()>=200){
            WalletManager.getInstance().deductBalance(200);
            actor.addItemToInventory(new Wrench());
            return this.menuDescription(actor);
        }
        else{
            return "Insufficient funds";
        }
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " buys Wrench ($200)";
    }
}