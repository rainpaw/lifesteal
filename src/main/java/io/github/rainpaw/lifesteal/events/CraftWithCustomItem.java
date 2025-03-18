package io.github.rainpaw.lifesteal.events;

import io.github.rainpaw.lifesteal.items.ItemManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.inventory.CraftingInventory;
import org.bukkit.inventory.ItemStack;

public class CraftWithCustomItem implements Listener {

    @EventHandler
    public void craftItem(CraftItemEvent event) {
        CraftingInventory inv = event.getInventory();

        if (!event.getRecipe().getResult().equals(ItemManager.getBeaconOfLife())) {
            for (ItemStack stack : inv.getMatrix()) {
                if (stack != null) {
                    if (stack.isSimilar(ItemManager.getHeart())) {
                        event.setCancelled(true);
                    }
                }
            }
        }
    }
}
