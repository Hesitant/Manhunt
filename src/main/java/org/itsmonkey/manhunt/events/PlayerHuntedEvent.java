package org.itsmonkey.manhunt.events;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.itsmonkey.manhunt.players.HuntPlayer;

/**
 * Created by JMac on 5/10/16.
 */
public class PlayerHuntedEvent extends Event {

    public static final HandlerList HANDLER_LIST = new HandlerList();

    private HuntPlayer huntVictim;
    private HuntPlayer huntKiller;

    public PlayerHuntedEvent(HuntPlayer huntVictim, HuntPlayer huntKiller){
        this.huntVictim = huntVictim;
        this.huntKiller = huntKiller;
    }

    public static HandlerList getHandlerList(){
        return HANDLER_LIST;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLER_LIST;
    }

    public HuntPlayer getHuntVictim() {
        return huntVictim;
    }

    public HuntPlayer getHuntKiller() {
        return huntKiller;
    }
}
