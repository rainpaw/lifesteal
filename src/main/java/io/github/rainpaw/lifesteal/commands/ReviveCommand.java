package io.github.rainpaw.lifesteal.commands;

import io.github.rainpaw.lifesteal.guis.RevivalScreen;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ReviveCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("(!) Only players can use that command!");
            return true;
        }
        Player player = (Player) sender;
        if (args.length > 0) {
            player.sendMessage("§c(!) Usage: /revive, /revive-player, /revive-gui");
            return true;
        }

        if (cmd.getName().equalsIgnoreCase("revive")) {
            RevivalScreen gui = new RevivalScreen();
            player.openInventory(gui.getInventory());
        }

        return true;
    }
}
