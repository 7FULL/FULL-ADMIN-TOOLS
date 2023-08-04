package com.plugin.fulladmintools.listeneres;

import com.plugin.fulladmintools.AdminToolsPlugin;
import com.plugin.fulladmintools.utility.MenuManager;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

/*
 *
 *@author Pablo Hermida Gómez DAM G1
 *
 */
public class MenuListener implements Listener {

    private AdminToolsPlugin plugin;

    public MenuListener(){
        plugin = AdminToolsPlugin.getPlugin();
    }

    @EventHandler
    public void onMenuClick(InventoryClickEvent e){
        MenuManager menuManager = new MenuManager((Player)e.getWhoClicked());
        Player player = (Player) e.getWhoClicked();

        String title = e.getView().getTitle();
        //Blocks moving objects if the menu is the AdminMainMenu
        if (title.equalsIgnoreCase("AdminMainMenu") || title.equalsIgnoreCase("BanMenu")
                || title.equalsIgnoreCase("KickMenu") || title.equalsIgnoreCase("FreezeMenu")){
            Material item = e.getCurrentItem().getType();

            //Close button
            if(item == Material.BARRIER){
                player.closeInventory();
            }

            //Ban button
            if(item == Material.WOODEN_AXE){
                player.closeInventory();
                Inventory banMenu = menuManager.getBanMenu();
                player.openInventory(banMenu);
            }

            //Kick button
            if(item == Material.IRON_AXE){

            }

            //Freeze button
            if(item == Material.PACKED_ICE){

            }

            //BanMenu
            if(title.equalsIgnoreCase("BanMenu")){
                //Ban button
                if(item == Material.BARRIER){
                    player.closeInventory();
                    Inventory mainMenu = menuManager.getMainMenu();
                    player.openInventory(mainMenu);
                }

                //Ban button
                if(item == Material.PLAYER_HEAD){
                    String banPlayer = e.getCurrentItem().getItemMeta().getDisplayName();

                    Player playerToBan = plugin.getServer().getPlayerExact(banPlayer);

                    playerToBan.sendMessage("You have been banned from the server");

                    playerToBan.kickPlayer("You have been banned from the server");

                    plugin.getServer().banIP(playerToBan.getAddress().getAddress().getHostAddress());
                }
            }

            e.setCancelled(true);
        }
    }
}
