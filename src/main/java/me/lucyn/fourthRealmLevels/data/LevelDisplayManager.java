package me.lucyn.fourthRealmLevels.data;

import me.lucyn.fourthRealmLevels.events.PlayerLevelUpEvent;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

public class LevelDisplayManager implements Listener {

    private final Objective levelObjective;

    public LevelDisplayManager() {
        this.levelObjective = Bukkit.getScoreboardManager().getMainScoreboard().getObjective("Level");
    }

    @EventHandler
    public void onPlayerLevelUp(PlayerLevelUpEvent event) {
        Score score = levelObjective.getScore(event.getPlayer());
        score.setScore(event.getLevel());

    }




}
