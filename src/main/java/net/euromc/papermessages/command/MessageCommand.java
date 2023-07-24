package net.euromc.papermessages.command;

import net.euromc.papermessages.MessagesMain;
import net.euromc.papermessages.settings.PaperMsgSettings;
import net.euromc.papermessages.util.PaperMsgUtil;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class MessageCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {

        if (!(commandSender instanceof Player)) {
            MessagesMain.instance.getLogger().info(PaperMsgSettings.getPrefix() + "You must run this command as a player.");
            return true;
        }

        Player pSender = (Player) commandSender;
        if (args.length < 2) {
            pSender.sendMessage(PaperMsgSettings.getPrefix() + "§5§l/msg <player> <content>");
            return true;
        }

        String player_name = args[0];
        if (!Bukkit.getOfflinePlayer(player_name).isOnline()) {
            pSender.sendMessage(PaperMsgSettings.getPrefix() + "§6§lThis player is offline.");
            return true;
        }

        Player pReceiver = Bukkit.getPlayer(player_name);
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < args.length; i++){

            if (i != 0) {
                builder.append(args[i]);
                builder.append(" ");
            }
        }

        String finalMsg = builder.toString();
        PaperMsgUtil.processMessage(pSender, pReceiver, finalMsg);

        return false;
    }
}
