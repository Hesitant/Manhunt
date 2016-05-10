package org.itsmonkey.manhunt;


import com.alexandeh.glaedr.Glaedr;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.itsmonkey.manhunt.listeners.HuntListener;
import org.itsmonkey.manhunt.listeners.PlayerListener;
import org.itsmonkey.manhunt.players.HuntPlayer;
import org.itsmonkey.manhunt.players.PlayerManager;

/**
 * Created by JMac on 5/10/16.
 */
public class Manhunt extends JavaPlugin {

    private static Manhunt instance;
    private Glaedr glaedr;

    private PlayerManager playerManager;

    private boolean running = false;
    private HuntPlayer huntPlayer;
    private Location plateLocation;

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();

        this.glaedr = new Glaedr(this, getConfig().getString("Scoreboard.title"), true);
        this.playerManager = new PlayerManager();

        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new PlayerListener(), this);
        pm.registerEvents(new HuntListener(), this);

    }

    @Override
    public void onDisable() {

    }

    public static Manhunt getInstance() {
        return instance;
    }

    public PlayerManager getPlayerManager() {
        return playerManager;
    }

    public Glaedr getGlaedr() {
        return glaedr;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public HuntPlayer getHuntPlayer() {
        return huntPlayer;
    }

    public void setHuntPlayer(HuntPlayer huntPlayer) {
        this.huntPlayer = huntPlayer;
    }

    public Location getPlateLocation() {
        return plateLocation;
    }

    public void setPlateLocation(Location plateLocation) {
        this.plateLocation = plateLocation;
    }
}
