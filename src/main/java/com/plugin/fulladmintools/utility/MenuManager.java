package com.plugin.fulladmintools.utility;

import com.plugin.fulladmintools.menus.BanMenu;
import com.plugin.fulladmintools.menus.MainMenu;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

/*
 *
 *@author Pablo Hermida Gómez DAM G1
 *
 */
public class MenuManager {

    private static Player player;

    //Im retarded X3
    public MenuManager(Player player){
        this.player = player;
    }


    public Inventory getMainMenu(){
        MainMenu mainMenu = new MainMenu();
        return mainMenu.getMainMenu(player);
    }

    public Inventory getBanMenu(){
        BanMenu banMenu = new BanMenu();
        return banMenu.getBanMenu(player);
    }

    public Inventory getBanListMenu(String title){
        BanMenu banMenu = new BanMenu();
        return banMenu.getBanListMenu(player, title);
    }

    public Inventory getListMenu(String title, boolean freezed){
        BanMenu banMenu = new BanMenu();
        if (freezed){
            return banMenu.getFreezeMenu(player, title);
        }
        return banMenu.getOnlinePlayersMenu(player, title);
    }

    public Inventory getUnMuteMenu(String title){
        BanMenu banMenu = new BanMenu();
        return banMenu.getMuteMenu(player, title);
    }

    public Inventory getMuteMenu(String title){
        BanMenu banMenu = new BanMenu();
        return banMenu.getOnlinePlayersMenu(player, title, true);
    }

}
