package io.github.rainpaw.lifesteal;

import io.github.rainpaw.lifesteal.commands.ReviveCommand;
import io.github.rainpaw.lifesteal.commands.WithdrawCommand;
import io.github.rainpaw.lifesteal.events.*;
import io.github.rainpaw.lifesteal.items.ItemManager;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.logging.Logger;

public final class Lifesteal extends JavaPlugin implements Listener {
    public static ArrayList<String> justRevivedPlayers = new ArrayList<>();

    @Override
    public Logger getLogger() {
        return super.getLogger();
    }

    @Override
    public void onEnable() {
        ItemManager.createRecipes();

        getServer().getPluginManager().registerEvents(new OnPlayerDeath(), this);
        getServer().getPluginManager().registerEvents(new HeartConsume(), this);
        getServer().getPluginManager().registerEvents(new CraftWithCustomItem(), this);
        getServer().getPluginManager().registerEvents(new RevivalScreenListener(), this);
        getServer().getPluginManager().registerEvents(new WardenKilled(), this);
        getServer().getPluginManager().registerEvents(new PlayerJoinAfterRevive(), this);

        getCommand("revive").setExecutor(new ReviveCommand());
        getCommand("withdraw").setExecutor(new WithdrawCommand());

        getLogger().info("Plugin is enabled.");
    }
}
