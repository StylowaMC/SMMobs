package pl.stylowamc;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class SpawnEvents implements Listener {

    HashMap<String,String> WitherKillers = new HashMap<>();
    HashMap<String,String> DragonKillers = new HashMap<>();
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
    @EventHandler
    public void WitherKill2(EntityDamageByEntityEvent e){

        if(e.getDamager() instanceof Player){
            Player p = (Player)e.getDamager();
            //Bukkit.broadcastMessage("jestes graczem");
            if(e.getEntity() instanceof Wither){
                //Bukkit.broadcastMessage("Bijesz withera i jestes graczem");
                WitherKillers.put(p.getName(),p.getName());
            }
        }
    }
    @EventHandler
    public void WitherKill(EntityDeathEvent e){
        if(e.getEntityType() == EntityType.WITHER){
            Bukkit.broadcastMessage(ChatColor.BLUE+""+ChatColor.BOLD+WitherKillers.values().toString()+" zabili Withera!");
            WitherKillers.clear();
        }
    }
    @EventHandler
    public void DragonKill2(EntityDamageByEntityEvent e){
        if(e.getDamager() instanceof Player){
            Player p = (Player)e.getDamager();
            //Bukkit.broadcastMessage("jestes graczem");
            if(e.getEntity() instanceof EnderDragon){
                //Bukkit.broadcastMessage("Bijesz smoka i jestes graczem");
                DragonKillers.put(p.getName(),p.getName());
            }
        }
    }
    @EventHandler
    public void DragonKill(EntityDeathEvent e){
        if(e.getEntityType() == EntityType.ENDER_DRAGON){
            Bukkit.broadcastMessage(ChatColor.BLUE+""+ChatColor.BOLD+DragonKillers.values().toString()+" zabili EnderDragona!");
            DragonKillers.clear();
        }
    }

}
