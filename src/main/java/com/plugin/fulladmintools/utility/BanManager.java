package com.plugin.fulladmintools.utility;

import com.plugin.fulladmintools.AdminToolsPlugin;
import org.bukkit.BanList;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import java.net.InetSocketAddress;
import java.util.Date;

/*
 *
 *@author Pablo Hermida Gómez DAM G1
 *
 */
public class BanManager {


    private AdminToolsPlugin plugin;

    public BanManager(AdminToolsPlugin plugin){
        this.plugin = plugin;
    }

    public boolean ban(String playerName, String reason, Date date){
        Player player = plugin.getServer().getPlayerExact(playerName);

        if (player == null){
            return false;
        }else{
            player.kickPlayer("You have been banned from the server");

            plugin.getServer().getBanList(BanList.Type.NAME).addBan(playerName, reason, date, "NOMBRE_DEL_SERVER");

            return true;
        }
    }

    public boolean ban(String playerName, String reason){
        Player player = plugin.getServer().getPlayerExact(playerName);

        if (player == null){
            return false;
        }else{
            player.kickPlayer("You have been banned from the server");

            plugin.getServer().getBanList(BanList.Type.NAME).addBan(playerName, reason, null, "NOMBRE_DEL_SERVER");

            return true;
        }
    }

    public void banIP(String playerName){
        Player playerToBan = plugin.getServer().getPlayerExact(playerName);

        playerToBan.kickPlayer("You have been banned from the server");

        plugin.getServer().banIP(playerToBan.getAddress().getAddress().getHostAddress());
    }

    public void banIP(InetSocketAddress ip){
        plugin.getServer().banIP(ip.getAddress().getHostAddress());
    }

    public void unBan(String playerName){
        plugin.getServer().getBanList(BanList.Type.NAME).pardon(playerName);
    }

    public void unBanIP(String ip){
        plugin.getServer().unbanIP(ip);
    }

    public void unBanIP(InetSocketAddress ip){
        plugin.getServer().unbanIP(ip.getAddress().getHostAddress());
    }

    public void unBanIP(Player player){
        plugin.getServer().unbanIP(player.getAddress().getAddress().getHostAddress());
    }

    public void banList(){
        plugin.getServer().getBanList(BanList.Type.NAME).getBanEntries().forEach(banEntry -> {
            System.out.println(banEntry.getTarget() + " " + banEntry.getReason());
        });
    }

    public void banListIP(){
        plugin.getServer().getBanList(BanList.Type.IP).getBanEntries().forEach(banEntry -> {
               System.out.println(banEntry.getTarget() + " " + banEntry.getReason());
        });
    }

    public boolean checkBan(String playerName){
        return plugin.getServer().getBanList(BanList.Type.NAME).isBanned(playerName);
    }
}
