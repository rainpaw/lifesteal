package io.github.rainpaw.lifesteal.events;

import io.github.rainpaw.lifesteal.items.ItemManager;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class HeartConsume implements Listener {

    @EventHandler
    public static void onHeartConsume(PlayerInteractEvent event) {
        if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (event.getItem() != null) {
                if (event.getItem().getItemMeta().equals(ItemManager.heart.getItemMeta())) {
                    Player player = event.getPlayer();
                    if (player.getAttribute(Attribute.MAX_HEALTH).getBaseValue() < 40) {
                        player.getAttribute(Attribute.MAX_HEALTH).setBaseValue(player.getAttribute(Attribute.MAX_HEALTH).getBaseValue() + 2);

                        player.getInventory().removeItem(ItemManager.heart);
                    }
                }
            }
        }
    }
}
