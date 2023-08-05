package com.plugin.fulladmintools.commands;

import com.plugin.fulladmintools.utility.OtherUtilitys;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/*
 *
 *@author Pablo Hermida Gómez DAM G1
 *
 */
public class UnFreeze implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] strings) {
        //We check if it has parameters
        if (strings.length < 1){
            sender.sendMessage("You need to specify a player");
            return true;
        }

        //We check if the player is online
        if (sender.getServer().getPlayerExact(strings[0]) == null){
            sender.sendMessage("This player is not online");
            return true;
        }

        Player playerToFreeze = sender.getServer().getPlayerExact(strings[0]);

        //We check if the player is already frozen
        if(!OtherUtilitys.isPlayerFrozen(playerToFreeze)){
            sender.sendMessage("This player is already unfrozen");
            return true;
        }else{
            //We unfreeze the player
            OtherUtilitys.unfreezePlayer(playerToFreeze);
        }

        return true;
    }
}
