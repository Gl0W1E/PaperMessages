package net.mvndicraft.papermessages.command;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.*;
import net.kyori.adventure.text.Component;
import net.mvndicraft.papermessages.PaperMessages;
import net.mvndicraft.papermessages.settings.Settings;
import org.bukkit.command.CommandSender;

@CommandAlias("papermessages")
public class PaperMessagesCommand extends BaseCommand
{
    @Default
    @Description("Lists the version of the plugin.")
    public static void onPaperMessages(CommandSender player)
    {
        player.sendMessage(Component.text(PaperMessages.getInstance().toString()));
    }

    @Subcommand("reload") @CommandPermission("papermessages.admin")
    @Description("Realods the plugin config.")
    public static void onReload(CommandSender player)
    {
        Settings.loadConfig();
        player.sendMessage(Component.text(PaperMessages.getInstance().getName() + " reloaded!"));
    }
}
