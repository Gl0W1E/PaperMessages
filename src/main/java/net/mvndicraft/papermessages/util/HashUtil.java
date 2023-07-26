package net.mvndicraft.papermessages.util;

import org.bukkit.OfflinePlayer;

import java.util.HashMap;

public class HashUtil {

    // First Player is the sender of the /reply command, second Player is the receiver...
    public static HashMap<OfflinePlayer, OfflinePlayer> historyHash = new HashMap<>();

    public static OfflinePlayer getLastMessaged(OfflinePlayer sender)
    {
        return historyHash.get(sender);
    }

    public static void addLastMessaged(OfflinePlayer sender, OfflinePlayer receiver)
    {
        if (hasMessageHistory(sender)) {
            historyHash.remove(sender);
        }
        historyHash.put(sender, receiver);
    }

    public static boolean hasMessageHistory(OfflinePlayer sender)
    {
        return historyHash.containsKey(sender);
    }

}
