package info.sigmaclient.management.command;

import info.sigmaclient.management.command.impl.Insult;

import java.util.Collection;
import java.util.HashMap;

public class CommandManager {

    public void addCommand(String name, Command command) {
        commandMap.put(name, command);
    }

    public Collection<Command> getCommands() {
        return commandMap.values();
    }

    public Command getCommand(String name) {
        return commandMap.get(name.toLowerCase());
    }

    public static final HashMap<String, Command> commandMap = new HashMap<String, Command>();

    public void setup() {
        //new ClaimFinder(new String[] {"cf","finder","claimfinder"}, "Finds claim in a X chunk radius.").register(this);
        //new Waypoint(new String[] {"Waypoints", "waypoint", "wp", "marker", "mark", "w"}, "Add/Remove waypoints.").register(this);
        //new PluginFinder(new String[] {"PluginFinder", "pf","plugins"}, "Discovers the plugins on a server.").register(this);
        //new Xray(new String[]{"Xray", "x-ray","xr"}, "Add/Remove items from the blacklist.").register(this);
        //new Color(new String[]{"Color", "c", "colors"}, "Change customizable colors.").register(this);
        //new Save(new String[]{"Save", "sv"}, "Save config").register(this);
        new Insult(new String[]{"Insult", "i"}, "Insult those faggot nodus users.").register(this);

    }

}
