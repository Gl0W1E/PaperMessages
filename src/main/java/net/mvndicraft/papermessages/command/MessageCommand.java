package net.mvndicraft.papermessages.command;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.*;
import net.kyori.adventure.text.Component;
import net.mvndicraft.papermessages.settings.PaperMessagesSettings;
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
        Player pSender = player;
        String player_name = recipientName;
        if (!Bukkit.getOfflinePlayer(player_name).isOnline()) {
            pSender.sendMessage(PaperMessagesSettings.getPrefix() + "§6§lThis player is offline.");
            return;
        }
        Player pReceiver = Bukkit.getPlayer(player_name);
        MessagingUtil.processMessage(pSender, pReceiver, content);
    }
}
