package game.actors;

public interface Drinker {

    /**
     * Applies a buff to anyone that drinks from the Power Fountain
     *
     */
    void fountainIncreaseAttack(int attack);

    /**
     * Applies healing to anyone that drinks from the Healing Fountain
     *
     */
    void fountainHeal(int health);

}
