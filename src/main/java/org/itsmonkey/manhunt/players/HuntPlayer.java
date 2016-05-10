package org.itsmonkey.manhunt.players;

import com.alexandeh.glaedr.scoreboards.PlayerScoreboard;
import org.bukkit.entity.Player;

/**
 * Created by JMac on 5/10/16.
 */
public class HuntPlayer {

    /*
    Important game variables
     */
    private Player player;
    private PlayerScoreboard playerScoreboard;
    private boolean hunted;

    /*
    Hunted variables
     */
    private int secondsAsHunted;
    private int killsAsHunted;

    /*
    Hunter variables
     */
    private int killsAsHunter;

    public HuntPlayer(Player player) {
        this.player = player;
        this.hunted = false;
    }

    public Player getPlayer() {
        return player;
    }

    public boolean isHunted() {
        return hunted;
    }

    public void setHunted(boolean hunted) {
        this.hunted = hunted;
    }

    public int getSecondsAsHunted() {
        return secondsAsHunted;
    }

    public void setSecondsAsHunted(int secondsAsHunted) {
        this.secondsAsHunted = secondsAsHunted;
    }

    public int getKillsAsHunter() {
        return killsAsHunter;
    }

    public void setKillsAsHunter(int killsAsHunter) {
        this.killsAsHunter = killsAsHunter;
    }

    public int getKillsAsHunted() {
        return killsAsHunted;
    }

    public void setKillsAsHunted(int killsAsHunted) {
        this.killsAsHunted = killsAsHunted;
    }

    public PlayerScoreboard getPlayerScoreboard() {
        return PlayerScoreboard.getScoreboard(player);
    }

}
