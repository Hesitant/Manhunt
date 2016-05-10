package org.itsmonkey.manhunt.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.itsmonkey.manhunt.Manhunt;

/**
 * Created by JMac on 5/10/16.
 */
public class PlayerListener implements Listener {

    @EventHandler (priority = EventPriority.LOWEST)
    public void onJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        Manhunt.getInstance().getPlayerManager().load(player);
    }

    @EventHandler (priority = EventPriority.LOWEST)
    public void onLeave(PlayerJoinEvent event){
        Player player = event.getPlayer();
        Manhunt.getInstance().getPlayerManager().load(player);
    }

}
