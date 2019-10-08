package com.github.kotooriiii;


import com.github.kotooriiii.Discord4Java.client.DC4JBot;
import com.github.kotooriiii.Discord4Java.events.Listener.MessageListener;
import com.github.kotooriiii.Discord4Java.events.Listener.BulkDeletionListener;
import com.github.kotooriiii.JDA.JDABot;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;
import sx.blah.discord.api.IDiscordClient;
import sx.blah.discord.api.events.EventDispatcher;

import java.util.logging.Logger;

public class PersistentHistoryBot extends JavaPlugin {

    public static Plugin plugin;
    public static Logger logger;
    public static PluginDescriptionFile pdFile;

    public static final String token = "NDE5NzMyMzgyMDcwMDc5NDg5.DX02Lg.KQ99nGZs6kJryDTMg-GRPGt5xtY";
    public static String prefix = "./";

    public static IDiscordClient client;
    public static EventDispatcher dispatcher;

    @Override
    public void onLoad() {
        //pre-enable
    }

    public void useJDA(boolean usage) {

        if (usage) {
            JDABot.init();
        }
    }

    public void useDC4J(boolean usage) {

        if (usage) {

            IDiscordClient client = DC4JBot.createClient(token, true);
            this.client = client;



            EventDispatcher dispatcher = client.getDispatcher(); // Gets the EventDispatcher instance for this client instance
            this.dispatcher = dispatcher;



            registerDiscordEvents();
        }
    }

    public void registerDiscordEvents(){
        dispatcher.registerListener(new MessageListener()); // Registers the @EventSubscriber example class from above
        dispatcher.registerListener(new BulkDeletionListener()); // Registers the @EventSubscriber example class from above

    }

    @Override
    public void onEnable() {

        logger = Logger.getLogger("Minecraft");
        plugin = this;
        pdFile = this.getDescription();

        //useJDA(false); //this one sucks, keep as false, TRUST
        useDC4J(true);

        logger.info(pdFile.getName() + " has been successfully enabled on the server.");

    }

    @Override
    public void onDisable() {
        plugin = null;

        client.logout();

        logger.info(pdFile.getName() + " has been successfully disabled on the server.");
    }


}
