package org.itsmonkey.manhunt.tasks;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.scheduler.BukkitRunnable;
import org.itsmonkey.manhunt.players.HuntPlayer;
import org.itsmonkey.manhunt.utils.Lang;

/**
 * Created by JMac on 5/10/16.
 */
public class HuntedLocationBroadcastTask extends BukkitRunnable {

    private HuntPlayer huntPlayer;

    public HuntedLocationBroadcastTask(HuntPlayer huntPlayer){
        this.huntPlayer = huntPlayer;
    }

    @Override
    public void run() {

        if(!huntPlayer.isHunted()) cancel();

        Location loc = huntPlayer.getPlayer().getLocation();
        Bukkit.broadcastMessage(
                Lang.HUNT_PLAYER_LOCATION.getMessage()
                .replace("{x}", loc.getBlockX() + "")
                .replace("{y}", loc.getBlockY() + "")
                .replace("{z}", loc.getBlockZ() + "")
        );
    }
}
