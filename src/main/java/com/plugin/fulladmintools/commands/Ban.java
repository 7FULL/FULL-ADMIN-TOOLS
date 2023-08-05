package com.plugin.fulladmintools.commands;

import com.plugin.fulladmintools.AdminToolsPlugin;
import com.plugin.fulladmintools.utility.BanManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Date;

/*
 *
 *@author Pablo Hermida Gómez DAM G1
 *
 */
public class Ban implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] strings) {
        //We check if it has parameters
        if (strings.length < 2){
            sender.sendMessage("You need to specify a player and a reason");
            return true;
        }

        //We ban the ip
        BanManager banManager = new BanManager(AdminToolsPlugin.getPlugin());

        boolean aux = banManager.checkBan(strings[0]);

        if (aux){
            sender.sendMessage("This player is already banned");
            return true;
        }else{
            if (strings.length == 3){
                //We parse the 3 argument to a date
                Date date;
                try {
                    date = new Date(strings[2]);
                }catch (Exception e){
                    sender.sendMessage("The date is not valid");
                    return true;
                }

                boolean x = banManager.ban(strings[0], strings[1], date);

                if (!x){
                    sender.sendMessage("We couldn't ban the player");
                    return true;
                }
            }

            boolean x = banManager.ban(strings[0], strings[1]);

            if (!x){
                sender.sendMessage("We couldn't ban the player");
                return true;
            }
        }

        return true;
    }
}
