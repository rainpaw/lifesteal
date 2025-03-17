package io.github.rainpaw.lifesteal.events;

import io.github.rainpaw.lifesteal.items.ItemManager;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class WardenKilled implements Listener {

    @EventHandler
    public void onWardenDeath(EntityDeathEvent event) {
        if (event.getEntity().getKiller() != null) {
            if (event.getEntity().getType() == EntityType.WARDEN) {
                event.getDrops().add(ItemManager.getHeart());
            }
        }
    }
}
