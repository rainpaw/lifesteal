package io.github.rainpaw.lifesteal.events;

import io.github.rainpaw.lifesteal.Lifesteal;
import io.github.rainpaw.lifesteal.guis.RevivalScreen;
import io.github.rainpaw.lifesteal.guis.RevivalScreenConfirm;
import org.bukkit.*;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.UUID;

public class RevivalScreenListener implements Listener {

    @EventHandler
    public void onMenuClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();

        if (ChatColor.stripColor(event.getView().getTitle()).equalsIgnoreCase("Revive Player")) {
            if (event.getCurrentItem() != null) {
                if (event.getCurrentItem().getType() == Material.PLAYER_HEAD) {

                    String whoToReviveLore = event.getCurrentItem().getItemMeta().getLore().get(1);
                    UUID whoToReviveUUID = UUID.fromString(ChatColor.stripColor(whoToReviveLore));
                    OfflinePlayer whoToRevive = Bukkit.getServer().getOfflinePlayer(whoToReviveUUID);

                    if (whoToRevive != null) {
                        RevivalScreenConfirm revivalScreenConfirm = new RevivalScreenConfirm(whoToRevive);
                        player.openInventory(revivalScreenConfirm.getInventory());
                    } else {
                        player.sendMessage(ChatColor.RED + "(!) An error occurred when executing that action: You cannot revive that player at this time!");
                    }
                } else if (event.getCurrentItem().getType() == Material.BARRIER) {
                    player.closeInventory();
                }
            }
            event.setCancelled(true);
        } else if (ChatColor.stripColor(event.getView().getTitle()).equalsIgnoreCase("Confirm")) {
            if (event.getCurrentItem() != null) {
                if (event.getCurrentItem().getType() == Material.RED_STAINED_GLASS_PANE) {
                    RevivalScreen revivalScreen = new RevivalScreen();
                    player.openInventory(revivalScreen.getInventory());
                } else if (event.getCurrentItem().getType() == Material.LIME_STAINED_GLASS_PANE) {
                    String playerName = ChatColor.stripColor(event.getClickedInventory().getItem(4).getItemMeta().getDisplayName());

                    Bukkit.getBanList(BanList.Type.NAME).pardon(playerName);

                    Lifesteal.justRevivedPlayers.add(playerName);

                    player.getAttribute(Attribute.MAX_HEALTH).setBaseValue(player.getAttribute(Attribute.MAX_HEALTH).getBaseValue() - 12);
                    player.sendMessage(ChatColor.GREEN + "Revived " + ChatColor.WHITE + playerName);

                    player.closeInventory();
                }
            }
            event.setCancelled(true);
        }

    }

}
