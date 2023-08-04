package com.plugin.fulladmintools.commands;

import com.plugin.fulladmintools.AdminToolsPlugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/*
 *
 *@author Pablo Hermida Gómez DAM G1
 *
 */
public class Ban implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] strings) {
        //We check if it has parameters
        if (strings.length == 0){
            sender.sendMessage("You need to specify a ip");
            return true;
        }

        //We check if the player is actually banned
        if (sender.getServer().getIPBans().contains(strings[0])){
            sender.sendMessage("This ip is already banned");
            return true;
        }

        //We ban the ip
        Player player = AdminToolsPlugin.getPlugin().getServer().getPlayerExact(strings[0]);
        sender.getServer().banIP(player.getAddress().getAddress().getHostAddress());

        return true;
    }
}
