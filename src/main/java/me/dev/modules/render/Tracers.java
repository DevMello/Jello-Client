package me.dev.modules.render;
import com.mentalfrostbyte.jello.util.BooleanValue;
import me.dev.util.Vars;
import net.minecraft.entity.EntityLivingBase;
import com.mentalfrostbyte.jello.main.Jello;
import com.mentalfrostbyte.jello.main.Module;
import me.dev.util.render.RenderUtils;
import org.lwjgl.input.Keyboard;

public class Tracers extends Module {

    public BooleanValue Mobs;
    public BooleanValue Players;
    public BooleanValue gm;
    public BooleanValue an;
    public BooleanValue mo;
    public BooleanValue kb;
    public BooleanValue team;
    public static boolean enabled;


    public Tracers() {
        super("Tracers", Keyboard.KEY_NONE);
        this.jelloCat = Jello.tabgui.cats.get(4);
        Mobs = new BooleanValue("Show Mobs", false);
        addValue(Mobs);
        Players = new BooleanValue("Show Players", false);
        addValue(Players);
        mo = new BooleanValue("Show Passives", false);
        addValue(mo);
        team = new BooleanValue("Show Animals", false);
        addValue(team);

    }

    public void onEnable(){

        enabled = true;
        if(!this.isToggled())
            return;
    }

    public void onDisable(){
        enabled = false;
    }

    public void onUpdate()
    {
        Vars.TracerAnimals = team.getValue();
        Vars.TracerPassives = mo.getValue();
        Vars.TracerPlayers = Players.getValue();
        Vars.TracerMobs = Mobs.getValue();

    }

    public void player(EntityLivingBase entity) {
        float red  = 0.5F;
        float blue  = 1F;
        float green  = 0.5F;

        double X = entity.posX;
        double Y = entity.posY;
        double Z = entity.posZ;

        double mX = mc.thePlayer.posX;
        double mY = mc.thePlayer.posY;
        double mZ = mc.thePlayer.posZ;

        double xPos = (mX - X);
        double yPos = (mY - Y);;
        double zPos = (mZ - Z);;

        render(red, green, blue, xPos, yPos, zPos);
    }

    public void mob(EntityLivingBase entity) {

        float red  = 1F;
        float blue  = 0.5F;
        float green  = 0.5F;

        double xPos = (entity.lastTickPosX + (entity.posX - entity.lastTickPosX) * mc.timer.renderPartialTicks) - mc.getRenderManager().renderPosX;
        double yPos = (entity.lastTickPosY + (entity.posY - entity.lastTickPosY) * mc.timer.renderPartialTicks) - mc.getRenderManager().renderPosY;
        double zPos = (entity.lastTickPosZ + (entity.posZ - entity.lastTickPosZ) * mc.timer.renderPartialTicks) - mc.getRenderManager().renderPosZ;

        render(red, green, blue, xPos, yPos, zPos);
    }

    public void animal(EntityLivingBase entity) {
        float red  = 0.5F;
        float blue  = 0.5F;
        float green  = 1F;

        double xPos = (entity.lastTickPosX + (entity.posX - entity.lastTickPosX) * mc.timer.renderPartialTicks) - mc.getRenderManager().renderPosX;
        double yPos = (entity.lastTickPosY + (entity.posY - entity.lastTickPosY) * mc.timer.renderPartialTicks) - mc.getRenderManager().renderPosY;
        double zPos = (entity.lastTickPosZ + (entity.posZ - entity.lastTickPosZ) * mc.timer.renderPartialTicks) - mc.getRenderManager().renderPosZ;

        render(red, green, blue, xPos, yPos, zPos);
    }

    public void passive(EntityLivingBase entity) {
        float red  = 0.5F;
        float blue  = 0.5F;
        float green  = 0.5F;

        double xPos = (entity.lastTickPosX + (entity.posX - entity.lastTickPosX) * mc.timer.renderPartialTicks) - mc.getRenderManager().renderPosX;
        double yPos = (entity.lastTickPosY + (entity.posY - entity.lastTickPosY) * mc.timer.renderPartialTicks) - mc.getRenderManager().renderPosY;
        double zPos = (entity.lastTickPosZ + (entity.posZ - entity.lastTickPosZ) * mc.timer.renderPartialTicks) - mc.getRenderManager().renderPosZ;

        render(red, green, blue, xPos, yPos, zPos);
    }

    public void render(float red, float green, float blue, double x, double y, double z) {
        RenderUtils.drawTracerLine(x, y, z , red, green, blue, 0.45F, 1F);
    }
}
