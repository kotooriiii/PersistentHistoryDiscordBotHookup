package com.github.kotooriiii.Discord4Java.events.Listener;

import com.github.kotooriiii.Discord4Java.ICommand;
import com.github.kotooriiii.Discord4Java.events.CommandReceivedEvent;
import com.github.kotooriiii.PersistentHistoryBot;
import sx.blah.discord.api.events.EventSubscriber;
import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;
import sx.blah.discord.handle.obj.IChannel;
import sx.blah.discord.handle.obj.IMessage;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MessageListener  {

    @EventSubscriber
    public void onMessageReceived(MessageReceivedEvent e){
        IMessage msgObject = e.getMessage();
        IChannel channel = e.getChannel();
        String msg = e.getMessage().getContent();
        boolean command_prefix = msg.startsWith(PersistentHistoryBot.prefix);


       if(command_prefix){

           String cmd = "";

           msg = msg.substring(PersistentHistoryBot.prefix.length());

           String[] temparray = msg.split(" ");

           List<String> templist = new LinkedList<String>(Arrays.asList(temparray));

           if(templist.isEmpty()){
               return;
           }

           if (!templist.isEmpty()) {
               cmd = templist.get(0);
               templist.remove(0);
           }

           String[] args = templist.toArray(new String[templist.toArray().length]);




           ICommand command = new ICommand(msgObject, PersistentHistoryBot.prefix, cmd, args);

           CommandReceivedEvent cmdEvent = new CommandReceivedEvent(command);
           PersistentHistoryBot.dispatcher.dispatch(cmdEvent);

       }

    }



}
