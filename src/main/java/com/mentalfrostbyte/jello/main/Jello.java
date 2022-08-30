package com.mentalfrostbyte.jello.main;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


import com.mentalfrostbyte.jello.alts.AltFile;
import com.mentalfrostbyte.jello.alts.AltManager;
import com.mentalfrostbyte.jello.alts.GuiAltManager;
import com.mentalfrostbyte.jello.hud.JelloHud;
import com.mentalfrostbyte.jello.jelloclickgui.JelloGui;
import com.mentalfrostbyte.jello.tabgui.TabGUI;
import com.mentalfrostbyte.jello.util.ChestUtil;
import com.mentalfrostbyte.jello.util.FileManager;
import com.mentalfrostbyte.jello.util.InventoryUtil;
import com.mentalfrostbyte.jello.util.SettingsFile;

import me.dev.gui.SplashProgress;
import me.dev.util.Logger;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.network.Packet;
import net.minecraft.util.ChatComponentText;


public class Jello {

	public static ArrayList<Module> mods = new ArrayList<Module>();
	//public static CommandManager commandManager;
	private static ScaledResolution s = new ScaledResolution(Minecraft.getMinecraft(), Minecraft.getMinecraft().displayWidth, Minecraft.getMinecraft().displayHeight);
	public static TabGUI tabgui = new TabGUI();
	public static double fontScaleOffset = 1;//round((double)1600/1080, 1) * s.getScaleFactor();//2.75;
	private static JelloHud hud;
	public static Object theClient;
	public static JCore core;
    private static AltManager altManager;
	private static File directory;
    private static FileManager fileManager;
    public static GuiAltManager altmanagergui;
    public static ArrayList<String> clickguiarray = new ArrayList<String>();
    public static SettingsFile settingsFile = new SettingsFile();
    public static JelloGui jgui;
   // public static Menu menu;
    public static ChestUtil chestUtil = new ChestUtil();
	public static InventoryUtil inventoryUtil = new InventoryUtil();
	public static Logger logger = new Logger("Jello");
	public static double round (double value, int precision) {
	    int scale = (int) Math.pow(10, precision);
	    return (double) Math.round(value * scale) / scale;
	}
	public static void register() {
		//command Manager = new CommandManager();
		//setup in alphabetical order
		register(new com.mentalfrostbyte.jello.modules.ActiveMods());
		register(new me.dev.modules.movement.AirWalk());
		register(new com.mentalfrostbyte.jello.modules.AntiKnockback());
		register(new me.dev.modules.combat.AutoClicker());
		register(new com.mentalfrostbyte.jello.modules.AutoArmor());
		register(new me.dev.modules.movement.Bhop());
		register(new com.mentalfrostbyte.jello.modules.BlockFly());
		register(new com.mentalfrostbyte.jello.modules.BunnyHop());
		register(new me.dev.modules.render.CameraNoClip());
		register(new me.dev.modules.player.ChestStealer());
		register(new com.mentalfrostbyte.jello.modules.Compass());
		register(new com.mentalfrostbyte.jello.modules.Coords());
		register(new me.dev.modules.combat.Criticals());
		register(new me.dev.modules.render.ESP());
		register(new me.dev.modules.movement.Fly());//not it
		register(new com.mentalfrostbyte.jello.modules.Fullbright());
		register(new com.mentalfrostbyte.jello.modules.HighJump());
		register(new me.dev.modules.item.InvCleaner());//not it
		register(new me.dev.modules.player.InventoryWalk());
		register(new com.mentalfrostbyte.jello.modules.KeyStrokes());
		register(new me.dev.modules.combat.KillAura());
		register(new me.dev.modules.movement.LongJump());
		register(new com.mentalfrostbyte.jello.modules.MenuGUI());
		register(new com.mentalfrostbyte.jello.modules.MiniMap());
		register(new me.dev.modules.player.NoFall());
		//register(new me.dev.modules.player.Logger());
		register(new com.mentalfrostbyte.jello.modules.Notifications());
		register(new me.dev.modules.movement.NoSlow());
		register(new com.mentalfrostbyte.jello.modules.Perspective());
		register(new com.mentalfrostbyte.jello.modules.TabGUI());
		register(new me.dev.modules.render.Tracers());
		register(new me.dev.modules.movement.Step());
		register(new me.dev.modules.render.Freecam());

		Jello.fileManager = new FileManager();
		jgui = new JelloGui();
		altManager = new AltManager();
		altmanagergui = new GuiAltManager();
		hud = new JelloHud();
		core = new JCore();
		
		settingsFile.loadFiles();
		
		Jello.altManager.setupAlts();
		
		
		AltFile.load();
	}
	
	public static void register(Module module) {
		mods.add(module);
		logger.setupLog("Registered Module: " + module.getName());
		SplashProgress.setProgress(SplashProgress.getProgress() + 1, "Registered Module: " + module.getName());
		//Dev.instance.initialize();
		//DiscordRP.instance.start();
	}
	public Module getModule(Class<? extends Module> clasz) {
		for (int i = 0; i < mods.size(); i++) {
			if (mods.get(i).getClass().equals(clasz))
				return mods.get(i);
		}

		return null;
	}
	public static List<Module> getModules(int key) {
		List<Module> modules = new ArrayList<Module>();
		for (int i = 0; i < mods.size(); i++) {
			if (mods.get(i).getKeyCode() == key)
				mods.add(mods.get(i));
		}

		return modules;
	}
	public static ArrayList<Module> getModules() {
		return mods;
	}
	public static JelloHud getInGameGUI() {
		return hud;
	}
	
	public static void onKeyPressed(int keyCode) {
		for(Module module : mods) {
			if(module.getKeyCode() == keyCode) {
				module.toggle();
			}
		}
		if(keyCode == 200){
			tabgui.keyUp();
		}
		if(keyCode == 208){
			tabgui.keyDown();
		}
		if(keyCode == 203){
			tabgui.keyLeft();
		}
		if(keyCode == 205){
			tabgui.keyRight();
		}
	}
	
	public static void onUpdate() {
		for(Module module : mods) {
			module.onUpdate();
		}
	}
	
	public static void onRender() {
		for(Module module : mods) {
			module.onRender();
		}
	}



	public Packet onPacketSend(Packet packet) { return packet; }


	
	public static AltManager getAltManager() {
        return Jello.altManager;
    }
	public static FileManager getFileManager() {
        return Jello.fileManager;
    }
	public static void addChatMessage(String s) {
		core.player().addChatMessage(new ChatComponentText("[Dev] \247r" + s));
	}
	public static void addSilentChatMessage(String s) {
		core.player().addChatMessage(new ChatComponentText(s));
	}

	public static void sendChatMessage(String s) {
		core.player().sendChatMessage(s);
	}
	public static File getDirectory() {
        return Jello.directory;
    }
	public static boolean onSendChatMessage(String s) {// EntityPlayerSP
		
		return true;
	}
	
	public static Module getModule(final String modName) {
        for (final Module module : getModules()) {
            if (module.getName().equalsIgnoreCase(modName) || module.getName().equalsIgnoreCase(modName)) {
                return module;
            }
        }
        return null;
    }
	
	public static ArrayList<Module> getModulesInCategory(TabGUI.Cat cat)
    {
      ArrayList<Module> modsInCat = new ArrayList();
      for (Module mod : getModules()) {
    	  if(mod.jelloCat != null){
    		  if(mod.jelloCat.equals(cat)){
    			  modsInCat.add(mod);
    		  }
    	  }
      }
      return modsInCat;
    }
	
}
