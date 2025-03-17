package io.github.rainpaw.lifesteal.guis;

import org.bukkit.*;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.*;

public class RevivalScreen implements InventoryHolder {

    private Inventory inv;

    public RevivalScreen() {
        inv = Bukkit.createInventory(this, 54, ChatColor.RED + "Revive Player");
        init();
    }

    private void init() {
        ItemStack item;

        // Border Item
        ItemStack paneItem = new ItemStack(Material.GRAY_STAINED_GLASS_PANE, 1);
        ItemMeta paneItemMeta = paneItem.getItemMeta();
        paneItemMeta.setDisplayName("§f");
        paneItem.setItemMeta(paneItemMeta);

        item = paneItem;

        // Border First Row
        for (int i = 0; i < 9; i++) {
            inv.setItem(i, item);
        }

        // Border Middle Rows
        for (int i = 0; i < 4; i++) {
            inv.setItem(9*(i+1), item);
            inv.setItem((9*(i+1))+8, item);
        }

        // Border Last Row
        for (int i = 0; i < 9; i++) {
            inv.setItem(i+45, item);
        }


        Set<OfflinePlayer> playerSet = Bukkit.getServer().getBannedPlayers();
        ArrayList<OfflinePlayer> playerList = new ArrayList<>(playerSet);
        for (OfflinePlayer player : playerList) {
            if (Bukkit.getServer().getBanList(BanList.Type.NAME).getBanEntry(player.getName()).getReason() != null) {
                if (Objects.equals(Bukkit.getServer().getBanList(BanList.Type.NAME).getBanEntry(player.getName()).getReason(), "You have been banned because you lost all your hearts!")) {

                    ItemStack playerHead = new ItemStack(Material.PLAYER_HEAD, 1);
                    SkullMeta meta = (SkullMeta) playerHead.getItemMeta();

                    meta.setDisplayName(ChatColor.YELLOW + player.getName());

                    List<String> lore = new ArrayList<>();
                    lore.add("§7Click to revive §e§o" + player.getName() + ".");
                    lore.add(ChatColor.GRAY + player.getUniqueId().toString());
                    meta.setLore(lore);

                    meta.setOwnerProfile(player.getPlayerProfile());

                    playerHead.setItemMeta(meta);

                    inv.setItem(inv.firstEmpty(), playerHead);

                }
            }
        }
    }

    @Override
    public Inventory getInventory() {
        return inv;
    }
}
