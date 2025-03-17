package io.github.rainpaw.lifesteal.commands;

import io.github.rainpaw.lifesteal.items.ItemManager;
import org.bukkit.attribute.Attribute;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class WithdrawCommand implements CommandExecutor {

    // /withdraw x: turns a heart into a heart item.
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("(!) Only players can use that command!");
            return true;
        }
        Player player = (Player) sender;

        if (cmd.getName().equalsIgnoreCase("withdraw")) {
            if (args.length == 1) {
                try {
                    double heartAmount = Double.parseDouble(args[0]);
                    if ((heartAmount * 2) > (player.getAttribute(Attribute.MAX_HEALTH).getBaseValue() - 2)) {
                        heartAmount = (player.getAttribute(Attribute.MAX_HEALTH).getBaseValue() - 2) / 2;
                    }

                    ItemStack heartItem = new ItemStack(ItemManager.getHeart());
                    heartItem.setAmount((int) heartAmount);

                    player.getInventory().addItem(heartItem);
                    player.getAttribute(Attribute.MAX_HEALTH).setBaseValue(player.getAttribute(Attribute.MAX_HEALTH).getBaseValue() - (Math.round(heartAmount) * 2));
                    player.sendMessage("§aWithdrew §f" + Math.round(heartAmount) + (Math.round(heartAmount) == 1 ? " §aheart." : " §ahearts."));

                    if (player.getAttribute(Attribute.MAX_HEALTH).getBaseValue() < player.getHealth()) {
                        player.setHealth(player.getAttribute(Attribute.MAX_HEALTH).getBaseValue());
                    }
                } catch (IllegalArgumentException e){
                    player.sendMessage("§c(!) You must specify a heart amount to withdraw!");
                }
            } else {
                player.sendMessage("§c(!) You must specify a heart amount to withdraw!");
            }
        }

        return true;
    }
}
