package me.shadow_warrior_.spawnplugin.listeners;

import me.shadow_warrior_.spawnplugin.SpawnPlugin;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

public class SpawnListener implements Listener {
    private final SpawnPlugin plugin;

    public SpawnListener(SpawnPlugin plugin) {
        this.plugin = plugin;
    }
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){
        Player player = e.getPlayer();
        if (!player.hasPlayedBefore()) {
            Location location = plugin.getConfig().getLocation("spawn");

            if (location != null) {
                player.teleport(location);
            }
        }

    }

    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent e){

            Location location = plugin.getConfig().getLocation("spawn");

            if (location != null) {
                e.setRespawnLocation(location);
            }
    }

}
