package me.shadow_warrior_.spawnplugin.commands;

import me.shadow_warrior_.spawnplugin.SpawnPlugin;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetSpawnCommand implements CommandExecutor {
    //passing the instance of the plugin to the class
    private final SpawnPlugin plugin;

    public SetSpawnCommand(SpawnPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player){
            Player player = (Player) sender;
            // Different way
            //set the spawn location in the config.yml
//            spawnPlugin.getConfig().set("spawn.x", location.getX());
//            spawnPlugin.getConfig().set("spawn.y", location.getY());
//            spawnPlugin.getConfig().set("spawn.z", location.getZ());

            //get the players location
            Location location = player.getLocation();
            //A Location is a special type of object that can be saved to a config.yml automatically by bukkit
            //This is because it implements ConfigurationSerializable
            plugin.getConfig().set("spawn", location); // saving sour location into config.yml

            plugin.saveConfig();

            player.sendMessage("Spawn location set");
        }

        return true;
    }
}
