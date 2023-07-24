package net.euromc.papermessages;

import net.euromc.papermessages.command.MessageCommand;
import net.euromc.papermessages.command.ReplyCommand;
import net.euromc.papermessages.settings.Settings;
import org.bukkit.plugin.java.JavaPlugin;

public final class MessagesMain extends JavaPlugin {
    public static MessagesMain instance;

    public String getVersion() {
        return instance.getPluginMeta().getVersion();
    }

    @Override
    public void onEnable() {
        instance = this;
        Settings.loadConfig();
        getCommand("message").
        getCommand("reply").setExecutor(new ReplyCommand());
    }

    @Override
    public void onDisable() {
        // The plugin has fallen. Millions must fix bug.
    }
}
