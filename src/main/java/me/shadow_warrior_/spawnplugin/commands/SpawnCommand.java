package me.shadow_warrior_.spawnplugin.commands;

import me.shadow_warrior_.spawnplugin.SpawnPlugin;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpawnCommand implements CommandExecutor {
    private final SpawnPlugin plugin;

    public SpawnCommand(SpawnPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player){
            Player player = (Player) sender;
            Location location = plugin.getConfig().getLocation("spawn");

            if (location != null){
                player.teleport(location);
                player.sendMessage("You have been teleported to the spawn point");
            }else player.sendMessage("There is not spawn point set");

        }

        return true;
    }
}
