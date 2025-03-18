package io.github.rainpaw.lifesteal.events;

import io.github.rainpaw.lifesteal.items.ItemManager;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.CraftingInventory;
import org.bukkit.inventory.ItemStack;

public class CraftWithCustomItem implements Listener {

    @EventHandler
    public void craftItem(PrepareItemCraftEvent event) {
        CraftingInventory inv = event.getInventory();

        // Check for beacon recipe (long, I know)
        if (inv.contains(ItemManager.getHeart(), 0) &&
                inv.contains(Material.ELYTRA, 1) &&
                inv.contains(ItemManager.getHeart(), 2) &&
                inv.contains(Material.RECOVERY_COMPASS, 3) &&
                inv.contains(Material.HEAVY_CORE, 4) &&
                inv.contains(Material.CONDUIT, 5) &&
                inv.contains(ItemManager.getHeart(), 6) &&
                inv.contains(Material.ENCHANTED_GOLDEN_APPLE, 7) &&
                inv.contains(ItemManager.getHeart(), 8)) {
            return;
        }

        for (ItemStack stack : inv.getMatrix()) {
            if (stack != null) {
                if (stack.isSimilar(ItemManager.getHeart())) {
                    inv.setResult(null);
                }
            }
        }
    }
}
