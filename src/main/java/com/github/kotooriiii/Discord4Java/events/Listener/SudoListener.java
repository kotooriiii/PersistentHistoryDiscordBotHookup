package com.github.kotooriiii.Discord4Java.events.Listener;

import com.github.kotooriiii.Discord4Java.events.CommandReceivedEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import sx.blah.discord.api.events.EventSubscriber;
import sx.blah.discord.handle.obj.IChannel;
import sx.blah.discord.handle.obj.IMessage;
import sx.blah.discord.handle.obj.IUser;

import static com.github.kotooriiii.Discord4Java.util.util.isStaff;

public class SudoListener {

    @EventSubscriber
    public void onCommandReceive(CommandReceivedEvent e) {

        IMessage msgObject = e.getMsgObject();
        IChannel channel = msgObject.getChannel();
        IUser user = msgObject.getAuthor();
        String cmd = e.getCommand();
        String[] args = e.getArgs();

        /*
        Get player
        Check player perms
        Exec cmd, if failure, tell that to him.
        Chat message should be said in a manner.aw
         */



        Player p = Bukkit.getOfflinePlayer("KotoriXIII").getPlayer();

        if(p.isOnline()){
            p.performCommand("pl");
        }


    }







}
