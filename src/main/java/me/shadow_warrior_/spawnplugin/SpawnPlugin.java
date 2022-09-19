package me.shadow_warrior_.spawnplugin;

import me.shadow_warrior_.spawnplugin.commands.SetSpawnCommand;
import me.shadow_warrior_.spawnplugin.commands.SpawnCommand;
import me.shadow_warrior_.spawnplugin.listeners.SpawnListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class SpawnPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // config.yml
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        getCommand("setspawn").setExecutor(new SetSpawnCommand(this));
        getCommand("spawn").setExecutor(new SpawnCommand(this));
        getServer().getPluginManager().registerEvents(new SpawnListener(this),this);
    }


}
