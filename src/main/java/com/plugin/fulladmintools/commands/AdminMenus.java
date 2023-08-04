package com.plugin.fulladmintools.commands;

import com.plugin.fulladmintools.utility.MenuManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

/*
 *
 *@author Pablo Hermida Gómez DAM G1
 *
 */
public class AdminMenus implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] strings) {
        //We check if the player has op and is a player
        if (sender instanceof Player){
            Player player = (Player) sender;

            MenuManager menuManager = new MenuManager(player);
            if (player.isOp()) {
                Inventory inv = menuManager.getMainMenu();
                player.openInventory(inv);
            }else{
                player.sendMessage("You don't have permission to use this command");
            }
        }else{
            sender.sendMessage("You are writing from the console");
        }

        return true;
    }
}
