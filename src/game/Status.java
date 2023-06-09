package game;

/**
 * Use this enum class to give `buff` or `debuff`.
 * It is also useful to give a `state` to abilities or actions that can be attached-detached.
 */
public enum Status {
    HOSTILE_TO_ENEMY, // use this status to be considered hostile towards enemy (e.g., to be attacked by enemy)
    TALL, // use this status to tell that current instance has "grown".
    FRIENDLY, // use this status to be untargettable by anyone
    INVINCIBLE, //use this status to tell that current instance has consumed a "star"
    WRENCH, // use this status to tell that current instance can destroy a Koopa in dormant state
    DORMANT, // use this status to tell that current instance is in dormant state and cannot move or be hit
    DORMANT_ABLE, // use this status to tell that when instance goes unconscious, change into DORMANT
    FLOOR, // use this status to tell that current instance can walk on floors
}
