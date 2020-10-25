package pl.stylowamc;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Objects;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class SpawnEvents implements Listener {

    @EventHandler
    public void WitherSpawn(CreatureSpawnEvent e) {
        if (e.getEntityType() == EntityType.WITHER) {
            e.getEntity().setHealth(1024);
            e.getEntity().damage(12);
        }
    }

    @EventHandler
    public void DragonSpawn(CreatureSpawnEvent e) {
        if (e.getEntityType() == EntityType.ENDER_DRAGON) {
            e.getEntity().setHealth(1024);
            e.getEntity().damage(10);
        }
    }

}
