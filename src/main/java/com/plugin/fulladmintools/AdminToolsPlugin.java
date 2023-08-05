package com.plugin.fulladmintools;

import com.plugin.fulladmintools.commands.*;
import com.plugin.fulladmintools.listeneres.FreezeListener;
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
        getCommand("unbanip").setExecutor(new UnBanIP());
        getCommand("banip").setExecutor(new BanIP());
        getCommand("banMenu").setExecutor(new BanMenu());
        getCommand("unBanMenu").setExecutor(new UnBanMenu());
        getCommand("freezeMenu").setExecutor(new FreezeMenu());
        getCommand("kickMenu").setExecutor(new KickMenu());
        getCommand("freeze").setExecutor(new Freeze());
        getCommand("unFreeze").setExecutor(new UnFreeze());


        //Register the listeners
        getServer().getPluginManager().registerEvents(new MenuListener(), this);
        getServer().getPluginManager().registerEvents(new FreezeListener(), this);
    }

    public static AdminToolsPlugin getPlugin(){
        return instance;
    }
}
