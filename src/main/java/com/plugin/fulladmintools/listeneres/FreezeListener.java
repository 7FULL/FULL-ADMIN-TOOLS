package com.plugin.fulladmintools.listeneres;

import com.plugin.fulladmintools.utility.OtherUtilitys;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

/*
 *
 *@author Pablo Hermida Gómez DAM G1
 *
 */
public class FreezeListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerMoveEvent e){
        Player player = e.getPlayer();

        if(OtherUtilitys.isPlayerFrozen(player)){
            Location from = e.getFrom();
            Location to = e.getTo();

            if (from.getBlockY() < to.getBlockY() && !player.isSwimming())
            {
                e.setCancelled(true);
            }
        }
    }
}
