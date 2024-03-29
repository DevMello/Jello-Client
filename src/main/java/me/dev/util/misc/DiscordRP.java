package me.dev.util.misc;

import me.dev.util.Logger;
import net.arikia.dev.drpc.DiscordEventHandlers;
import net.arikia.dev.drpc.DiscordRPC;
import net.arikia.dev.drpc.DiscordRichPresence;
import net.arikia.dev.drpc.DiscordUser;
import net.arikia.dev.drpc.callbacks.ReadyCallback;


public class DiscordRP {
    private boolean running = true;
    private long created = 0;
    public static DiscordRP instance;
    protected static Logger logger = new Logger("DiscordRP");
    //eric golde who?

    public void start() {

        System.out.println("rpc started");
        logger.consoleLogInfo("DiscordRP - rpc started");

        this.created = System.currentTimeMillis();

        DiscordEventHandlers handlers = new DiscordEventHandlers.Builder().setReadyEventHandler(new ReadyCallback() {

            public void apply(DiscordRPC.DiscordReply user) {

            }

            @Override
            public void apply(DiscordUser user) {
                logger.consoleLogInfo("DiscordRP - Welcome, " + user.username + "#" + user.discriminator + "!");
                //System.out.println("Welcome, " + user.username + "#" + user.discriminator + "!");
                update("Utilizing Dev", "");
            }
        }).build();

        DiscordRPC.discordInitialize("830644405131673621", handlers, true);

        new Thread("Discord RPC Callback") {

            @Override
            public void run() {

                while(running) {
                    DiscordRPC.discordRunCallbacks();
                }
            }

        }.start();
    }
    public void shutdown() {
        running = false;
        DiscordRPC.discordShutdown();
    }
    public void update(String firstLine, String secondLine) {
        DiscordRichPresence.Builder b = new DiscordRichPresence.Builder(secondLine);
        b.setBigImage("wtf/monsoon", "https://devmello.cf");
        b.setDetails(firstLine);
        b.setStartTimestamps(created);

        DiscordRPC.discordUpdatePresence(b.build());
    }

}
