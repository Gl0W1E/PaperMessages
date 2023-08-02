package net.mvndicraft.papermessages.util;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import net.mvndicraft.papermessages.settings.PaperMessagesSettings;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class MessagingUtil {

    public static void processMessage(Player sender, Player receiver, String content)
    {

        TextComponent prefix = LegacyComponentSerializer.legacyAmpersand().deserialize(PaperMessagesSettings.getPrefix());
        Component sentMsg = LegacyComponentSerializer.legacyAmpersand().deserialize(prefix + String.format(PaperMessagesSettings.getSentMessageFormat(), receiver.getName(), content));
        Component receivedMsg = LegacyComponentSerializer.legacyAmpersand().deserialize(prefix + String.format(PaperMessagesSettings.getReceivedMessageFormat(), sender.getName(), content));

        if (!hasIgnored(receiver, sender)) {
            HashUtil.addLastMessaged(sender, receiver);
            sender.sendMessage(sentMsg);
            receiver.sendMessage(receivedMsg);
        }

    }

    public static boolean hasIgnored(Player receiver, Player sender)
    {
        PersistentDataContainer rPDC = receiver.getPersistentDataContainer();
        NamespacedKey ignoreKey = new NamespacedKey("ignore", sender.getUniqueId().toString());
        return rPDC.has(ignoreKey, PersistentDataType.BYTE) && rPDC.get(ignoreKey, PersistentDataType.BYTE) == 1;
    }

    public static void toggleIgnorePlayuh(Player receiver, Player... targets) {
        PersistentDataContainer rPdc = receiver.getPersistentDataContainer();
        String uuidStr = receiver.getUniqueId().toString();
        boolean hasPlayerIgnored;
        for(int i = 0; i < targets.length; ++i) {
            hasPlayerIgnored = hasIgnored(receiver, targets[i]);
            rPdc.set(new NamespacedKey("ignored", targets[i].getUniqueId().toString()), PersistentDataType.BYTE, (byte) (hasPlayerIgnored ? 1 : 0));
        }
    }

}
