package org.itsmonkey.manhunt.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.itsmonkey.manhunt.Manhunt;
import org.itsmonkey.manhunt.events.HuntEndEvent;

/**
 * Created by JMac on 5/10/16.
 */
public class EndCommand extends HuntCommand {

    public EndCommand(){
        setCommand("end");
        setUsage("end");
        setPermission("manhunt.commands.end");
        setArgs(1);
        setBoth();
    }

    @Override
    public void execute(CommandSender sender, String[] args) {

        if(!Manhunt.getInstance().isRunning()){
            sender.sendMessage(ChatColor.RED + "The hunt is not currently running!");
            return;
        }

        Manhunt.getInstance().setRunning(false);
        Bukkit.getPluginManager().callEvent(new HuntEndEvent(null));

    }
}
