package me.dev.modules.render;

import com.mentalfrostbyte.jello.main.Jello;
import com.mentalfrostbyte.jello.main.Module;
import com.mentalfrostbyte.jello.util.BooleanValue;
import me.dev.util.RenderUtils;
import me.dev.util.Vars;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import org.lwjgl.input.Keyboard;

public class ESP extends Module {

    public BooleanValue Mobs;
    public BooleanValue Players;
    public BooleanValue gm;
    public BooleanValue an;
    public BooleanValue mo;
    public BooleanValue kb;
    public BooleanValue team;
    public static boolean enabled;


    public ESP() {
        super("ESP", Keyboard.KEY_NONE);
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

        Vars.ESPAnimals = team.getValue();
        Vars.ESPPassives = Mobs.getValue();
        Vars.ESPPlayers = Players.getValue();
        Vars.ESPMobs = mo.getValue();
    }

    public void onDisable(){
        enabled = false;
    }

    public void onUpdate()
    {

        //if (!Minecraft.getMinecraft().inGameHasFocus) return;
        for(Object theObject : mc.theWorld.loadedEntityList) {
            if(!(theObject instanceof EntityLivingBase)){
                continue;
            }

            EntityLivingBase entity = (EntityLivingBase) theObject;


            if(entity instanceof EntityPlayer) {
                if (entity != mc.thePlayer)
                    player(entity);
                continue;
            }



            if(entity instanceof EntityMob) {
                mob(entity);
                continue;
            }


            //mob(entity);
/*
            if(entity instanceof EntityAnimal) {
                animal(entity);
                continue;
            }

 */
            animal(entity);

            passive(entity);

        }
        


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

        render(red, green, blue, xPos, yPos, zPos, entity.width, entity.height);
    }

    public void mob(EntityLivingBase entity) {

        float red  = 1F;
        float blue  = 0.5F;
        float green  = 0.5F;

        double xPos = (entity.lastTickPosX + (entity.posX - entity.lastTickPosX) * mc.timer.renderPartialTicks) - mc.getRenderManager().renderPosX;
        double yPos = (entity.lastTickPosY + (entity.posY - entity.lastTickPosY) * mc.timer.renderPartialTicks) - mc.getRenderManager().renderPosY;
        double zPos = (entity.lastTickPosZ + (entity.posZ - entity.lastTickPosZ) * mc.timer.renderPartialTicks) - mc.getRenderManager().renderPosZ;

        render(red, green, blue, xPos, yPos, zPos, entity.width, entity.height);
    }

    public void animal(EntityLivingBase entity) {
        float red  = 0.5F;
        float blue  = 0.5F;
        float green  = 1F;

        double xPos = (entity.lastTickPosX + (entity.posX - entity.lastTickPosX) * mc.timer.renderPartialTicks) - mc.getRenderManager().renderPosX;
        double yPos = (entity.lastTickPosY + (entity.posY - entity.lastTickPosY) * mc.timer.renderPartialTicks) - mc.getRenderManager().renderPosY;
        double zPos = (entity.lastTickPosZ + (entity.posZ - entity.lastTickPosZ) * mc.timer.renderPartialTicks) - mc.getRenderManager().renderPosZ;

        render(red, green, blue, xPos, yPos, zPos, entity.width, entity.height);
    }

    public void passive(EntityLivingBase entity) {
        float red  = 0.5F;
        float blue  = 0.5F;
        float green  = 0.5F;

        double xPos = (entity.lastTickPosX + (entity.posX - entity.lastTickPosX) * mc.timer.renderPartialTicks) - mc.getRenderManager().renderPosX;
        double yPos = (entity.lastTickPosY + (entity.posY - entity.lastTickPosY) * mc.timer.renderPartialTicks) - mc.getRenderManager().renderPosY;
        double zPos = (entity.lastTickPosZ + (entity.posZ - entity.lastTickPosZ) * mc.timer.renderPartialTicks) - mc.getRenderManager().renderPosZ;

        render(red, green, blue, xPos, yPos, zPos, entity.width, entity.height);
    }

    public void render(float red, float green, float blue, double x, double y, double z, float width, float height) {
        RenderUtils.drawEntityESP(x, y, z , width, height, red, green, blue,0.45F, 0F,0F, 0F, 1F, 1F);
    }
}
