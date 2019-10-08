package com.github.kotooriiii.Discord4Java.events.Listener;

import com.github.kotooriiii.Discord4Java.events.CommandReceivedEvent;
import com.github.kotooriiii.PersistentHistoryBot;
import org.apache.commons.lang.StringUtils;
import sx.blah.discord.api.events.EventSubscriber;
import sx.blah.discord.handle.obj.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import static com.github.kotooriiii.Discord4Java.util.util.isStaff;

public class BulkDeletionListener {

    @EventSubscriber
    public void onCommandReceive(CommandReceivedEvent e) {

        IMessage msgObject = e.getMsgObject();
        IChannel channel = msgObject.getChannel();
        IUser user = msgObject.getAuthor();
        String cmd = e.getCommand();
        String[] args = e.getArgs();

        if (isStaff(user, channel)){
            if(cmd.equalsIgnoreCase("ph")){

                if(args.length == 0){
                    channel.sendMessage("Here are the following commands: ");
                    channel.sendMessage("cmd: " + PersistentHistoryBot.prefix + "ph delete <amount>");
                    return;
                }

                if(args[0].equalsIgnoreCase("delete")){

                    if(args.length == 2){

                        if(StringUtils.isNumeric(args[1])){

                            LocalDateTime instant = msgObject.getTimestamp();
                            LocalDateTime early = instant.minusWeeks(1).minusDays(5);
                            List<IMessage> messages = Arrays.asList(channel.getMessageHistoryTo(early, Integer.parseInt(args[1])).asArray());
                            channel.bulkDelete(messages);

                            IMessage assistant = channel.sendMessage("I've deleted " + Integer.parseInt(args[1]) + " message(s) for you " + user.mention() + ". Deleting your message and this message in 5 seconds.");

                            ScheduledThreadPoolExecutor exec = new ScheduledThreadPoolExecutor(1);

                            exec.schedule(new Runnable() {
                                public void run() {
                                  assistant.delete();
                                  msgObject.delete();
                                }
                            }, 5, TimeUnit.SECONDS);

                            return;

                        }

                    } else {
                        channel.sendMessage("Did you mean to use: '" + PersistentHistoryBot.prefix + "ph delete <amount>'");
                        return;
                    }

                }

                channel.sendMessage("No command found. Use: '" + PersistentHistoryBot.prefix + "ph' for more assistance" );
                return;
            }
        } else {
            channel.sendMessage("No permission to use this command.");
            return;
        }


    }







}
