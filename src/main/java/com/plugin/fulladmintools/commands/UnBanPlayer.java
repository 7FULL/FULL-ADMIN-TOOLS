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
public class UnBanPlayer implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] strings) {

        //We check if it has parameters
        if (strings.length == 0){
            sender.sendMessage("You need to specify a player");
            return true;
        }

        //We check if the player has op
        if (sender.isOp()){
            AdminToolsPlugin plugin = AdminToolsPlugin.getPlugin();
            BanManager banManager = new BanManager(plugin);

            boolean aux = banManager.checkBan(strings[0]);

            if (!aux){
                sender.sendMessage("This player is not banned");
                return true;
            }

            banManager.unBan(strings[0]);
        }

        return true;
    }
}
