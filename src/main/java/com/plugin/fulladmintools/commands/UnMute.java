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
public class UnMute implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (args.length < 1) {
            sender.sendMessage(ChatColor.RED + "You must specify a player");
            return false;
        }

        Player player = sender.getServer().getPlayerExact(args[0]);

        OtherUtilitys muteUtility = new OtherUtilitys();

        if (!muteUtility.isPlayerMuted(player)) {
            sender.sendMessage(ChatColor.GREEN + "This player is already unmuted");
            return false;
        }

        muteUtility.unmutePlayer(player);

        return true;
    }
}
