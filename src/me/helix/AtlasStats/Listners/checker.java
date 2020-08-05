package me.helix.AtlasStats.Listners;

import me.helix.AtlasStats.Main;
import org.bukkit.Material;
import org.bukkit.Statistic;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;

public class checker implements Listener {

    private Main main;
    public checker(Main main) {
        this.main = main;
    }

    @EventHandler
    public void onInvClose(InventoryCloseEvent e) {

        Player p = (Player) e.getPlayer();

        if(e.getPlayer() == null)
            return;
        if(!(e.getPlayer() instanceof Player))
            return;
        if(!p.isOnline())
            return;
    }

    @EventHandler
    public void onInvClick(InventoryClickEvent e) {

        Player p = (Player)e.getWhoClicked();
        World worldd = p.getWorld();
        if(this.main.statsInventory.containsKey(p)) {
            Inventory inv = this.main.statsInventory.get(p);

            if (e.getInventory().equals(inv)) {
                e.setCancelled(true);
            }
            if (Material.AIR == null) {
                return;
            }
            if (e.getCurrentItem() == null) {
                return;
            }

            if (e.getCurrentItem().getType() == (Material.PLAYER_HEAD)) {
                p.chat(Main.color("&6&l* &e&lPlayer Information"));
                p.chat(Main.color("&c&m---------------------------"));
                p.chat(Main.color("&c● &eTime Since Last Death &8&l» &a" + p.getStatistic(Statistic.TIME_SINCE_DEATH)));
                p.chat(Main.color("&c● &eTime Since Last Sleep &8&l» &a" + p.getStatistic(Statistic.TIME_SINCE_REST)));
                p.chat(Main.color("&c● &eSneak Time &8&l» &a" + p.getStatistic(Statistic.SNEAK_TIME)));
                p.chat(Main.color("&c● &ePlayers Killed &8&l» &a" + p.getStatistic(Statistic.PLAYER_KILLS)));
                p.chat(Main.color("&c● &eDistance Swam &8&l» &a" + p.getStatistic(Statistic.SWIM_ONE_CM)));
                p.chat(Main.color("&c● &eTimes Died &8&l» &a" + p.getStatistic(Statistic.DEATHS)));
                p.chat(Main.color("&c● &eAnimals Bred &8&l» &a" + p.getStatistic(Statistic.ANIMALS_BRED)));
                p.chat(Main.color("&c● &eDamage Dealt &8&l» &a" + p.getStatistic(Statistic.DAMAGE_DEALT)));
                p.chat(Main.color("&c● &eDamage Taken &8&l» &a" + p.getStatistic(Statistic.DAMAGE_TAKEN)));
                p.chat(Main.color("&c● &eDamage Blocked by Shield &8&l» &a" + p.getStatistic(Statistic.DAMAGE_BLOCKED_BY_SHIELD)));
                p.chat(Main.color("&c● &eRaids Started &8&l» &a" + p.getStatistic(Statistic.RAID_TRIGGER)));
                p.chat(Main.color("&c● &eRaid Wins &8&l» &a" + p.getStatistic(Statistic.RAID_WIN)));
                p.chat(Main.color("&c&m---------------------------"));
            }
            if (e.getCurrentItem().getType() == (Material.MAP)) {
                p.chat(Main.color("§6§l* §e§lWorld Information"));
                p.chat(Main.color("&c&m---------------------------"));
                p.chat(Main.color("&c● &eSpawn Location &8&l» &a" + worldd.getSpawnLocation().getBlockX() + " &7Y:&c" + worldd.getSpawnLocation().getBlockY() + " &7Z:&b" + worldd.getSpawnLocation().getBlockZ()));
                p.chat(Main.color("&c● &eLocation &8&l» &7X:&a" + p.getLocation().getBlockX() + " &7Y:&c" + p.getLocation().getBlockY() + " &7Z:&b" + p.getLocation().getBlockZ()));
//                p.chat(Main.color("&c● &eBed Location &8&l» &7X:&a" + p.getBedSpawnLocation().getBlockX() + " &7Y:&c" + p.getBedSpawnLocation().getBlockY() + " &7Z:&b" + p.getBedSpawnLocation().getBlockZ()));
                p.chat(Main.color("&c● &eWorld Name &8&l» &a" + worldd.getName()));
                p.chat(Main.color("&c● &eBiome Name &8&l» &a" + p.getLocation().getBlock().getBiome()));
                p.chat(Main.color("&c&m---------------------------"));
            }
            if (e.getCurrentItem().getType() == (Material.ZOMBIE_HEAD)) {
                p.chat(Main.color("§6§l* §e§lMob Information"));
                p.chat(Main.color("&c&m---------------------------"));
                p.chat(Main.color("&c● &eTotal Mobs Killed &8&l» &a" + p.getStatistic(Statistic.MOB_KILLS)));
                p.chat(Main.color("&c&m---------------------------"));
            }
            if (e.getCurrentItem().getType() == (Material.DIAMOND_ORE)) {
                p.chat(Main.color("§6§l* §e§lOre Information"));
                p.chat(Main.color("&c&m---------------------------"));
                p.chat(Main.color("&c● &eNetherite Blocks Mined &8&l» &4" + p.getStatistic(Statistic.MINE_BLOCK, Material.NETHERITE_BLOCK)));
                p.chat(Main.color("&c● &eEmerald Ore Blocks Mined &8&l» &a" + p.getStatistic(Statistic.MINE_BLOCK, Material.EMERALD_ORE)));
                p.chat(Main.color("&c● &eDiamond Ore Blocks Mined &8&l» &b" + p.getStatistic(Statistic.MINE_BLOCK, Material.DIAMOND_ORE)));
                p.chat(Main.color("&c● &eGold Ore Blocks Mined &8&l» &6" + p.getStatistic(Statistic.MINE_BLOCK, Material.GOLD_ORE)));
                p.chat(Main.color("&c● &eLapis Ore Blocks Mined &8&l» &1" + p.getStatistic(Statistic.MINE_BLOCK, Material.LAPIS_ORE)));
                p.chat(Main.color("&c● &eRedstone Ore Blocks Mined &8&l» &c" + p.getStatistic(Statistic.MINE_BLOCK, Material.REDSTONE_ORE)));
                p.chat(Main.color("&c● &eIron Ore Blocks Mined &8&l» &f" + p.getStatistic(Statistic.MINE_BLOCK, Material.IRON_ORE)));
                p.chat(Main.color("&c● &eCoal Ore Blocks Mined &8&l» &0" + p.getStatistic(Statistic.MINE_BLOCK, Material.COAL_ORE)));
                p.chat(Main.color("&c● &eStone Blocks Mined &8&l» &7" + p.getStatistic(Statistic.MINE_BLOCK, Material.STONE)));
                p.chat(Main.color("&c● &eGrass Blocks Mined &8&l» &a" + p.getStatistic(Statistic.MINE_BLOCK, Material.GRASS)));
                p.chat(Main.color("&c● &eDirt Blocks Mined &8&l» &2" + p.getStatistic(Statistic.MINE_BLOCK, Material.DIRT)));
                p.chat(Main.color("&c● &eCobbleStone Blocks Mined &8&l» &8" + p.getStatistic(Statistic.MINE_BLOCK, Material.COBBLESTONE)));
                p.chat(Main.color("&c● &eSand Blocks Mined &8&l» &e" + p.getStatistic(Statistic.MINE_BLOCK, Material.SAND)));
                p.chat(Main.color("&c&m---------------------------"));
            }
        }
    }
}
