package me.dev.gui;

public enum ColorEnum
{
    blue("blue", 0),
    red("red", 1),
    pink("pink", 2),
    green("green", 3),
    cyan("cyan", 4),
    orange("orange", 5),
    gold("gold", 6),
    brown("brown", 7),
    white("white", 8),
    yellow("yellow", 9),
    darkpurple("darkpurple", 10);

    private ColorEnum(final String s, final int n) {
    }
}
//return Font.createFont(0, Minecraft.getMinecraft().getResourceManager()
//                .getResource(new ResourceLocation("Jello/jellolight.ttf")).getInputStream());