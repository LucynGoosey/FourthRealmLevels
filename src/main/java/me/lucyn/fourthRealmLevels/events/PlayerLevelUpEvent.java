package me.lucyn.fourthRealmLevels.events;

import me.lucyn.fourthrealm.RealmPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class PlayerLevelUpEvent extends Event {

    private static final HandlerList handlers = new HandlerList();

    private final RealmPlayer realmPlayer;
    private final int level;


    public PlayerLevelUpEvent(RealmPlayer realmPlayer, int level) {
        this.realmPlayer = realmPlayer;
        this.level = level;
    }




    public RealmPlayer getRealmPlayer() {
        return realmPlayer;
    }

    public Player getPlayer() {
        return realmPlayer.getPlayer();
    }


    public int getLevel() {
        return level;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
