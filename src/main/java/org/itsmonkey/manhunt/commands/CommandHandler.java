package org.itsmonkey.manhunt.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.itsmonkey.manhunt.utils.Lang;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by JMac on 5/10/16.
 */
public class CommandHandler implements CommandExecutor {

    private Map<String, HuntCommand> commands = new HashMap<>();

    public CommandHandler() {

        commands.put("start", new StartCommand());
        commands.put("end", new EndCommand());
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        String name = cmd.getName().toLowerCase();

        if (commands.containsKey(name)) {
            final HuntCommand command = commands.get(name);

            if (command.getPermission() != null && !sender.hasPermission(command.getPermission())) {
                sender.sendMessage(Lang.NO_PERMISSION.getMessage());
                return true;
            }

            if(!command.isBoth()){
                if (command.isConsole() && sender instanceof Player) {
                    sender.sendMessage(Lang.CONSOLE_ONLY.getMessage());
                    return true;
                }

                if (command.isPlayer() && sender instanceof ConsoleCommandSender) {
                    sender.sendMessage(Lang.PLAYER_ONLY.getMessage());
                    return true;
                }
            }

            if (args.length < command.getArgs()) {
                sender.sendMessage(ChatColor.RED + "Usage: /manhunt " + command.getUsage());
                return true;
            }

            command.execute(sender, args);
            return true;
        }
        return false;
    }

    public Map<String, HuntCommand> getCommands() {
        return commands;
    }

}
