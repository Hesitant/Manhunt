package org.itsmonkey.manhunt.utils;

import org.bukkit.configuration.file.YamlConfiguration;
import org.itsmonkey.manhunt.Manhunt;

import java.io.File;
import java.io.IOException;

/**
 * Created by JMac on 5/10/16.
 */
public enum  Lang {

    PLAYER_NOT_ONLINE("PLAYER_NOT_ONLINE", "&cThat player is not online!"),
    NO_AVAILABLE_ARENAS("NO_AVAILABLE_ARENAS", "&cThere are no available arenas"),
    PLAYER_ONLY("PLAYER_ONLY", "&cOnly players can use this command"),
    CONSOLE_ONLY("PLAYER_ONLY", "&cOnly console can use this command"),
    NO_PERMISSION("NO_PERMISSION", "&cYou do not have permission to use this command"),

    HUNT_FORCE_ENDED("HUNT_FORCE_ENDED", "&cThe hunt has been force-ended"),

    HUNT_STARTED("HUNT_STARTED", "&eThe hunt has started, find the pressure plate at spawn to become the hunted!"),
    HUNT_ENDED("HUNT_ENDED", "&eThe hunt has ended, {player} has won the hunt!"),

    HUNT_PLAYER_LOCATION("HUNT_PLAYER_LOCATION", "&eThe player to be hunted is at &6{x}, {y}, {z}"),
    ;

    private String path;
    private String message;

    Lang(String path, String message){
        this.path = path;
        this.message = message;
    }

    public static void load(){
        File file = new File(Manhunt.getInstance().getDataFolder(), "lang.yml");
        YamlConfiguration config = YamlConfiguration.loadConfiguration(file);
        for(Lang lang : values()) {
            if(!config.isSet(lang.getPath())) {
                config.set(lang.getPath(), lang.getMessage());
            }
            else {
                lang.setMessage(config.getString(lang.getPath()));
            }
        }
        try {
            config.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getPath() {
        return path;
    }

    public String getMessage() {
        return StringUtils.color(message);
    }

    public void setMessage(String message){
        this.message = message;
    }

}
