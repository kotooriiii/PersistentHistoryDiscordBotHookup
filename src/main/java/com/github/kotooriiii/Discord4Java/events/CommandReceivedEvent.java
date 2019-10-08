package com.github.kotooriiii.Discord4Java.events;

import com.github.kotooriiii.Discord4Java.ICommand;
import sx.blah.discord.api.events.Event;
import sx.blah.discord.handle.obj.IMessage;
import sx.blah.discord.handle.obj.IUser;

public class CommandReceivedEvent extends Event {

    private IMessage msgObject;
    private String prefix;
    private String command;
    private String[] args;


    private final long messageID;

    public CommandReceivedEvent(ICommand cmdObj) {

        this.msgObject = cmdObj.getIMessage();
        this.prefix = cmdObj.getPrefix();
        this.command = cmdObj.getCommand();
        this.args = cmdObj.getArgs();
        this.messageID = cmdObj.getIMessage().getLongID();
    }


    public String getPrefix() {
        return this.prefix;
    }

    public IUser getAuthor() {
        return this.msgObject == null ? null : this.msgObject.getAuthor();
    }

    public IMessage getMsgObject() {
        return msgObject;
    }

    public String getCommand() {
        return command;
    }

    public String[] getArgs() {
        return args;
    }

    public long getMessageID() {
        return this.messageID;
    }


}
