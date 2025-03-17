package io.github.rainpaw.lifesteal.events;

import io.github.rainpaw.lifesteal.Lifesteal;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinAfterRevive implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (player.hasPlayedBefore()) {
            if (Lifesteal.justRevivedPlayers.contains(player.getName())) {
                player.getAttribute(Attribute.MAX_HEALTH).setBaseValue(8);
                Lifesteal.justRevivedPlayers.remove(player.getName());
            }
        }
    }
}
