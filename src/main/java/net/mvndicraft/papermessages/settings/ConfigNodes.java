package net.mvndicraft.papermessages.settings;

public enum ConfigNodes {
    VERSION(
            "version",
            "",
            "# This is the current version. Please do not edit."),
    SETTINGS("settings","",""),
    SETTINGS_PLUGIN_PREFIX(
            "settings.plugin_prefix",
            "&6&l[&f&lPM&6&l] ",
            ""),
    SETTINGS_MESSAGE_FORMAT_SENT(
            "settings.message_format_sent",
            "&cto &b%s&f: &6%s",
            "",
            "# The first %s is the recipient name the second %s is the message content."),
    SETTINGS_MESSAGE_FORMAT_RECEIVED(
            "settings.message_format_received",
            "&afrom &b%s&f: &6%s",
            "",
            "# The first %s is the sender name the second %s is the message content.");

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

