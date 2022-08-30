package me.dev.util;

//import me.dev.Dev;
import me.dev.gui.logger.panels.ErrorPanel;
import me.dev.gui.logger.panels.InfoPanel;
import me.dev.gui.logger.panels.WarnPanel;
import net.minecraft.util.ChatComponentText;

public class Logger {
    public static String prefixText = me.dev.Dev.fullname;
    public static String prefixColor = "9";
    public static String textColor = "f";

    protected String name;

    public Logger(String name) {
        System.out.println("[" + name + "] " + "Logger initialized.");
        this.name = name;
    }
    public void setupLog(String msg){
        System.out.println(ConsoleColor.BLUE + "[" + name + "] " + ConsoleColor.RESET + msg);
    }

    public void setupLog(String module, String msg){
        System.out.println(ConsoleColor.BLUE + "[" + module + "] " + ConsoleColor.RESET + msg);
    }

    public void log(String msg) {
        if (Wrapper.mc.thePlayer != null && Wrapper.mc.theWorld != null) {
            prefixColor = "9";
            prefixText = me.dev.Dev.fullname + "\2479";
            textColor = "f";
            StringBuilder tempMsg = new StringBuilder();

            for (String line : msg.split("\n")) {
                tempMsg.append(line).append("\2477");
            }

            Wrapper.mc.thePlayer.addChatMessage(new ChatComponentText("\247" + prefixColor + "[" + prefixText + "]\247" + textColor + " " + tempMsg.toString()));
            System.out.println(ConsoleColor.BLUE + "[" + prefixText + "]" + ConsoleColor.RESET + " " + msg + ConsoleColor.RESET);
        }
    }

    public void ingameInfo(String msg) {
        if (Wrapper.mc.thePlayer != null && Wrapper.mc.theWorld != null) {
            prefixColor = "9";
            textColor = "6";
            prefixText = name + " - " + "\247" + textColor + "Info" + "\2479";
            StringBuilder tempMsg = new StringBuilder();

            for (String line : msg.split("\n")) {
                tempMsg.append(line).append("\2477");
            }

            Wrapper.mc.thePlayer.addChatMessage(new ChatComponentText("\247" + prefixColor + "[" + prefixText + "]\247" + textColor + " " + tempMsg.toString()));
        }
    }

    public void ingameWarn(String msg) {
        if (Wrapper.mc.thePlayer != null && Wrapper.mc.theWorld != null) {
            textColor = "e";
            prefixText = name + " - " + "\247" + textColor + "Warning" + "\2479";
            StringBuilder tempMsg = new StringBuilder();

            for (String line : msg.split("\n")) {
                tempMsg.append(line).append("\2477");
            }

            Wrapper.mc.thePlayer.addChatMessage(new ChatComponentText("\247" + prefixColor + "[" + prefixText + "]\247" + textColor + " " + tempMsg.toString()));
        }
    }

    public void ingameError(String msg) {
        if (Wrapper.mc.thePlayer != null && Wrapper.mc.theWorld != null) {
            textColor = "c";
            prefixText = name + " - " + "\247" + textColor + "Error" + "\2479";
            StringBuilder tempMsg = new StringBuilder();

            for (String line : msg.split("\n")) {
                tempMsg.append(line).append("\2477");
            }

            Wrapper.mc.thePlayer.addChatMessage(new ChatComponentText("\247" + prefixColor + "[" + prefixText + "]\247" + textColor + " " + tempMsg.toString()));
        }
    }

    public void consoleLogInfo(String msg) {
        prefixText = name + " - Info";
        System.out.println(ConsoleColor.BLUE + "[" + prefixText + "]" + ConsoleColor.RESET + " " + msg + ConsoleColor.RESET);
        InfoPanel.addToConsole("[" + prefixText + "]" + " " + msg);
    }

    public void consoleLogWarn(String msg) {
        prefixText = name + " - Warn";
        System.out.println(ConsoleColor.YELLOW + "[" + prefixText + "]" + ConsoleColor.RESET + " " + msg + ConsoleColor.RESET);
        WarnPanel.addToConsole("[" + prefixText + "]" + " " + msg);
    }

    public void consoleLogError(String msg) {
        prefixText = name + " - Error";
        System.out.println(ConsoleColor.RED + "[" + prefixText + "]" + ConsoleColor.RESET + " " + msg + ConsoleColor.RESET);
        ErrorPanel.addToConsole("[" + prefixText + "]" + " " + msg);

    }
}