package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.WalletManager;
import game.items.PowerStar;
import game.items.Purchasable;

public class TradeAction extends Action {
    Purchasable item;
    int price;

    public TradeAction(Purchasable item, int price) {
        this.item = item;
        this.price = price;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        if (WalletManager.getInstance(actor).getBalance(actor)>=this.price){
            WalletManager.getInstance(actor).deductBalance(actor, this.price);
            this.item.add_item(actor);
            return actor + "successfully buys " + item;
        }
        else{
            return "Insufficient funds";
        }
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " buys " + item + " ($" + price + ")";
    }
}

