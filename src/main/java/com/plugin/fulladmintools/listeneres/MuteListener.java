package com.plugin.fulladmintools.listeneres;

import com.plugin.fulladmintools.utility.OtherUtilitys;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

/*
 *
 *@author Pablo Hermida Gómez DAM G1
 *
 */
public class MuteListener implements Listener {

    @EventHandler
    public void onPlayerSendMessage(AsyncPlayerChatEvent event){
        OtherUtilitys muteUtility = new OtherUtilitys();

        if(muteUtility.isPlayerMuted(event.getPlayer())){
            event.getPlayer().sendMessage(ChatColor.RED + "You are muted for " + muteUtility.getRemainingTime(event.getPlayer()));
            event.setCancelled(true);
        }
    }
}
