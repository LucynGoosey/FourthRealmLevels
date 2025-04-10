package me.lucyn.fourthRealmLevels.listeners;

import me.lucyn.fourthRealmLevels.FourthRealmLevels;
import me.lucyn.fourthRealmLevels.events.PlayerLevelUpEvent;
import me.lucyn.fourthrealm.RealmPlayer;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class ExpChangeListener implements Listener {

    FourthRealmLevels fourthRealmLevels;


    public ExpChangeListener(FourthRealmLevels plugin) {
        this.fourthRealmLevels = plugin;

    }

    @EventHandler
    public void onExpChange(org.bukkit.event.player.PlayerExpChangeEvent event) {
        RealmPlayer realmPlayer = fourthRealmLevels.fourthRealmCore.getPlayerData(event.getPlayer());
        realmPlayer.XP += event.getAmount();

        if (realmPlayer.XP >= getXpToNextLevel(realmPlayer.level)) {
            realmPlayer.XP -= getXpToNextLevel(realmPlayer.level);
            realmPlayer.level++;
        }
        fourthRealmLevels.fourthRealmCore.setPlayerData(realmPlayer);
        Bukkit.getPluginManager().callEvent(new PlayerLevelUpEvent(realmPlayer, realmPlayer.level));
    }

    public static int getXpToNextLevel(int level) {
        return 100 + (level * 25);
    }



}
