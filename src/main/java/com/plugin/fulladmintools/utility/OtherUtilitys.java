package com.plugin.fulladmintools.utility;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;

/*
 *
 *@author Pablo Hermida Gómez DAM G1
 *
 */
public class OtherUtilitys {

    public static ArrayList<String> frozenPlayers = new ArrayList<String>();

    //This method freeze the player
    public static void freezePlayer(Player player){
        player.addPotionEffect(PotionEffectType.SLOW.createEffect(1000000, 255));

        frozenPlayers.add(player.getDisplayName());
    }

    //This method unfreeze the player
    public static void unfreezePlayer(Player player){
        //Unfreeze the player
        player.removePotionEffect(PotionEffectType.SLOW);

        frozenPlayers.remove(player);
    }

    //This method checks if the player is frozen
    public static boolean isPlayerFrozen(Player player){
        if(player.getWalkSpeed() == 0 && player.getFlySpeed() == 0 && !player.getAllowFlight() && !player.isFlying() && !player.hasGravity()){
            return true;
        }else{
            return false;
        }
    }

    //This method kicks the player
    public static void kickPlayer(Player player, String reason){
        player.kickPlayer(reason);
    }

    //This methos returns a "frozen" head
    public static ItemStack getFreezeHead(String playerName){
        ItemStack freezeHead = new ItemStack(Material.ICE, 1);
        ItemMeta freezeHeadMeta = freezeHead.getItemMeta();
        freezeHeadMeta.setDisplayName(playerName);
        freezeHead.setItemMeta(freezeHeadMeta);

        return freezeHead;
    }

    //This method returns a "unfrozen" head
    public static ItemStack getUnfreezeHead(String playerName){
        ItemStack unfreezeHead = new ItemStack(Material.PLAYER_HEAD, 1);
        ItemMeta unfreezeHeadMeta = unfreezeHead.getItemMeta();
        unfreezeHeadMeta.setDisplayName(playerName);
        unfreezeHead.setItemMeta(unfreezeHeadMeta);

        return unfreezeHead;
    }

}
