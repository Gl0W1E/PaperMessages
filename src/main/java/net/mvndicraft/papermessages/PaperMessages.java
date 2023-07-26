package net.mvndicraft.papermessages;

import co.aikar.commands.PaperCommandManager;
import net.mvndicraft.papermessages.command.MessageCommand;
import net.mvndicraft.papermessages.command.PaperMessagesCommand;
import net.mvndicraft.papermessages.command.ReplyCommand;
import net.mvndicraft.papermessages.settings.Settings;
import org.bukkit.plugin.java.JavaPlugin;

public final class PaperMessages extends JavaPlugin {
    public static PaperMessages instance;

    @Override
    public void onEnable() {
        instance = this;

        Settings.loadConfig();
        PaperCommandManager manager = new PaperCommandManager(instance);
        manager.registerCommand(new PaperMessagesCommand());
        manager.registerCommand(new MessageCommand());
        manager.registerCommand(new ReplyCommand());

        getLogger().info("enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("disabled!");
    }

    public static PaperMessages getInstance()
    {
        return instance;
    }
}
