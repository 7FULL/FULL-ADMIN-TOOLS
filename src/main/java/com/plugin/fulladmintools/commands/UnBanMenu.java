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
public class UnBanMenu implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] strings) {
        Player player = (Player) sender;

        MenuManager menuManager = new MenuManager(player);
        Inventory banMenu = menuManager.getBanListMenu("UnbanMenu");
        player.closeInventory();
        player.openInventory(banMenu);

        return true;
    }
}
