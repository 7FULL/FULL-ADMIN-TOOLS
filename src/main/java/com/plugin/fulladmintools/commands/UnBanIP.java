package com.plugin.fulladmintools.commands;

import com.plugin.fulladmintools.AdminToolsPlugin;
import com.plugin.fulladmintools.utility.BanManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

/*
 *
 *@author Pablo Hermida Gómez DAM G1
 *
 */
public class UnBanIP implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] strings) {
        //We check if it has parameters
        if (strings.length < 1){
            sender.sendMessage("You need to specify an ip or a player");
            return true;
        }

        //We unban the ip
        BanManager banManager = new BanManager(AdminToolsPlugin.getPlugin());

        boolean aux = banManager.checkBan(strings[0]);

        if (!aux){
            sender.sendMessage("This player is not banned");
            return true;
        }else{
            boolean x = banManager.unBanIP(strings[0]);

            if (!x){
                sender.sendMessage("We couldn't unban the player");
                return true;
            }
        }

        return true;
    }
}
