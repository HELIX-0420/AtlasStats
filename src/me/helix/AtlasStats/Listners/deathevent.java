package me.helix.AtlasStats.Listners;

import me.helix.AtlasStats.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class deathevent implements Listener {

    private Main main;
    public deathevent(Main main) {
        this.main = main;
    }

    @EventHandler
    public void deathevent (PlayerDeathEvent e) {
        Player p = e.getEntity().getPlayer();
        p.sendMessage(Main.color("&eYou died at &8&l» &7X:&a " + p.getLocation().getBlockX() + " &7Y:&c" + p.getLocation().getBlockY() + " &7Z:&b" + p.getLocation().getBlockZ()));
    }
}
