package io.github.rainpaw.lifesteal.events;

import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class GiveRecipesOnJoin implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        if (!player.hasDiscoveredRecipe(NamespacedKey.minecraft("beacon_of_life"))) {
            player.discoverRecipe(NamespacedKey.minecraft("heart_trial_key"));
            player.discoverRecipe(NamespacedKey.minecraft("heart_dragon_head"));
            player.discoverRecipe(NamespacedKey.minecraft("heart_wither_skeleton_skull"));
            player.discoverRecipe(NamespacedKey.minecraft("beacon_of_life"));
        }
    }
}
