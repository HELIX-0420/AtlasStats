package me.helix.AtlasStats.GUIS;

import me.helix.AtlasStats.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Statistic;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class stats_gui implements Listener {

    private Main main;
    public stats_gui(Main main) {
        this.main = main;
    }

    public Inventory stats;
    public void build (Player p) {

        stats = Bukkit.createInventory(null, 9, Main.color("            &e&lStats Menu"));

        World worldd = p.getWorld();

        ItemStack world = new ItemStack(Material.MAP);
        ItemMeta worldmera = world.getItemMeta();
        worldmera.setDisplayName(Main.color("&cWorld Stats"));
        ArrayList<String> lore1 = new ArrayList();
        lore1.add("§6§l* §e§lInformation");
        lore1.add("");
        lore1.add(Main.color("&c● &eSpawn Location &8&l» &7X:&a" + worldd.getSpawnLocation().getBlockX() + " &7Y:&c" + worldd.getSpawnLocation().getBlockY() + " &7Z:&b" + worldd.getSpawnLocation().getBlockZ()));
        lore1.add(Main.color("&c● &eYour Location &8&l» &7X:&a" + p.getLocation().getBlockX() + " &7Y:&c" + p.getLocation().getBlockY() + " &7Z:&b" + p.getLocation().getBlockZ()));
//        lore1.add(Main.color("&c● &eBed Location &8&l» &7X:&a" + p.getBedSpawnLocation().getBlockX() + " &7Y:&c" + p.getBedSpawnLocation().getBlockY() + " &7Z:&b" + p.getBedSpawnLocation().getBlockZ()));
        lore1.add(Main.color("&c● &eWorld Name &8&l» &a" + worldd.getName()));
        lore1.add(Main.color("&c● &eBiome Name &8&l» &a" + p.getLocation().getBlock().getBiome()));
        worldmera.setLore(lore1);
        world.setItemMeta(worldmera);

        ItemStack player = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta playermera = (SkullMeta) player.getItemMeta();
        playermera.setOwner(p.getName());
        playermera.setDisplayName(Main.color("&c" + p.getDisplayName()));
        ArrayList<String> lore3 = new ArrayList();
        lore3.add("§6§l* §e§lInformation");
        lore3.add("");
        lore3.add(Main.color("&c● &eTime Since Last Death &8&l» &a" + p.getStatistic(Statistic.TIME_SINCE_DEATH)));
        lore3.add(Main.color("&c● &eTime Since Last Sleep &8&l» &a" + p.getStatistic(Statistic.TIME_SINCE_REST)));
        lore3.add(Main.color("&c● &eSneak Time &8&l» &a" + p.getStatistic(Statistic.SNEAK_TIME)));
        lore3.add(Main.color("&c● &ePlayers Killed &8&l» &a" + p.getStatistic(Statistic.PLAYER_KILLS)));
        lore3.add(Main.color("&c● &eDistance Swam &8&l» &a" + p.getStatistic(Statistic.SWIM_ONE_CM)));
        lore3.add(Main.color("&c● &eTimes Died &8&l» &a" + p.getStatistic(Statistic.DEATHS)));
        lore3.add(Main.color("&c● &eAnimals Bred &8&l» &a" + p.getStatistic(Statistic.ANIMALS_BRED)));
        lore3.add(Main.color("&c● &eDamage Dealt &8&l» &a" + p.getStatistic(Statistic.DAMAGE_DEALT)));
        lore3.add(Main.color("&c● &eDamage Taken &8&l» &a" + p.getStatistic(Statistic.DAMAGE_TAKEN)));
        lore3.add(Main.color("&c● &eDamage Blocked by Shield &8&l» &a" + p.getStatistic(Statistic.DAMAGE_BLOCKED_BY_SHIELD)));
        lore3.add(Main.color("&c● &eRaids Started &8&l» &a" + p.getStatistic(Statistic.RAID_TRIGGER)));
        lore3.add(Main.color("&c● &eRaid Wins &8&l» &a" + p.getStatistic(Statistic.RAID_WIN)));
        playermera.setLore(lore3);
        player.setItemMeta(playermera);

        ItemStack mob = new ItemStack(Material.ZOMBIE_HEAD);
        ItemMeta mobmera = mob.getItemMeta();
        mobmera.setDisplayName(Main.color("&cMob Stats"));
        ArrayList<String> lore4 = new ArrayList();
        lore4.add("§6§l* §e§lInformation");
        lore4.add("");
        lore4.add(Main.color("&c● &eTotal Mobs Killed &8&l» &a" + p.getStatistic(Statistic.MOB_KILLS)));
        mobmera.setLore(lore4);
        mob.setItemMeta(mobmera);

        ItemStack ore = new ItemStack(Material.DIAMOND_ORE);
        ItemMeta oremera = ore.getItemMeta();
        oremera.setDisplayName(Main.color("&c" + p.getDisplayName()));
        ArrayList<String> lore5 = new ArrayList();
        lore5.add("§6§l* §e§lInformation");
        lore5.add("");
        lore5.add(Main.color("&c● &eNetherite Blocks Mined &8&l» &4" + p.getStatistic(Statistic.MINE_BLOCK, Material.NETHERITE_BLOCK)));
        lore5.add(Main.color("&c● &eEmerald Ore Blocks Mined &8&l» &a" + p.getStatistic(Statistic.MINE_BLOCK, Material.EMERALD_ORE)));
        lore5.add(Main.color("&c● &eDiamond Ore Blocks Mined &8&l» &b" + p.getStatistic(Statistic.MINE_BLOCK, Material.DIAMOND_ORE)));
        lore5.add(Main.color("&c● &eGold Ore Blocks Mined &8&l» &6" + p.getStatistic(Statistic.MINE_BLOCK, Material.GOLD_ORE)));
        lore5.add(Main.color("&c● &eLapis Ore Blocks Mined &8&l» &1" + p.getStatistic(Statistic.MINE_BLOCK, Material.LAPIS_ORE)));
        lore5.add(Main.color("&c● &eRedstone Ore Blocks Mined &8&l» &c" + p.getStatistic(Statistic.MINE_BLOCK, Material.REDSTONE_ORE)));
        lore5.add(Main.color("&c● &eIron Ore Blocks Mined &8&l» &f" + p.getStatistic(Statistic.MINE_BLOCK, Material.IRON_ORE)));
        lore5.add(Main.color("&c● &eCoal Ore Blocks Mined &8&l» &0" + p.getStatistic(Statistic.MINE_BLOCK, Material.COAL_ORE)));
        lore5.add(Main.color("&c● &eStone Blocks Mined &8&l» &7" + p.getStatistic(Statistic.MINE_BLOCK, Material.STONE)));
        lore5.add(Main.color("&c● &eGrass Blocks Mined &8&l» &a" + p.getStatistic(Statistic.MINE_BLOCK, Material.GRASS)));
        lore5.add(Main.color("&c● &eDirt Blocks Mined &8&l» &2" + p.getStatistic(Statistic.MINE_BLOCK, Material.DIRT)));
        lore5.add(Main.color("&c● &eCobbleStone Blocks Mined &8&l» &8" + p.getStatistic(Statistic.MINE_BLOCK, Material.COBBLESTONE)));
        lore5.add(Main.color("&c● &eSand Blocks Mined &8&l» &e" + p.getStatistic(Statistic.MINE_BLOCK, Material.SAND)));
        oremera.setLore(lore5);
        ore.setItemMeta(oremera);

        stats.setItem(1, world);
        stats.setItem(3, player);
        stats.setItem(5, mob);
        stats.setItem(7, ore);

    }

    public void show(Player p) {
        this.main.statsInventory.put(p, stats);
        p.openInventory(stats);
    }

}
