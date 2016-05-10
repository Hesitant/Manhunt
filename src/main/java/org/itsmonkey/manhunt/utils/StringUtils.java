package org.itsmonkey.manhunt.utils;

import org.bukkit.ChatColor;

/**
 * Created by JMac on 5/10/16.
 */
public class StringUtils {

    public static String color(String msg){
        return ChatColor.translateAlternateColorCodes('&', msg);
    }

    public static String capitalize(final String line) {
        return Character.toUpperCase(line.charAt(0)) + line.substring(1);
    }

}
