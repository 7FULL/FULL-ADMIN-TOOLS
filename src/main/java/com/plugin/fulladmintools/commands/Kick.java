package com.plugin.fulladmintools.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/*
 *
 *@author Pablo Hermida Gómez DAM G1
 *
 */
public class Kick implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] strings) {
        //We check if it has parameters
        if (strings.length < 2){
            sender.sendMessage("You need to specify a player and a reason");
            return true;
        }

        //We check if the player is online
        if (sender.getServer().getPlayerExact(strings[0]) == null){
            sender.sendMessage("This player is not online");
            return true;
        }

        sender.getServer().getPlayerExact(strings[0]).kickPlayer(strings[1]);

        return true;
    }
}
