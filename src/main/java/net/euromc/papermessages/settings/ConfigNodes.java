package net.euromc.papermessages.settings;

public enum ConfigNodes {
    VERSION(
            "version",
            "",
            "# Current version number. DO NOT EDIT!"),
    SETTINGS("settings","",""),
    SETTINGS_PLUGIN_PREFIX("settings.plugin_prefix", "§1§e§lMESSAGE§1]§r ", "", "# Use the ''§'' Symbol instead of ''§'' For colors."),
    SETTINGS_MESSAGE_FORMAT_SENT("settings.message_format_sent", "§4to §9[PLAYER] §f>> §7[MESSAGE]", "", "# The text [PLAYER] will be replaced with the receiver's name.", "# The text [MESSAGE] will be replaced with the message content."),
    SETTINGS_MESSAGE_FORMAT_RECEIVED("settings.message_format_received", "§4to §9[PLAYER] §f>> §7[MESSAGE]", "", "# The text [PLAYER] will be replaced with the sender's name.", "# The text [MESSAGE] will be replaced with the message content.");

    private final String Root;
    private final String Default;
    private final String[] comments;

    ConfigNodes(String root, String def, String... comments)
    {

        this.Root = root;
        this.Default = def;
        this.comments = comments;
    }

    /**
     * Retrieves the root for a config option
     *
     * @return The root for a config option
     */
    public String getRoot()
    {

        return Root;
    }

    /**
     * Retrieves the default value for a config path
     *
     * @return The default value for a config path
     */
    public String getDefault()
    {

        return Default;
    }

    /**
     * Retrieves the comment for a config path
     *
     * @return The comments for a config path
     */
    public String[] getComments()
    {
        if (comments != null) {
            return comments;
        }

        String[] comments = new String[1];
        comments[0] = "";
        return comments;
    }
}

