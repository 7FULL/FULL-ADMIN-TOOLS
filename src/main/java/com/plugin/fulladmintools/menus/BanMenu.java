package com.plugin.fulladmintools.menus;

import com.plugin.fulladmintools.utility.OtherUtilitys;
import org.bukkit.BanList;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Date;

/*
 *
 *@author Pablo Hermida Gómez DAM G1
 *
 */
    public class BanMenu {

        public Inventory getBanMenu(Player player){
            final int INVENTORY_SIZE = 45;

            Inventory inv = player.getServer().createInventory(null, INVENTORY_SIZE+9, "BanMenu");

            Player[] players = player.getServer().getOnlinePlayers().toArray(new Player[0]);

            if (players.length>INVENTORY_SIZE){
                //In the future we will make pagination in this inventory
            }

            int aux = INVENTORY_SIZE;

            //Im retarded X4
            if (INVENTORY_SIZE > players.length){
                aux = players.length;
            }
            for (int i = 0; i < aux; i++) {
                ItemStack item = new ItemStack(Material.PLAYER_HEAD, 1);

                String name = players[i].getDisplayName();
                int health = (int) players[i].getHealth();
                int food = players[i].getFoodLevel();
                int xp = players[i].getLevel();
                int kills = players[i].getStatistic(org.bukkit.Statistic.PLAYER_KILLS);
                int deaths = players[i].getStatistic(org.bukkit.Statistic.DEATHS);

                ItemMeta itemMeta = item.getItemMeta();
                itemMeta.setDisplayName(name);
                ArrayList<String> lore = new ArrayList<>();
                lore.add(ChatColor.RED + "Health: " + health);
                lore.add(ChatColor.GOLD + "Food: " + food);
                lore.add(ChatColor.GREEN + "XP: " + xp);
                lore.add(ChatColor.DARK_RED + "Kills: " + kills);
                lore.add(ChatColor.AQUA + "Deaths: " + deaths);

                itemMeta.setLore(lore);
                item.setItemMeta(itemMeta);
                inv.setItem(i, item);
            }

            //Back button
            ItemStack back = new ItemStack(Material.BARRIER, 1);
            ItemMeta backMeta = back.getItemMeta();
            backMeta.setDisplayName(ChatColor.RED + "Back");
            back.setItemMeta(backMeta);

            //Decoration
            ItemStack panel = new ItemStack(Material.RED_STAINED_GLASS_PANE, 1);
            ItemMeta panelMeta = panel.getItemMeta();
            panelMeta.setDisplayName(" ");
            panel.setItemMeta(panelMeta);

            //Ban list button
            ItemStack banList = new ItemStack(Material.BOOK, 1);
            ItemMeta banListMeta = banList.getItemMeta();
            banListMeta.setDisplayName(ChatColor.DARK_RED + "Ban list");
            banList.setItemMeta(banListMeta);

            inv.setItem(INVENTORY_SIZE+8, panel);
            inv.setItem(INVENTORY_SIZE+7, panel);
            inv.setItem(INVENTORY_SIZE+6, panel);
            inv.setItem(INVENTORY_SIZE+5, panel);
            inv.setItem(INVENTORY_SIZE+4, back);
            inv.setItem(INVENTORY_SIZE+3, panel);
            inv.setItem(INVENTORY_SIZE+2, panel);
            inv.setItem(INVENTORY_SIZE+1, panel);
            inv.setItem(INVENTORY_SIZE, banList);


            return inv;
        }

        public Inventory getBanListMenu(Player player, String title){
            final int INVENTORY_SIZE = 45;

            Inventory inv = player.getServer().createInventory(null, INVENTORY_SIZE+9, title);

            //We read the ban list and we put it in the inventory
            player.getServer().getBanList(BanList.Type.NAME).getBanEntries().forEach(banEntry -> {
                ItemStack item = new ItemStack(Material.PLAYER_HEAD, 1);

                String name = banEntry.getTarget();
                String reason = banEntry.getReason();
                String source = banEntry.getSource();
                Date expiration = banEntry.getExpiration();

                ItemMeta itemMeta = item.getItemMeta();
                itemMeta.setDisplayName(name);
                ArrayList<String> lore = new ArrayList<>();
                lore.add(ChatColor.RED + "Reason: " + reason);
                lore.add(ChatColor.GOLD + "Source: " + source);
                lore.add(ChatColor.GREEN + "Expiration: " + expiration);

                itemMeta.setLore(lore);
                item.setItemMeta(itemMeta);
                inv.addItem(item);
            });


            //Back button
            ItemStack back = new ItemStack(Material.BARRIER, 1);
            ItemMeta backMeta = back.getItemMeta();
            backMeta.setDisplayName(ChatColor.RED + "Back");
            back.setItemMeta(backMeta);

            //Decoration
            ItemStack panel = new ItemStack(Material.RED_STAINED_GLASS_PANE, 1);
            ItemMeta panelMeta = panel.getItemMeta();
            panelMeta.setDisplayName(" ");
            panel.setItemMeta(panelMeta);

            inv.setItem(INVENTORY_SIZE+8, panel);
            inv.setItem(INVENTORY_SIZE+7, panel);
            inv.setItem(INVENTORY_SIZE+6, panel);
            inv.setItem(INVENTORY_SIZE+5, panel);
            inv.setItem(INVENTORY_SIZE+4, back);
            inv.setItem(INVENTORY_SIZE+3, panel);
            inv.setItem(INVENTORY_SIZE+2, panel);
            inv.setItem(INVENTORY_SIZE+1, panel);
            inv.setItem(INVENTORY_SIZE, panel);

            return inv;
        }

        public Inventory getFreezeMenu(Player player, String title){
            final int INVENTORY_SIZE = 45;

            ArrayList<String> frozenPlayers = OtherUtilitys.frozenPlayers;

            Inventory inv = player.getServer().createInventory(null, INVENTORY_SIZE+9, title);

            //We get the online players and add them to the inventory

            int aux = INVENTORY_SIZE;

            //We get the online players
            Player[] players = player.getServer().getOnlinePlayers().toArray(new Player[0]);

            if (INVENTORY_SIZE > players.length){
                aux = players.length;
            }

            for (int i = 0; i < aux; i++){

                //If the player is frozen we add a frozen icon
                ItemStack item;
                if (frozenPlayers.contains(players[i].getDisplayName())){
                    item = new ItemStack(Material.ICE, 1);
                }else{
                    item = new ItemStack(Material.PLAYER_HEAD, 1);
                }

                String name = players[i].getDisplayName();
                int health = (int) players[i].getHealth();
                int food = players[i].getFoodLevel();
                int xp = players[i].getLevel();
                int kills = players[i].getStatistic(org.bukkit.Statistic.PLAYER_KILLS);
                int deaths = players[i].getStatistic(org.bukkit.Statistic.DEATHS);

                ItemMeta itemMeta = item.getItemMeta();
                itemMeta.setDisplayName(name);
                ArrayList<String> lore = new ArrayList<>();
                lore.add(ChatColor.RED + "Health: " + health);
                lore.add(ChatColor.GOLD + "Food: " + food);
                lore.add(ChatColor.GREEN + "XP: " + xp);
                lore.add(ChatColor.DARK_RED + "Kills: " + kills);
                lore.add(ChatColor.AQUA + "Deaths: " + deaths);

                itemMeta.setLore(lore);
                item.setItemMeta(itemMeta);
                inv.setItem(i, item);
            }


            //Back button
            ItemStack back = new ItemStack(Material.BARRIER, 1);
            ItemMeta backMeta = back.getItemMeta();
            backMeta.setDisplayName(ChatColor.RED + "Back");
            back.setItemMeta(backMeta);

            //Decoration
            ItemStack panel = new ItemStack(Material.RED_STAINED_GLASS_PANE, 1);
            ItemMeta panelMeta = panel.getItemMeta();
            panelMeta.setDisplayName(" ");
            panel.setItemMeta(panelMeta);

            inv.setItem(INVENTORY_SIZE+8, panel);
            inv.setItem(INVENTORY_SIZE+7, panel);
            inv.setItem(INVENTORY_SIZE+6, panel);
            inv.setItem(INVENTORY_SIZE+5, panel);
            inv.setItem(INVENTORY_SIZE+4, back);
            inv.setItem(INVENTORY_SIZE+3, panel);
            inv.setItem(INVENTORY_SIZE+2, panel);
            inv.setItem(INVENTORY_SIZE+1, panel);
            inv.setItem(INVENTORY_SIZE, panel);

            return inv;
        }

        public Inventory getOnlinePlayersMenu(Player player, String title){
        final int INVENTORY_SIZE = 45;

        Inventory inv = player.getServer().createInventory(null, INVENTORY_SIZE+9, title);

        //We get the online players and add them to the inventory

        int aux = INVENTORY_SIZE;

        //We get the online players
        Player[] players = player.getServer().getOnlinePlayers().toArray(new Player[0]);

        if (INVENTORY_SIZE > players.length){
            aux = players.length;
        }

        for (int i = 0; i < aux; i++){
            ItemStack item = new ItemStack(Material.PLAYER_HEAD, 1);

            String name = players[i].getDisplayName();
            int health = (int) players[i].getHealth();
            int food = players[i].getFoodLevel();
            int xp = players[i].getLevel();
            int kills = players[i].getStatistic(org.bukkit.Statistic.PLAYER_KILLS);
            int deaths = players[i].getStatistic(org.bukkit.Statistic.DEATHS);

            ItemMeta itemMeta = item.getItemMeta();
            itemMeta.setDisplayName(name);
            ArrayList<String> lore = new ArrayList<>();
            lore.add(ChatColor.RED + "Health: " + health);
            lore.add(ChatColor.GOLD + "Food: " + food);
            lore.add(ChatColor.GREEN + "XP: " + xp);
            lore.add(ChatColor.DARK_RED + "Kills: " + kills);
            lore.add(ChatColor.AQUA + "Deaths: " + deaths);

            itemMeta.setLore(lore);
            item.setItemMeta(itemMeta);
            inv.setItem(i, item);
        }


        //Back button
        ItemStack back = new ItemStack(Material.BARRIER, 1);
        ItemMeta backMeta = back.getItemMeta();
        backMeta.setDisplayName(ChatColor.RED + "Back");
        back.setItemMeta(backMeta);

        //Decoration
        ItemStack panel = new ItemStack(Material.RED_STAINED_GLASS_PANE, 1);
        ItemMeta panelMeta = panel.getItemMeta();
        panelMeta.setDisplayName(" ");
        panel.setItemMeta(panelMeta);

        inv.setItem(INVENTORY_SIZE+8, panel);
        inv.setItem(INVENTORY_SIZE+7, panel);
        inv.setItem(INVENTORY_SIZE+6, panel);
        inv.setItem(INVENTORY_SIZE+5, panel);
        inv.setItem(INVENTORY_SIZE+4, back);
        inv.setItem(INVENTORY_SIZE+3, panel);
        inv.setItem(INVENTORY_SIZE+2, panel);
        inv.setItem(INVENTORY_SIZE+1, panel);
        inv.setItem(INVENTORY_SIZE, panel);

        return inv;
    }
}
