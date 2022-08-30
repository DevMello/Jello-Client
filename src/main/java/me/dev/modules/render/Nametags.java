package me.dev.modules.render;

import com.mentalfrostbyte.jello.event.events.EventRender3D;
import com.mentalfrostbyte.jello.main.Jello;
import com.mentalfrostbyte.jello.main.Module;
import com.mentalfrostbyte.jello.util.BooleanValue;
import com.mentalfrostbyte.jello.util.NumberValue;
import me.dev.util.Vars;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Nametags extends Module {

    public BooleanValue HealthValue;
    public static Map<EntityLivingBase, double[]> entityPositions = new HashMap();
    public BooleanValue armor;
    public BooleanValue background;
    public BooleanValue health;
    public NumberValue scale;
    public Nametags() {
        super("Nametags", Keyboard.KEY_NONE);
        this.jelloCat = Jello.tabgui.cats.get(4);
        armor = new BooleanValue("Armor", true);
        background = new BooleanValue("Background", true);
        health = new BooleanValue("Health", true);
        scale = new NumberValue("Scale", 5, 3, 8, 0.2);
    }

    //create a method that displays the players health in their nametags
    public void onEnable() {
        Vars.NametagsEnabled = true;
    }

    public void onDisable() {
        Vars.NametagsEnabled = false;
    }







}
