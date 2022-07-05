package me.dev.modules.render;

import com.mentalfrostbyte.jello.main.Jello;
import com.mentalfrostbyte.jello.main.Module;
import com.mentalfrostbyte.jello.util.BooleanValue;
import com.mentalfrostbyte.jello.util.RenderingUtil;
import me.dev.util.RenderUtils;
import me.dev.util.Vars;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.entity.RendererLivingEntity;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.resources.model.IBakedModel;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import net.minecraft.util.StringUtils;
import org.lwjgl.BufferUtils;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;

import java.awt.*;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static optifine.Lagometer.active;

public class Nametags extends Module {

    public BooleanValue HealthValue;
    public static Map<EntityLivingBase, double[]> entityPositions = new HashMap();
    public BooleanValue armor;
    public BooleanValue background;
    public Nametags() {
        super("Nametags", Keyboard.KEY_NONE);
        this.jelloCat = Jello.tabgui.cats.get(4);
        armor = new BooleanValue("Armor", true);
        background = new BooleanValue("Background", true);
    }

    //create a method that displays the players health in their nametags
    public void onEnable() {
        Vars.NametagsEnabled = true;
    }

    public void onDisable() {
        Vars.NametagsEnabled = false;
    }




}
