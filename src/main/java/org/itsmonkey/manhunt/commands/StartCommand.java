package org.itsmonkey.manhunt.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.itsmonkey.manhunt.Manhunt;
import org.itsmonkey.manhunt.events.HuntStartEvent;
import org.itsmonkey.manhunt.utils.StringUtils;

/**
 * Created by JMac on 5/10/16.
 */
public class StartCommand extends HuntCommand {

    public StartCommand(){
        setBoth();
        setPermission("manhunt.commands.start");
        setArgs(1);
        setUsage("start");
        setCommand("start");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {

        if(Manhunt.getInstance().isRunning()){
            sender.sendMessage(ChatColor.RED + "The manhunt is already running!\nUse /manhunt end to end it");
            return;
        }

        Bukkit.getPluginManager().callEvent(new HuntStartEvent());
        sender.sendMessage(StringUtils.color("&6&lYou have force-started the manhunt!"));
    }
}
