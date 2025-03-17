package io.github.rainpaw.lifesteal.events;

import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.advancement.Advancement;
import org.bukkit.advancement.AdvancementProgress;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import java.util.Iterator;
import java.util.Objects;

public class OnPlayerDeath implements Listener {

    String[] heartAdvancements = {"Return to Sender", "Subspace Bubble", "Uneasy Alliance",
            "Cover Me in Debris", "Hot Tourist Destinations", "A Furious Cocktail", "How Did We Get Here?",
            "Free the End", "The Next Generation", "The End... Again...", "The City at the End of the Game",
            "Great View From Up Here", "Hero of the Village", "It Spreads", "Monsters Hunted",
            "Two Birds, One Arrow", "Arbalistic", "Adventuring Time", "Sniper Duel", "Bullseye", "Two by Two",
            "A Complete Catalogue", "A Balanced Diet", "Serious Dedication", "With Our Powers Combined!",
            "Zombie Doctor", "Beaconator", "You Need a Mint", "The Healing Power of Friendship!"};

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {

        Iterator<Advancement> advancements = Bukkit.getServer().advancementIterator();
        Player player = event.getEntity();
        AttributeInstance playerPermHealth = player.getAttribute(Attribute.MAX_HEALTH);

        while (advancements.hasNext()) {
            Advancement advancementsNext = advancements.next();
            AdvancementProgress progress = player.getAdvancementProgress(advancementsNext);

            if (advancementsNext.getDisplay() != null) {
                for (String heartAdvancement : heartAdvancements) {
                    if (Objects.equals(heartAdvancement, advancementsNext.getDisplay().getTitle())) {
                        for (String s : progress.getAwardedCriteria()) {
                            progress.revokeCriteria(s);
                        }
                    }
                }
            }
        }

        if (Objects.requireNonNull(playerPermHealth).getValue() > 20) {
            Objects.requireNonNull(playerPermHealth).setBaseValue(20);
        } else if (Objects.requireNonNull(playerPermHealth).getValue() < 22 && Objects.requireNonNull(playerPermHealth).getValue() > 2) {
            Objects.requireNonNull(playerPermHealth).setBaseValue(playerPermHealth.getValue() - 2);
        } else if (Objects.requireNonNull(playerPermHealth).getValue() < 4){
            player.kickPlayer("You have been banned because you lost all your hearts!");
            String playerID = player.getUniqueId().toString();
            Bukkit.getBanList(BanList.Type.NAME).addBan(playerID, "You have been banned because you lost all your hearts!", null, null);
        }
    }
}
