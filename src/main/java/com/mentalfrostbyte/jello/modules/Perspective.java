package com.mentalfrostbyte.jello.modules;

import com.mentalfrostbyte.jello.main.Jello;
import com.mentalfrostbyte.jello.main.Module;
import me.dev.util.Vars;
import net.minecraft.client.Minecraft;
import org.lwjgl.input.Keyboard;
import net.minecraft.client.settings.KeyBinding;

public class Perspective extends Module {

    public static float cameraYaw;
    public static float cameraPitch;

    public static boolean enabled = false;

    public Perspective() {
        super("Perspective", Keyboard.KEY_X);
        this.jelloCat = Jello.tabgui.cats.get(4);
    }

    public void onEnable(){
            //if (!Minecraft.getMinecraft().inGameHasFocus) return;
            Minecraft mc = Minecraft.getMinecraft();
            cameraYaw = mc.thePlayer.rotationYaw;
            cameraPitch = mc.thePlayer.rotationPitch;
            enabled = true;
            //enabled = !enabled;

            mc.gameSettings.thirdPersonView = enabled ? 1 : 0;

    }

    public void onDisable(){
        enabled = false;
    }


    public void onUpdate()
    {
        if(!this.isToggled())
            return;
        //if (!Minecraft.getMinecraft().inGameHasFocus) return;

        if (enabled == true)
        {
            if (!(Minecraft.getMinecraft().gameSettings.thirdPersonView > 0))
            {
                Minecraft.getMinecraft().gameSettings.thirdPersonView = 0;
                //enabled = !enabled;
            }
        }
    }


}
