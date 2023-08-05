package com.plugin.fulladmintools.commands;

import com.plugin.fulladmintools.AdminToolsPlugin;
import com.plugin.fulladmintools.utility.BanManager;
import com.plugin.fulladmintools.utility.MenuManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

/*
 *
 *@author Pablo Hermida Gómez DAM G1
 *
 */
public class BanList implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] strings) {
        //We check if the player has op and is a player
        if (sender.isOp() && sender instanceof ConsoleCommandSender){
            AdminToolsPlugin plugin = AdminToolsPlugin.getPlugin();
            BanManager banManager = new BanManager(plugin);
            banManager.banList();
            return true;
        }
        if (sender instanceof Player && sender.isOp()) {
            System.out.println("You don't have permission to use this command");

            Player player = (Player) sender;

            MenuManager menuManager = new MenuManager(player);

            Inventory inv = menuManager.getBanListMenu("BanListMenu");
            player.closeInventory();
            player.openInventory(inv);
        }

        return true;
    }
}
