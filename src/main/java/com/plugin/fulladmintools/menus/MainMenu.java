package com.plugin.fulladmintools.menus;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

/*
 *
 *@author Pablo Hermida Gómez DAM G1
 *
 */
public class MainMenu {

    public Inventory getMainMenu(Player player){
        Inventory inv = player.getServer().createInventory(null, 9, "AdminMainMenu");

        //Close button
        ItemStack close = new ItemStack(Material.BARRIER, 1);
        ItemMeta closeMeta = close.getItemMeta();
        closeMeta.setDisplayName(ChatColor.RED + "Close menu");
        close.setItemMeta(closeMeta);

        //Ban button
        ItemStack ban = new ItemStack(Material.WOODEN_AXE, 1);
        ItemMeta banMeta = ban.getItemMeta();
        banMeta.setDisplayName(ChatColor.DARK_RED + "Ban menu");
        ban.setItemMeta(banMeta);

        //Kick button
        ItemStack kick = new ItemStack(Material.IRON_AXE, 1);
        ItemMeta kickMeta = kick.getItemMeta();
        kickMeta.setDisplayName(ChatColor.GOLD + "Kick menu");
        kick.setItemMeta(kickMeta);

        //Freeze button
        ItemStack freeze = new ItemStack(Material.PACKED_ICE, 1);
        ItemMeta freezeMeta = freeze.getItemMeta();
        freezeMeta.setDisplayName(ChatColor.DARK_BLUE + "Freeze menu");
        freeze.setItemMeta(freezeMeta);

        inv.setItem(8, close);
        inv.setItem(0, ban);
        inv.setItem(2, kick);
        inv.setItem(4, freeze);

        return inv;
    }
}
