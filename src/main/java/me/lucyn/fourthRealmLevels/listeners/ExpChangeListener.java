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
            onExpChange(event);
        }
        fourthRealmLevels.fourthRealmCore.setPlayerData(realmPlayer);
        Bukkit.getPluginManager().callEvent(new PlayerLevelUpEvent(realmPlayer, realmPlayer.level));
    }

    public static int getXpToNextLevel(int level) {
        if (level < 10) return 100 + (level * 25);
        if (level < 20) return 100 + (level * 30);
        if (level < 30) return 100 + (level * 35);
        if (level < 40) return 100 + (level * 40);
        if (level < 50) return 100 + (level * 50);
        if (level < 60) return 100 + (level * 60);
        if (level < 70) return 100 + (level * 70);
        if (level < 80) return 100 + (level * 80);
        if (level < 90) return 100 + (level * 150);
        if (level < 100) return 100 + (level * 250);
        return 20000 + (level * 10000);


    }



}
