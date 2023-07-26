package net.mvndicraft.papermessages.command;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.*;
import net.kyori.adventure.text.Component;
import net.mvndicraft.papermessages.util.MessagingUtil;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

@CommandAlias("whisper|w|message|msg|pm|dm")
public class MessageCommand extends BaseCommand
{
    @Default
    @Syntax("<recipient> <content>")
    @CommandCompletion("@players @nothing")
    @Description("send a private message to a player.")
    public void onMessage(Player player, String recipientName, String content)
    {
        Player recipient = Bukkit.getPlayer(recipientName);

        if (recipient == null) {
            player.sendMessage(Component.text("Player not found!"));
            return;
        }

        MessagingUtil.processMessage(player, recipient, content);
    }
}
