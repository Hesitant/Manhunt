package org.itsmonkey.manhunt.listeners;

import com.alexandeh.glaedr.scoreboards.Entry;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.itsmonkey.manhunt.Manhunt;
import org.itsmonkey.manhunt.events.HuntEndEvent;
import org.itsmonkey.manhunt.events.HuntStartEvent;
import org.itsmonkey.manhunt.events.PlayerHuntedEvent;
import org.itsmonkey.manhunt.players.HuntPlayer;
import org.itsmonkey.manhunt.tasks.HuntedLocationBroadcastTask;
import org.itsmonkey.manhunt.tasks.HuntedTask;
import org.itsmonkey.manhunt.utils.Lang;

/**
 * Created by JMac on 5/10/16.
 */
public class HuntListener implements Listener {

    @EventHandler
    public void onHunterDeath(PlayerDeathEvent event) {
        HuntPlayer huntPlayer = Manhunt.getInstance().getPlayerManager().getPlayer(event.getEntity());
        HuntPlayer huntKiller = Manhunt.getInstance().getPlayerManager().getPlayer(event.getEntity().getKiller());

        if (!huntPlayer.isHunted()) return;

        Bukkit.getPluginManager().callEvent(new PlayerHuntedEvent(huntPlayer, huntKiller));
    }

    @EventHandler
    public void onHuntStart(HuntStartEvent event) {

    }

    @EventHandler
    public void onPressPlate(PlayerInteractEvent event) {

        if (event.getAction() != Action.PHYSICAL) return;
        if (!Manhunt.getInstance().isRunning()) return;
        if (!(event.getClickedBlock().getLocation().equals(Manhunt.getInstance().getPlateLocation()))) return;
        if (event.getClickedBlock().getType() != Material.STONE_PLATE) return;


    }

    @EventHandler
    public void onHunterCreate(PlayerHuntedEvent event) {
        /*
        Set attributes for the previously hunted player
         */
        event.getHuntVictim().setHunted(false);
        event.getHuntVictim().getPlayerScoreboard().getEntry("hunted-timer").cancel();


        /*
        Set attributes for the new hunter
         */
        event.getHuntKiller().setHunted(true);
        new Entry("hunted-timer", event.getHuntKiller().getPlayerScoreboard())
                .setTime(1200)
                .setCountdown(true)
                .setText("&6&lHunted Timer: &e")
                .send();
        new HuntedTask(event.getHuntKiller()).runTaskLater(Manhunt.getInstance(), 20 * (60 * 20));
        new HuntedLocationBroadcastTask(event.getHuntKiller()).runTaskTimer(Manhunt.getInstance(), 0, 20 * 15);
    }

    @EventHandler
    public void onHuntWin(HuntEndEvent event) {

        /*
        Game was ended through a command
         */
        if (event.getWinner() == null) {
            Bukkit.broadcastMessage(Lang.HUNT_FORCE_ENDED.getMessage());
            return;
        }

        if (!event.getWinner().isHunted()) return;

        Bukkit.broadcastMessage(Lang.HUNT_ENDED.getMessage().replace("{player}", event.getWinner().getPlayer().getName()));
        event.getWinner().setHunted(false);
        Manhunt.getInstance().setRunning(false);

    }

    @EventHandler
    public void onCompassInteract(PlayerInteractEvent event) {
        HuntPlayer player = Manhunt.getInstance().getHuntPlayer();

        if (player == null) return;

        if (!event.getAction().toString().contains("RIGHT")) return;

        if (event.getPlayer().getItemInHand().getType() != Material.COMPASS) return;

        event.getPlayer().setCompassTarget(player.getPlayer().getLocation());
    }

}
