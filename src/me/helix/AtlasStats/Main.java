package me.helix.AtlasStats;

import me.helix.AtlasStats.GUIS.stats_gui;
import me.helix.AtlasStats.Listners.checker;
import me.helix.AtlasStats.Listners.deathevent;
import me.helix.AtlasStats.Listners.lag;
import me.helix.AtlasStats.commands.serverstats;
import me.helix.AtlasStats.commands.stats;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.HashMap;

public class Main extends JavaPlugin implements Listener {

    public static String color(String string) {
        return ChatColor.translateAlternateColorCodes('&', string);
    }

    public HashMap<Player, Inventory> statsInventory = new HashMap<Player, Inventory>();

    @Override
    public void onEnable() {

        File file = new File(getDataFolder(), "config.yml");
        if (!file.exists()) {
            saveDefaultConfig();
        }

        Bukkit.getConsoleSender().sendMessage(color("&4---------------------"));
        Bukkit.getConsoleSender().sendMessage(color("&cStatistics: &e1.1"));
        Bukkit.getConsoleSender().sendMessage(color(""));
        Bukkit.getConsoleSender().sendMessage(color("&cMade by _Ghillie & Helix"));
        Bukkit.getConsoleSender().sendMessage(color(""));
        Bukkit.getConsoleSender().sendMessage(color("&cPlugin &aEnabled"));
        Bukkit.getConsoleSender().sendMessage(color("&4---------------------"));

        //Commands
        getCommand("stats").setExecutor(new stats(this));
        getCommand("serverstats").setExecutor(new serverstats(this));

        //Events
        Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, new lag(), 100L, 1L);
        this.getServer().getPluginManager().registerEvents(new checker(this), this);
        this.getServer().getPluginManager().registerEvents(new deathevent(this), this);
        this.getServer().getPluginManager().registerEvents(new stats_gui(this), this);

        Bukkit.getServer().getPluginManager().registerEvents(this, this);
    }

}
