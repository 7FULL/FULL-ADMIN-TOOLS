package com.plugin.fulladmintools.commands;

import com.plugin.fulladmintools.AdminToolsPlugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

/*
 *
 *@author Pablo Hermida Gómez DAM G1
 *
 */
public class UnBanPlayer implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] strings) {

        //We check if it has parameters
        if (strings.length == 0){
            sender.sendMessage("You need to specify a ip");
            return true;
        }

        //We check if the player is actually banned
        if (!AdminToolsPlugin.getPlugin().getServer().getIPBans().contains(strings[0])){
            sender.sendMessage("This ip is not banned");
            return true;
        }

        //We check if the player has op and is a player
        if (sender.isOp()){
            AdminToolsPlugin plugin = AdminToolsPlugin.getPlugin();
            plugin.getServer().unbanIP(strings[0]);
        }

        return true;
    }
}
