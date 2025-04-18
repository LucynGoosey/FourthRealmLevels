package me.lucyn.fourthRealmLevels;


import me.lucyn.fourthRealmLevels.data.LevelDisplayManager;
import me.lucyn.fourthRealmLevels.listeners.ExpChangeListener;
import me.lucyn.fourthrealm.FourthRealmCore;
import org.bukkit.plugin.java.JavaPlugin;

public final class FourthRealmLevels extends JavaPlugin {

    public FourthRealmCore fourthRealmCore;


    @Override
    public void onEnable() {
        fourthRealmCore = (FourthRealmCore) this.getServer().getPluginManager().getPlugin("FourthRealmCore");

        getServer().getPluginManager().registerEvents(new ExpChangeListener(this), this);
        getServer().getPluginManager().registerEvents(new LevelDisplayManager(), this);

        // Plugin startup logic

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
