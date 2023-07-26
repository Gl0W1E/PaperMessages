package net.mvndicraft.papermessages.util;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import net.mvndicraft.papermessages.settings.PaperMessagesSettings;
import org.bukkit.entity.Player;

public class MessagingUtil {

    public static void processMessage(Player sender, Player receiver, String content)
    {

        String prefix = PaperMessagesSettings.getPrefix();
        Component sentMsg = LegacyComponentSerializer.legacyAmpersand().deserialize(prefix + String.format(PaperMessagesSettings.getSentMessageFormat(), receiver.getName(), content));
        Component receivedMsg = LegacyComponentSerializer.legacyAmpersand().deserialize(prefix + String.format(PaperMessagesSettings.getReceivedMessageFormat(), sender.getName(), content));

        // Send messages to both players...
        sender.sendMessage(sentMsg);
        receiver.sendMessage(receivedMsg);

        // Add to last messaged HashMap...
        HashUtil.addLastMessaged(sender, receiver);

    }

}
