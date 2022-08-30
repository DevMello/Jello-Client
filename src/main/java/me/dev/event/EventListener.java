package me.dev.event;


import me.dev.event.events.*;
import me.dev.util.Logger;
import net.minecraft.client.Minecraft;


import net.minecraft.client.Minecraft;

public class EventListener {

    protected Minecraft mc;

    public EventListener() {
        this.mc = Minecraft.getMinecraft();
    }

    public void onPacketSent(PacketSentEvent event) {
    }

    public void onPacketReceived(PacketReceivedEvent event) {
    }

    public void onMessageSent(MessageSentEvent event) {
    }

    public void onMessageReceived(MessageReceivedEvent event) {
    }

    public void onKeyPressed(KeyPressedEvent event) {
    }

    public void onUpdate(UpdateEvent event) {
    }

    public void onMouseScroll(MouseScrollEvent event) {
    }

    public void onMouseClick(MouseClickEvent event) {
    }

    public void onPreMotion(PreMotionEvent event) {
    }

    public void onPostMotion(PostMotionEvent event) {
    }

    public void onRender2D(Render2DEvent event) {
    }

    public void onRender3D(Render3DEvent event) {
    }

    public void onServerConnecting(ServerConnectingEvent event) {
    }

    public void onServerJoin(ServerJoinEvent event) {
    }

    public void onServerLeave(ServerLeaveEvent event) {
    }

    public void onCollide(CollideEvent event) {
    }

    public void onBlockRender(BlockRenderEvent event) {
    }

    public void onBlockBrightnessRequest(BlockBrightnessRequestEvent event) {
    }

    public void onRenderLivingLabel(RenderLivingLabelEvent event) {
    }

    public void onPlayerSpawn(PlayerSpawnEvent event) {
    }

    public void onFluidRender(FluidRenderEvent event) {
    }

    public void onSlowDown(SlowDownEvent event) {
    }

    public void onLadderClimb(LadderClimbEvent event) {
    }

}