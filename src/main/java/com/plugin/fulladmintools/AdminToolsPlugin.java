package com.plugin.fulladmintools;

import com.plugin.fulladmintools.commands.AdminMenus;
import com.plugin.fulladmintools.commands.Ban;
import com.plugin.fulladmintools.commands.BanList;
import com.plugin.fulladmintools.commands.UnBanPlayer;
import com.plugin.fulladmintools.listeneres.MenuListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class AdminToolsPlugin extends JavaPlugin {

    private static AdminToolsPlugin instance;

    @Override
    public void onEnable() {
        instance = this;

        getConfig().options().copyDefaults(true);
        saveDefaultConfig();

        //Register de commands
        getCommand("admin").setExecutor(new AdminMenus());
        getCommand("banlist").setExecutor(new BanList());
        getCommand("unban").setExecutor(new UnBanPlayer());
        getCommand("ban").setExecutor(new Ban());


        //Register the listeners
        getServer().getPluginManager().registerEvents(new MenuListener(), this);
    }

    public static AdminToolsPlugin getPlugin(){
        return instance;
    }
}
