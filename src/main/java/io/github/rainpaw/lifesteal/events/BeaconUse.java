package io.github.rainpaw.lifesteal.events;

import io.github.rainpaw.lifesteal.guis.RevivalScreen;
import io.github.rainpaw.lifesteal.items.ItemManager;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class BeaconUse implements Listener {

    @EventHandler
    public static void onBeaconUse(PlayerInteractEvent event) {
        if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (event.getItem() != null) {
                if (event.getItem().getItemMeta().equals(ItemManager.getBeaconOfLife().getItemMeta())) {
                    Player player = event.getPlayer();

                    RevivalScreen gui = new RevivalScreen();
                    player.openInventory(gui.getInventory());

                    event.setCancelled(true);
                }
            }
        }
    }
}
