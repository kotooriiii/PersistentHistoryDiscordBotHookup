package com.github.kotooriiii.Discord4Java;

import sx.blah.discord.handle.obj.*;

public class ICommand {

    private IMessage IMessage;
    private String[] args;
    private String command;
    private String prefix;

    public ICommand(IMessage iMessage, String prefix, String command, String[] args){
        this.IMessage = iMessage;


        this.prefix  = prefix;
        this.command = command;
        this.args = args;
    }


    public IMessage getIMessage() {
        return IMessage;
    }


    public String[] getArgs() {
        return args;
    }



    public String getCommand() {
        return command;
    }



    public String getPrefix() {
        return prefix;
    }


}
