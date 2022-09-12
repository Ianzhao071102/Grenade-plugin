package me.horison;

import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.event.Listener;
import me.horison.ConfigReader;

public final class Grenade extends JavaPlugin implements Listener{
    @EventHandler
    public void onProjectileLand(ProjectileHitEvent evt){
        if(evt.getEntity().getShooter() instanceof Player){
            if(evt.getEntityType().equals(EntityType.SNOWBALL)){
                if(evt.getHitBlock() == null){
                    Location Loc = evt.getHitEntity().getLocation();
                    evt.getHitEntity().getWorld().createExplosion(Loc.getX(),Loc.getY(), Loc.getZ(), 1,false,false);
                }
            }
        }
    }
    class ConfigReader extends JavaPlugin implements Listener {
        FileConfiguration config = getConfig();
    }
}
