package com.github.kotooriiii.JDA;

import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import javax.security.auth.login.LoginException;

public class JDABot extends ListenerAdapter {

   public static void init(){

        try {
            String token = "NDE5NzMyMzgyMDcwMDc5NDg5.DX02Lg.KQ99nGZs6kJryDTMg-GRPGt5xtY";
            JDA jdaBot = new JDABuilder(AccountType.BOT).setToken(token).buildBlocking();
            jdaBot.addEventListener(new JDABot());
        } catch (LoginException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onMessageReceived(MessageReceivedEvent e){

        Message msgObject = e.getMessage();
        String msg = e.getMessage().getContentStripped();
        MessageChannel msgChannel = e.getChannel();
        User user = e.getAuthor();
;
        if(msg.equalsIgnoreCase("phist")){
            msgChannel.sendMessage("Hi!").complete();
        }
    }
}
