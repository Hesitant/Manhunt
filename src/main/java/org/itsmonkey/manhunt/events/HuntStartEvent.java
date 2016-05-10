package org.itsmonkey.manhunt.events;

import org.bukkit.Location;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * Created by JMac on 5/10/16.
 */
public class HuntStartEvent extends Event {

    public static final HandlerList HANDLER_LIST = new HandlerList();

    private Location plateLocation;

    public HuntStartEvent(Location plateLocation){
        this.plateLocation = plateLocation;
    }

    public HuntStartEvent(){}

    public static HandlerList getHandlerList(){
        return HANDLER_LIST;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLER_LIST;
    }

    public Location getPlateLocation() {
        return plateLocation;
    }
}
