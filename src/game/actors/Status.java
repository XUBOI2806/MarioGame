package game.actors;

/**
 * Use this enum class to give `buff` or `debuff`.
 * It is also useful to give a `state` to abilities or actions that can be attached-detached.
 */
public enum Status {
    HOSTILE_TO_ENEMY, // use this status to be considered hostile towards enemy (e.g., to be attacked by enemy)
    TALL, // use this status to tell that current instance has "grown".
    INVINCIBLE, //use this status to tell that current instance has consumed a "star"
    WRENCH, // use this status to tell that current instance can destroy a Koopa in dormant state
    DORMANT, // use this status to tell that current instance is in dormant state and cannot move or be hit
    DORMANT_ABLE, // use this status to tell that when instance goes unconscious, change into DORMANT
    FLOOR, // use this status to tell that current instance can walk on floors
    RESET, // use this status to tell what can be soft reset by the ResetManager
    FIRE, // use this status to tell if an actor can set ground on fire after attack
    FLY, // use this status to tell if an actor can fly over high grounds
    HAS_PEACH_KEY, // use this status to tell if an actor has a PeachKey
    PLAYER, // use this status to determine whether the actor is a human
    PIRANHAPLANT,// use this to determine whether the plant is a piranha plant
    WARPPIPE,
    HAS_BOTTLE, // use this status to tell is an actor has a bottle
    TALK, // use this status to tell when the actor can talk
    FOUNTAIN, // use this status to tell if the ground is a fountain or not
}
