package me.dev.modules.render;

import com.mentalfrostbyte.jello.main.Jello;
import com.mentalfrostbyte.jello.main.Module;
import me.dev.util.Vars;
import org.lwjgl.input.Keyboard;

public class Hitboxes extends Module {

    public Hitboxes() {
        super("Hitboxes", Keyboard.KEY_NONE);
        this.jelloCat = Jello.tabgui.cats.get(4);
    }

    public void onEnable() {
        Vars.HitboxesEnabled = true;
    }

    public void onDisable() {
        Vars.HitboxesEnabled = false;
    }

    public void onUpdate() {

        if(Vars.HitboxesEnabled){

        }
    }

    public void render(float red, float green, float blue, double x, double y, double z) {
        //RenderUtils.drawOutlinedEntityESP(x, y, z , red, green, blue, 0.45F, 1F);
    }
}
