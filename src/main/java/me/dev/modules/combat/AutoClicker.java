package me.dev.modules.combat;

import com.mentalfrostbyte.jello.event.EventTarget;
import com.mentalfrostbyte.jello.main.Jello;
import com.mentalfrostbyte.jello.main.Module;
import com.mentalfrostbyte.jello.util.NumberValue;

import me.dev.event.events.EventUpdate;
import me.dev.util.misc.Timer;
import org.lwjgl.input.Keyboard;

public class AutoClicker extends Module {
    public Timer timer = new Timer();
    NumberValue cps = new NumberValue("CPS",  10, 1, 50, 1);

    public AutoClicker() {
        super("AutoClicker", Keyboard.KEY_NONE );
        this.jelloCat = Jello.tabgui.cats.get(2);
        addValue(cps);
    }


    @EventTarget
    public void onUpdate(EventUpdate e) {
        if (mc.gameSettings.keyBindAttack.isKeyDown() && timer.hasTimeElapsed((long) (1000 / cps.getValue()), true)) {
            mc.leftClickCounter = 0;
            mc.clickMouse();
        }
    }
}
