package com.plugin.fulladmintools.listeneres;

import com.plugin.fulladmintools.AdminToolsPlugin;
import com.plugin.fulladmintools.utility.BanManager;
import com.plugin.fulladmintools.utility.MenuManager;
import com.plugin.fulladmintools.utility.OtherUtilitys;
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
                || title.equalsIgnoreCase("KickMenu") || title.equalsIgnoreCase("FreezeMenu")
                || title.equalsIgnoreCase("UnbanMenu") || title.equalsIgnoreCase("BanListMenu")) {
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

            //Unban button
            if(item == Material.STONE_AXE){
                player.closeInventory();
                Inventory unbanMenu = menuManager.getBanListMenu("UnbanMenu");
                player.openInventory(unbanMenu);
            }

            //Kick button
            if(item == Material.IRON_AXE){
                player.closeInventory();
                Inventory unbanMenu = menuManager.getListMenu("KickMenu", false);
                player.openInventory(unbanMenu);
            }

            //Freeze button
            if(item == Material.PACKED_ICE){
                player.closeInventory();
                Inventory unbanMenu = menuManager.getListMenu("FreezeMenu", true);
                player.openInventory(unbanMenu);
            }

            //<<<<<<<<<<<<<<<<MENUS>>>>>>>>>>>>>>>>>>>>>

            //region Menus

            //BanMenu
            if(title.equalsIgnoreCase("BanMenu")){
                //Back button
                if(item == Material.BARRIER){
                    player.closeInventory();
                    Inventory mainMenu = menuManager.getMainMenu();
                    player.openInventory(mainMenu);
                }

                //Ban button
                if(item == Material.PLAYER_HEAD){
                    String banPlayer = e.getCurrentItem().getItemMeta().getDisplayName();

                    BanManager banManager = new BanManager(plugin);

                    banManager.ban(banPlayer, "Default ban messagge", null);

                    e.getInventory().removeItem(e.getCurrentItem());
                }

                //Banlist button
                if(item == Material.BOOK){
                    player.closeInventory();
                    Inventory banListMenu = menuManager.getBanListMenu("BanListMenu");
                    player.openInventory(banListMenu);
                }
            }


            //Menu BanList
            else if (title.equalsIgnoreCase("BanListMenu")) {
                //Back button
                if (item == Material.BARRIER) {
                    player.closeInventory();
                    Inventory mainMenu = menuManager.getMainMenu();
                    player.openInventory(mainMenu);
                }
            }


            //Menu Unban
            else if (title.equalsIgnoreCase("UnbanMenu")) {
                //Back button
                if (item == Material.BARRIER) {
                    player.closeInventory();
                    Inventory mainMenu = menuManager.getMainMenu();
                    player.openInventory(mainMenu);
                }

                //Unban button
                if (item == Material.PLAYER_HEAD) {
                    String unbanPlayer = e.getCurrentItem().getItemMeta().getDisplayName();

                    BanManager banManager = new BanManager(plugin);

                    banManager.unBan(unbanPlayer);

                    e.getInventory().removeItem(e.getCurrentItem());
                }
            }


            //FreezeMenu
            else if (title.equalsIgnoreCase("FreezeMenu")) {
                //Back button
                if (item == Material.BARRIER) {
                    player.closeInventory();
                    Inventory mainMenu = menuManager.getMainMenu();
                    player.openInventory(mainMenu);
                }

                //Freeze button
                if (item == Material.PLAYER_HEAD || item == Material.ICE) {
                    String freezePlayer = e.getCurrentItem().getItemMeta().getDisplayName();
                    Player freezePlayerObj = plugin.getServer().getPlayerExact(freezePlayer);



                    if (item == Material.PLAYER_HEAD) {
                        OtherUtilitys.freezePlayer(freezePlayerObj);
                        e.getInventory().setItem(e.getSlot(), OtherUtilitys.getFreezeHead(freezePlayerObj.getDisplayName()));
                    }else{
                        OtherUtilitys.unfreezePlayer(freezePlayerObj);
                        e.getInventory().setItem(e.getSlot(), OtherUtilitys.getUnfreezeHead(freezePlayerObj.getDisplayName()));
                    }
                }
            }


            //KickMenu
            else if (title.equalsIgnoreCase("KickMenu")) {
                //Back button
                if (item == Material.BARRIER) {
                    player.closeInventory();
                    Inventory mainMenu = menuManager.getMainMenu();
                    player.openInventory(mainMenu);
                }

                //Kick button
                if (item == Material.PLAYER_HEAD) {
                    String kickPlayer = e.getCurrentItem().getItemMeta().getDisplayName();
                    Player kickPlayerObj = plugin.getServer().getPlayerExact(kickPlayer);

                    OtherUtilitys.kickPlayer(kickPlayerObj, "Default kick messagge");

                    e.getInventory().removeItem(e.getCurrentItem());
                }
            }


            //Menu BanList
            else if (title.equalsIgnoreCase("BanListMenu")) {
                //Back button
                if (item == Material.BARRIER) {
                    player.closeInventory();
                    Inventory mainMenu = menuManager.getMainMenu();
                    player.openInventory(mainMenu);
                }
            }
            //endregion

            e.setCancelled(true);
        }
    }
}
