package io.github.rainpaw.lifesteal.events;

import io.github.rainpaw.lifesteal.items.ItemManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.CraftingInventory;
import org.bukkit.inventory.ItemStack;

public class CraftWithCustomItem implements Listener {

    @EventHandler
    public void craftItem(PrepareItemCraftEvent event) {
        CraftingInventory inv = event.getInventory();

        for (ItemStack stack : inv.getMatrix()) {
            if (stack != null) {
                if (stack.isSimilar(ItemManager.getHeart())) {
                    inv.setResult(null);
                }
            }
        }
    }
}
