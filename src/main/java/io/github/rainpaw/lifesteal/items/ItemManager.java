package io.github.rainpaw.lifesteal.items;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemManager {
    public static ItemStack getHeart() {
        ItemStack item = new ItemStack(Material.NETHER_STAR, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§4§l§oHeart");

        meta.setEnchantmentGlintOverride(true);

        item.setItemMeta(meta);
        return item;
    }

    public static void createRecipes() {
        // Heart Recipes
        ShapedRecipe srKey = new ShapedRecipe(NamespacedKey.minecraft("heart_trial_key"), getHeart());
        srKey.shape("NEN", "ETE", "NEN");
        srKey.setIngredient('N', Material.NAUTILUS_SHELL);
        srKey.setIngredient('E', Material.NETHERITE_INGOT);
        srKey.setIngredient('T', Material.TRIAL_KEY);

        ShapedRecipe srDragon = new ShapedRecipe(NamespacedKey.minecraft("heart_dragon_head"), getHeart());
        srDragon.shape("NEN", "EDE", "NEN");
        srDragon.setIngredient('N', Material.NAUTILUS_SHELL);
        srDragon.setIngredient('E', Material.NETHERITE_INGOT);
        srDragon.setIngredient('D', Material.DRAGON_HEAD);

        ShapedRecipe srWither = new ShapedRecipe(NamespacedKey.minecraft("heart_wither_skeleton_skull"), getHeart());
        srWither.shape("NEN", "EWE", "NEN");
        srWither.setIngredient('N', Material.NAUTILUS_SHELL);
        srWither.setIngredient('E', Material.NETHERITE_INGOT);
        srWither.setIngredient('W', Material.WITHER_SKELETON_SKULL);

        Bukkit.getServer().addRecipe(srKey);
        Bukkit.getServer().addRecipe(srDragon);
        Bukkit.getServer().addRecipe(srWither);
    }
}
