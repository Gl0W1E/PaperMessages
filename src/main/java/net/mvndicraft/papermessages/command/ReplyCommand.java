package net.mvndicraft.papermessages.command;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.*;
import net.kyori.adventure.text.Component;
import net.mvndicraft.papermessages.settings.PaperMessagesSettings;
import net.mvndicraft.papermessages.util.HashUtil;
import net.mvndicraft.papermessages.util.MessagingUtil;
import org.bukkit.entity.Player;

@CommandAlias("reply|r")
public class ReplyCommand extends BaseCommand
{
    @Default
    @Syntax("<content>")
    @CommandCompletion("@nothing")
    @Description("Reply to your previous message.")
    public static void onReply(Player player, String content)
    {
        if (!HashUtil.hasMessageHistory(player)) {
            player.sendMessage(Component.text(PaperMessagesSettings.getPrefix() + "§f§lYou have no message history!"));
            return;
        }
        if (!HashUtil.getLastMessaged(player).isOnline()) {
            player.sendMessage(Component.text(PaperMessagesSettings.getPrefix() + "§f§lThis player is offline."));
            return;
        }
        Player recipient =  HashUtil.getLastMessaged(player).getPlayer();

        if (recipient == null) {
            player.sendMessage(Component.text(""));
            return;
        }

        MessagingUtil.processMessage(player, recipient, content);
    }
}
