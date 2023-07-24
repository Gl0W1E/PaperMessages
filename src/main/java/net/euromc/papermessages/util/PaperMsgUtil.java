package net.euromc.papermessages.util;

import net.euromc.papermessages.settings.PaperMsgSettings;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

public class PaperMsgUtil {

    public static void processMessage(Player sender, Player receiver, String content) {

        // Modify Strings...
        String sentMsg = PaperMsgSettings.getSentMessageFormat().replace("[PLAYER]", receiver.getName()).replace("[MESSAGE]", content);
        String receivedMsg = PaperMsgSettings.getSentMessageFormat().replace("[PLAYER]", sender.getName()).replace("[MESSAGE]", content);
        String prefix = PaperMsgSettings.getPrefix();

        // Send messages to both players...
        sender.sendMessage(prefix + sentMsg);
        receiver.sendMessage(prefix + receivedMsg);

        // Add to last messaged HashMap...
        HashUtil.addLastMessaged(sender, receiver);

    }

}
