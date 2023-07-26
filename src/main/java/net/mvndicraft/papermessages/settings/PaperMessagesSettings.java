package net.mvndicraft.papermessages.settings;

public class PaperMessagesSettings {

    public static String getPrefix() {
        return Settings.getString(ConfigNodes.SETTINGS_PLUGIN_PREFIX);
    }

    public static String getSentMessageFormat() {
        return Settings.getString(ConfigNodes.SETTINGS_MESSAGE_FORMAT_SENT);
    }

    public static String getReceivedMessageFormat() {
        return Settings.getString(ConfigNodes.SETTINGS_MESSAGE_FORMAT_RECEIVED);
    }
}
