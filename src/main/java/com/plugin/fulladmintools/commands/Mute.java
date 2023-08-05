package com.plugin.fulladmintools.commands;

import com.plugin.fulladmintools.utility.OtherUtilitys;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/*
 *
 *@author Pablo Hermida Gómez DAM G1
 *
 */
public class Mute implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (args.length < 2) {
            sender.sendMessage(ChatColor.RED + "You must specify a player and how many hours you want to mute the player");
            return true;
        }

        Player player = sender.getServer().getPlayerExact(args[0]);

        //We check if the player is online
        if (player == null) {
            sender.sendMessage(ChatColor.RED + "This player is not online");
            return true;
        }

        OtherUtilitys muteUtility = new OtherUtilitys();

        OtherUtilitys.checkMutedPlayer(player);

        int hours = 0;

        try {
            hours = Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            sender.sendMessage(ChatColor.RED + "Number not valid! You must specify a number of hours");
            return true;
        }


        if (muteUtility.isPlayerMuted(player)) {
            sender.sendMessage(ChatColor.GREEN + "This player is already muted");
            return true;
        }

        muteUtility.mutePlayer(player, hours);

        return true;
    }
}
