package org.itsmonkey.manhunt.events;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.itsmonkey.manhunt.players.HuntPlayer;

/**
 * Created by JMac on 5/10/16.
 */
public class HuntEndEvent extends Event {

    public static final HandlerList HANDLER_LIST = new HandlerList();

    private HuntPlayer winner;

    public HuntEndEvent(HuntPlayer winner) {
        this.winner = winner;
    }

    public static HandlerList getHandlerList() {
        return HANDLER_LIST;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLER_LIST;
    }

    public HuntPlayer getWinner() {
        return winner;
    }
}
