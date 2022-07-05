package me.dev.util;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.multiplayer.PlayerControllerMP;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.util.Session;

public class Wrapper {

    public Minecraft getMinecraft(){
        return Minecraft.getMinecraft();
    }


    public PlayerControllerMP getPlayerController(){
        return getMinecraft().playerController;
    }

    public WorldClient getWorld(){
        return getMinecraft().theWorld;
    }

    public GameSettings getGameSettings(){
        return getMinecraft().gameSettings;
    }


    public Session getSession(){
        return getMinecraft().session;
    }

    public EntityRenderer getEntityRenderer(){
        return getMinecraft().entityRenderer;
    }



}