package org.itsmonkey.manhunt.commands;

import org.bukkit.command.CommandSender;

/**
 * Created by JMac on 5/10/16.
 */
public abstract class HuntCommand {

    private String permission;
    private int args;
    private boolean console;
    private boolean player;
    private String usage;
    private String command;

    public abstract void execute(CommandSender sender, String[] args);

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public int getArgs() {
        return args;
    }

    public void setArgs(int args) {
        this.args = args;
    }

    public boolean isConsole() {
        return console;
    }

    public void setConsole() {
        this.console = true;
        this.player = false;
    }

    public void setBoth(){
        this.player = false;
        this.console = false;
    }

    public boolean isBoth(){
        return player && console;
    }

    public String getUsage() {
        return usage;
    }

    public void setUsage(String usage) {
        this.usage = usage;
    }

    public boolean isPlayer() {
        return player;
    }

    public void setPlayer() {
        this.player = true;
        this.console = false;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

}
