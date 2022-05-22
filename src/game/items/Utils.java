package game.items;

/**
 * An Utils class that holds variables that can not be changed
 */
public class Utils {
    public static final int WRENCH_PRICE = 200; // use this util for the price of a wrench
    public static final int SUPER_MUSHROOM_PRICE = 400; // use this util for the price of a super mushroom
    public static final int POWER_STAR_PRICE = 600; // use this util for the price of a power star
    public static final int DESTROYED_GROUND_VALUE = 5; // use this util for the coin value after a high ground has been destroyed
    public static final int SUPER_MUSHROOM_HP_INCREASE = 50; // use this util for the maximum increase in hp from a super mushroom
    public static final int POWER_STAR_HP_INCREASE = 200; // use this util for the increase in hp from a super mushroom
    public static final int POWER_STAR_EXPIRY_AGE = 10; // use this util for the increase in hp from a super mushroom
    public static final int INVINCIBLE_TURNS_LEFT = 11; // use this util for the amount of turns until power star runs out
                                                        //(an addition of one is added  to make up for the iterated turn
                                                        //from the player consumes the power star)
    public static final int LAVA_DAMAGE = 15; // use this util for implementing the Fire Ground damage
    public static final int FIRE_DAMAGE = 20; // use this util for implementing the Fire Ground damage made by Bowser
    public static final int FIRE_TURNS_LEFT = 20; // use this util for implementing the turns left until fire flower runs out

    public static final int POWER_FOUNTAIN_ATTACK_INCREASE = 15; // use this util for the increase in attack from the power fountain water
    public static final int HEALTH_FOUNTAIN_WATER_HP = 50; // use this util for the increase in hp from the health fountain water
    public static final int BOTTLE_AMOUNT = 10; // use this for the maximum amount of water a bottle can hold
    public static final int FOUNTAIN_REFILL_AGE = 5; // use this for the amount of turns it takes for the fountain to refill
    public static final int FOUNTAIN_FULL_AMOUNT = 10; // use this for the maximum amount of water a fountain can hold
    
    public static final int KOOPA_BASE_DMG = 30; // use this for the koopa base damage
    public static final int PLAYER_BASE_DMG = 5; // use this for the player base damage
    public static final int BOWSER_BASE_DMG = 80; // use this for the bowser base damage
    public static final int GOOMBA_BASE_DAMAGE = 10 ;// use this for the goomba base damage
}
