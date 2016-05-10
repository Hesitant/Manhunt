package org.itsmonkey.manhunt.players;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by JMac on 5/10/16.
 */
public class PlayerManager {

    private Map<UUID, HuntPlayer> players = new HashMap<>();

    public HuntPlayer getPlayer(Player player){
        return players.get(player.getUniqueId());
    }

    public void load(Player player){
        HuntPlayer huntPlayer = new HuntPlayer(player);

        players.put(player.getUniqueId(), huntPlayer);
    }

    public void unload(Player player){

    }

    public Map<UUID, HuntPlayer> getPlayers(){
        return players;
    }


}
