package net.euromc.papermessages.command;

import net.euromc.papermessages.MessagesMain;
import net.euromc.papermessages.settings.PaperMsgSettings;
import net.euromc.papermessages.util.HashUtil;
import net.euromc.papermessages.util.PaperMsgUtil;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class ReplyCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {

        if (!(commandSender instanceof Player)) {
            MessagesMain.instance.getLogger().info(PaperMsgSettings.getPrefix() + "You must run this command as a player.");
            return true;
        }

        Player pReplier = (Player) commandSender;
        if (args.length < 1) {
            pReplier.sendMessage(PaperMsgSettings.getPrefix() + "§5§l/r <content>");
            return true;
        }

        if (!HashUtil.hasMessageHistory(pReplier)) {
            pReplier.sendMessage(PaperMsgSettings.getPrefix() + "§f§lYou have no message history!");
            return true;
        }

        if (!HashUtil.getLastMessaged(pReplier).isOnline()) {
            pReplier.sendMessage(PaperMsgSettings.getPrefix() + "§f§lThis player is offline.");
            return true;
        }

        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < args.length; i++){
            builder.append(args[i]);
            builder.append(" ");
        }

        String finalMsg = builder.toString();
        OfflinePlayer pReceiver =  HashUtil.getLastMessaged(pReplier);
        PaperMsgUtil.processMessage(pReplier, pReceiver.getPlayer(), finalMsg);

        return false;
    }
}
