package me.helix.AtlasStats.commands;

import me.helix.AtlasStats.GUIS.stats_gui;
import me.helix.AtlasStats.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class stats implements Listener, CommandExecutor {

    private Main main;
    public stats(Main main) {
        this.main = main;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {

        Player p = (Player) sender;

        stats_gui gui = new stats_gui(this.main);
        gui.build(p);
        gui.show(p);
        p.updateInventory();

        return true;
    }

}
