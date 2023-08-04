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
public class BanList implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] strings) {
        //We check if the player has op and is a player
        if (sender.isOp()){
            AdminToolsPlugin plugin = AdminToolsPlugin.getPlugin();
            plugin.getServer().getIPBans().forEach((ip) -> {
                System.out.println(ip);
            });
        }

        return true;
    }
}
