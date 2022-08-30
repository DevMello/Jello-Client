package me.dev;

import com.mentalfrostbyte.jello.event.EventManager;

import static me.dev.updater.Update.*;
import static net.minecraft.client.Minecraft.getMinecraft;

import com.mentalfrostbyte.jello.event.events.Event;
import me.dev.command.CommandManager;
import me.dev.gui.SplashProgress;
import me.dev.gui.logger.GUI;
import me.dev.irc.IRCClient;
import me.dev.updater.Update;
import me.dev.util.Logger;
import me.dev.util.Wrapper;
import net.minecraft.client.renderer.EntityRenderer;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.status.StatusLogger;
import org.lwjgl.opengl.Display;

import javax.swing.*;
import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.logging.Level;

public class Dev {
    public static final String clientName = "Dev";
    public static final String clientVersion = "0.1";
    public static final String updateVersion = "0.1";
    private static final Dev INSTANCE;
    public static String name = "Dev", version = "v0.1";
    public static String fullname = name + " " + version;
    private final String author = "DevMello";
    private IRCClient ircClient;
    private Wrapper wrapper;

    public static Dev instance;
    public static Logger logger;
    GUI LoggerGui = new GUI();
    static {
        INSTANCE = new Dev();
    }
    public EntityRenderer getEntityRenderer(){
        return getMinecraft().entityRenderer;
    }
    private static CommandManager commandManager;

    private static EventManager eventManager;
    private static me.dev.event.EventManager eventManager2;
    private final String defaultUsername = "DevMello";

    public void setEntityLight(boolean state){
        if(state){getEntityRenderer().enableLightmap(1);}else{
            getEntityRenderer().disableLightmap(1);}
    }
    public List getEntityList(){
        return wrapper.getWorld().loadedEntityList;
    }

    public void initialize() {
        logger = new Logger(clientName);
        SplashProgress.setProgress(1, String.valueOf(clientName) + " - Initializied Logger");
        logger.setupLog("Beginning to initialize Dev Module");
        SplashProgress.setProgress(2, String.valueOf(clientName) + " - Beginning to initialize Dev Module");
        Display.setTitle(String.format("%1$s - %2$s | Loading...", clientName, clientVersion));
        logger.setupLog("Set Title to " + clientName + " " + clientVersion);
        SplashProgress.setProgress(3, String.valueOf(clientName) + " - Set Title to " + clientName + " " + clientVersion);
        eventManager = new EventManager();
        logger.setupLog("Initialized EventManager");
        SplashProgress.setProgress(4, String.valueOf(clientName) + " - Initialized EventManager");
        instance = new Dev();
        logger.setupLog("Initialized Dev Module Successfully");
        SplashProgress.setProgress(5, String.valueOf(clientName) + " - Initialized Dev Module Successfully");
        try {
            //LoggerGui.init();
            Update.checkVersion();
            SplashProgress.setProgress(5, String.valueOf(clientName) + " - Checked for updates");
        } catch (Error e){
            logger.consoleLogError(e.getMessage());
        }

    }

    public void shutdown() {
        logger = new Logger(clientName);
        logger.consoleLogError("Shutting down Dev Module");
        String version = getCurrentVersion();
        // Check for new version
        String latestVersion = getLatestVersion();
        if(latestVersion!=null && !latestVersion.equals(version))
        {
            System.out.println("launching update client");
            File youtube = new File(System.getenv("APPDATA") + File.separator + ".minecraft/dev/updater.jar");
            try{
                FileUtils.copyURLToFile(new URL(""), youtube);
                Runtime.getRuntime().exec("java -jar updater.jar");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        EventManager.unregister(this);
        //this.discordRP.shutdown();
    }


    public static final Dev getInstance() {
        return Dev.INSTANCE;
    }

    public IRCClient getIRCClient() {
        return ircClient;
    }

    public EventManager getEventManager() {
        return eventManager;
    }
    public me.dev.event.EventManager getEventManager2() {
        return eventManager2;
    }

    public CommandManager getCommandManager() {
        return commandManager;
    }
}
