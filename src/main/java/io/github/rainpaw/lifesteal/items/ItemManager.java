package io.github.rainpaw.lifesteal.items;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemManager {

    public static ItemStack heart;

    public static void init() {
        createHeart();
    }

    private static void createHeart() {
        ItemStack item = new ItemStack(Material.NETHER_STAR, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§4§l§oHeart");

        meta.setEnchantmentGlintOverride(true);

        item.setItemMeta(meta);
        heart = item;

        // Recipes
        ShapedRecipe srKey = new ShapedRecipe(NamespacedKey.minecraft("heart_trial_key"), item);
        srKey.shape("NEN", "ETE", "NEN");
        srKey.setIngredient('N', Material.NAUTILUS_SHELL);
        srKey.setIngredient('E', Material.NETHERITE_INGOT);
        srKey.setIngredient('T', Material.TRIAL_KEY);

        ShapedRecipe srDragon = new ShapedRecipe(NamespacedKey.minecraft("heart_dragon_head"), item);
        srDragon.shape("NEN", "EDE", "NEN");
        srDragon.setIngredient('N', Material.NAUTILUS_SHELL);
        srDragon.setIngredient('E', Material.NETHERITE_INGOT);
        srDragon.setIngredient('D', Material.DRAGON_HEAD);

        ShapedRecipe srWither = new ShapedRecipe(NamespacedKey.minecraft("heart_wither_skeleton_skull"), item);
        srWither.shape("NEN", "EWE", "NEN");
        srWither.setIngredient('N', Material.NAUTILUS_SHELL);
        srWither.setIngredient('E', Material.NETHERITE_INGOT);
        srWither.setIngredient('W', Material.WITHER_SKELETON_SKULL);

        Bukkit.getServer().addRecipe(srKey);
        Bukkit.getServer().addRecipe(srDragon);
        Bukkit.getServer().addRecipe(srWither);
    }
}
