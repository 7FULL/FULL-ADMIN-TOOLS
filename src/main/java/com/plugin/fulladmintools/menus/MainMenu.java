package com.plugin.fulladmintools.menus;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

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

        ArrayList<String> closeLore = new ArrayList<>();
        closeLore.add("");
        closeLore.add(ChatColor.WHITE + "Close this menu");
        closeMeta.setLore(closeLore);
        close.setItemMeta(closeMeta);

        //Ban button
        ItemStack ban = new ItemStack(Material.WOODEN_AXE, 1);
        ItemMeta banMeta = ban.getItemMeta();
        banMeta.setDisplayName(ChatColor.DARK_RED + "Ban menu");

        ArrayList<String> banLore = new ArrayList<>();
        banLore.add("");
        banLore.add(ChatColor.WHITE + "Ban a player");
        banMeta.setLore(banLore);
        ban.setItemMeta(banMeta);

        //Unban button
        ItemStack unban = new ItemStack(Material.STONE_AXE, 1);
        ItemMeta unbanMeta = unban.getItemMeta();
        unbanMeta.setDisplayName(ChatColor.RED + "Unban menu");

        ArrayList<String> unbanLore = new ArrayList<>();
        unbanLore.add("");
        unbanLore.add(ChatColor.WHITE + "Unban a player");
        unbanMeta.setLore(unbanLore);

        unban.setItemMeta(unbanMeta);

        //Kick button
        ItemStack kick = new ItemStack(Material.IRON_AXE, 1);
        ItemMeta kickMeta = kick.getItemMeta();
        kickMeta.setDisplayName(ChatColor.GOLD + "Kick menu");

        ArrayList<String> kickLore = new ArrayList<>();
        kickLore.add("");
        kickLore.add(ChatColor.WHITE + "Kick a player");
        kickMeta.setLore(kickLore);
        kick.setItemMeta(kickMeta);

        //Freeze button
        ItemStack freeze = new ItemStack(Material.PACKED_ICE, 1);
        ItemMeta freezeMeta = freeze.getItemMeta();
        freezeMeta.setDisplayName(ChatColor.DARK_BLUE + "Freeze menu");

        ArrayList<String> freezeLore = new ArrayList<>();
        freezeLore.add("");
        freezeLore.add(ChatColor.WHITE + "Freeze a player");
        freezeMeta.setLore(freezeLore);

        freeze.setItemMeta(freezeMeta);

        //Mute button
        ItemStack mute = new ItemStack(Material.BOOK, 1);
        ItemMeta muteMeta = mute.getItemMeta();
        muteMeta.setDisplayName(ChatColor.DARK_GREEN + "Mute menu");

        ArrayList<String> muteLore = new ArrayList<>();
        muteLore.add("");
        muteLore.add(ChatColor.WHITE + "Mute a player");
        muteMeta.setLore(muteLore);

        mute.setItemMeta(muteMeta);

        //Unmute button
        ItemStack unmute = new ItemStack(Material.ENCHANTED_BOOK, 1);
        ItemMeta unmuteMeta = unmute.getItemMeta();
        unmuteMeta.setDisplayName(ChatColor.GREEN + "Unmute menu");

        ArrayList<String> unmuteLore = new ArrayList<>();
        unmuteLore.add("");
        unmuteLore.add(ChatColor.WHITE + "Unmute a player");
        unmuteMeta.setLore(unmuteLore);

        unmute.setItemMeta(unmuteMeta);

        inv.setItem(8, close);
        inv.setItem(0, ban);
        inv.setItem(2, kick);
        inv.setItem(4, freeze);
        inv.setItem(1, unban);
        inv.setItem(6, mute);
        inv.setItem(7, unmute);

        return inv;
    }
}
