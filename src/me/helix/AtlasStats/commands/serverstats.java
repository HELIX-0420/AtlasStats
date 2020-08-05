package me.helix.AtlasStats.commands;

import me.helix.AtlasStats.Listners.lag;
import me.helix.AtlasStats.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class serverstats implements Listener, CommandExecutor {

    private Main main;
    public serverstats(Main main) {
        this.main = main;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {

        Player p = (Player) sender;
        Runtime runtime = Runtime.getRuntime();
        int mb = 1024*1024;
        double tps = Math.round(lag.getTPS());
        double lag = Math.round((1.0D - tps / 20.0D) * 100.0D);

        p.sendMessage(Main.color("&c&m---------------------------"));
        p.sendMessage(Main.color("&eIP &7|&e " + Bukkit.getServer().getIp()));
        p.sendMessage(Main.color("&ePort &7|&e " + Bukkit.getServer().getPort()));
        p.sendMessage(Main.color("&ePlayer Count &7|&e " + Bukkit.getServer().getOnlinePlayers().size() + "&7/&e" + Bukkit.getServer().getMaxPlayers()));
        p.sendMessage(Main.color("&eVersion &7|&e " + Bukkit.getServer().getVersion()));
        p.sendMessage(Main.color(""));
        p.sendMessage(Main.color("&e" + "&7&eServer Ram Usage&7:"));
        p.sendMessage(Main.color(" &eTotal &7|&e " + Math.round(runtime.totalMemory() / mb)));
        p.sendMessage(Main.color(" &eFree &7|&e " + Math.round(runtime.freeMemory() / mb)));
        p.sendMessage(Main.color(""));
        p.sendMessage(Main.color("&eTPS &7| " + tps));
        p.sendMessage(Main.color("&eLAG &7| " + lag + "&e%"));
        p.sendMessage(Main.color("&c&m---------------------------"));

        return false;
    }

}
