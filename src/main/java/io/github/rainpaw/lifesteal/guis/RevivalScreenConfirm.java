package io.github.rainpaw.lifesteal.guis;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;
import java.util.List;

public class RevivalScreenConfirm implements InventoryHolder {

    private Inventory inv;

    public RevivalScreenConfirm(OfflinePlayer revivePlayer) {
        inv = Bukkit.createInventory(this, 9, ChatColor.RED + "Confirm");
        init(revivePlayer);
    }

    private void init(OfflinePlayer whoToRevive) {
        //Confirm
        ItemStack revive = new ItemStack(Material.LIME_STAINED_GLASS_PANE);
        ItemMeta reviveMeta = revive.getItemMeta();
        reviveMeta.setDisplayName(ChatColor.GREEN + "Confirm");
        revive.setItemMeta(reviveMeta);
        inv.setItem(0, revive);

        //Player Head
        ItemStack playerHead = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta playerHeadMeta = (SkullMeta) playerHead.getItemMeta();

        playerHeadMeta.setDisplayName(ChatColor.YELLOW + whoToRevive.getName());
        playerHeadMeta.setOwnerProfile(whoToRevive.getPlayerProfile());

        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.GRAY + whoToRevive.getUniqueId().toString());
        playerHeadMeta.setLore(lore);

        playerHead.setItemMeta(playerHeadMeta);
        inv.setItem(4, playerHead);

        //Cancel
        ItemStack cancel = new ItemStack(Material.RED_STAINED_GLASS_PANE);
        ItemMeta cancelMeta = cancel.getItemMeta();
        cancelMeta.setDisplayName(ChatColor.RED + "Cancel");
        cancel.setItemMeta(cancelMeta);
        inv.setItem(8, cancel);
    }


    @Override
    public Inventory getInventory() {
        return inv;
    }
}
