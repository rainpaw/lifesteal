package io.github.rainpaw.lifesteal.items;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Collections;

public class ItemManager {
    private static ShapedRecipe srBeacon;

    public static ItemStack getHeart() {
        ItemStack item = new ItemStack(Material.NETHER_STAR, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§4§l§oHeart");

        meta.setEnchantmentGlintOverride(true);

        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack getBeaconOfLife() {
        ItemStack item = new ItemStack(Material.BEACON, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.LIGHT_PURPLE + "Beacon of Life");

        meta.setLore(Collections.singletonList(ChatColor.GRAY + "Use to revive a heart-banned player!"));

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

        // Beacon Recipe
        srBeacon = new ShapedRecipe(NamespacedKey.minecraft("beacon_of_life"), getBeaconOfLife());
        srBeacon.shape("HEH", "CVO", "HAH");
        srBeacon.setIngredient('H', new RecipeChoice.ExactChoice(getHeart()));
        srBeacon.setIngredient('E', Material.ELYTRA);
        srBeacon.setIngredient('C', Material.RECOVERY_COMPASS);
        srBeacon.setIngredient('V', Material.HEAVY_CORE);
        srBeacon.setIngredient('O', Material.CONDUIT);
        srBeacon.setIngredient('A', Material.ENCHANTED_GOLDEN_APPLE);
        Bukkit.getServer().addRecipe(srBeacon);
    }

    public static ShapedRecipe getBeaconRecipe() {
        return srBeacon;
    }
}
