package com.plugin.fulladmintools.utility;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

/*
 *
 *@author Pablo Hermida Gómez DAM G1
 *
 */
public class OtherUtilitys {

    private static ArrayList<String> frozenPlayers = new ArrayList<String>();

    //This stores the muted players and the date when they will be unmuted
    private static ArrayList<String> mutedPlayers = new ArrayList<String>();

    //This method freeze the player
    public static void freezePlayer(Player player){
        player.setWalkSpeed(0.0f);
        player.setFreezeTicks(0);

        frozenPlayers.add(player.getDisplayName());
    }

    //This method unfreeze the player
    public static void unfreezePlayer(Player player){
        //Unfreeze the player
        player.setWalkSpeed(0.2f);

        frozenPlayers.remove(player.getDisplayName());
    }

    //This method checks if the player is frozen
    public static boolean isPlayerFrozen(Player player){
        if(frozenPlayers.contains(player.getDisplayName())){
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

    public static ArrayList<String> getFrozenPlayers(){
        return frozenPlayers;
    }

    public static ArrayList<String> getMutedPlayers(){
        return mutedPlayers;
    }

    public static boolean mutePlayer(Player player, int hours){
        if (!isPlayerMuted(player)) {
            int time = (int) (System.currentTimeMillis()/1000) + (hours*60*60);

            mutedPlayers.add(player.getDisplayName()+"-->"+time+" h");

            return true;
        }else{
            return false;
        }
    }

    public static void unmutePlayer(Player player){
        // /(& is the separator
        mutedPlayers.remove(player.getDisplayName()+"-->"+getMutedTime(player)+" h");
    }

    private static int getMutedTime(Player player){
        for(String mutedPlayer : mutedPlayers){
            if(mutedPlayer.contains(player.getDisplayName())){
                String aux = mutedPlayer.split("-->")[1];

                return Integer.parseInt(aux.split(" h")[0]);
            }
        }

        return 0;
    }

    public static boolean isPlayerMuted(Player player){
        if(getMutedTime(player) > (int) (System.currentTimeMillis()/1000)){
            return true;
        }else{
            return false;
        }
    }

    public static String getRemainingTime(Player player){
        String time = "";

        int remainingTime = getMutedTime(player) - (int) (System.currentTimeMillis()/1000);

        int hours = remainingTime/60/60;
        int minutes = (remainingTime - (hours*60*60))/60;
        int seconds = remainingTime - (hours*60*60) - (minutes*60);

        if(hours > 0){
            time = hours + " hours ";
        }

        if(minutes > 0){
            time = time + minutes + " minutes ";
        }

        if(seconds > 0){
            time = time + seconds + " seconds";
        }

        return time;
    }

    //This method checks remaining time for a muted player and unmute him if the time is over
    public static void checkMutedPlayer(Player player){
        if(isPlayerMuted(player)){
            if(getMutedTime(player) < (int) (System.currentTimeMillis()/1000)){
                unmutePlayer(player);
            }
        }
    }
}
