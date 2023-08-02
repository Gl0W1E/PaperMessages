package net.mvndicraft.papermessages.command;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.*;
import net.kyori.adventure.text.Component;
import net.mvndicraft.papermessages.settings.PaperMessagesSettings;
import net.mvndicraft.papermessages.util.HashUtil;
import net.mvndicraft.papermessages.util.MessagingUtil;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

@CommandAlias("ignore")
public class IgnoreCommand extends BaseCommand
{

    @Default
    @Syntax("<name>")
    @CommandCompletion("@nothing")
    @Description("Ignore annoying people")
    public static void onReply(Player player, String name)
    {
        if (Bukkit.getOfflinePlayer(name) == null) {
            player.sendMessage("boohoo player null");
            return;
        }
        if (!Bukkit.getOfflinePlayer(name).isOnline()) {
            player.sendMessage("boohoo player offline");
            return;
        }

        MessagingUtil.toggleIgnorePlayuh(player, Bukkit.getPlayer(name));
    }

}
