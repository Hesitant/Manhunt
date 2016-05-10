package org.itsmonkey.manhunt.tasks;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;
import org.itsmonkey.manhunt.events.HuntEndEvent;
import org.itsmonkey.manhunt.players.HuntPlayer;

/**
 * Created by JMac on 5/10/16.
 */
public class HuntedTask extends BukkitRunnable {

    private HuntPlayer hunted;

    public HuntedTask(HuntPlayer hunted){
        this.hunted = hunted;
    }

    @Override
    public void run() {
        Bukkit.getPluginManager().callEvent(new HuntEndEvent(hunted));
    }
}
