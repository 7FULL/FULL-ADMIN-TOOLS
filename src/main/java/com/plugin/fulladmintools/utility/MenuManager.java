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


    public static Inventory getMainMenu(){
        MainMenu mainMenu = new MainMenu();
        return mainMenu.getMainMenu(player);
    }

    public static Inventory getBanMenu(){
        BanMenu banMenu = new BanMenu();
        return banMenu.getBanMenu(player);
    }

}
