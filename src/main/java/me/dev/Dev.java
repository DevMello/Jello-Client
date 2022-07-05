package me.dev;

import com.mentalfrostbyte.jello.event.EventManager;
import static net.minecraft.client.Minecraft.getMinecraft;

import me.dev.util.Wrapper;
import net.minecraft.client.renderer.EntityRenderer;

import java.util.List;

public class Dev {
    private final String clientName = "Dev";
    private final String clientVersion = "1.1";
    private final String author = "DevMello";
    private Wrapper wrapper = new Wrapper();

    public static Dev instance;

    public EntityRenderer getEntityRenderer(){
        return getMinecraft().entityRenderer;
    }

    private EventManager eventManager;
    private final String defaultUsername = "DevMello";

    public void setEntityLight(boolean state){
        if(state){getEntityRenderer().enableLightmap(1);}else{
            getEntityRenderer().disableLightmap(1);}
    }
    public List getEntityList(){
        return wrapper.getWorld().loadedEntityList;
    }

    public void initialize() {
        //Display.setTitle(String.format("%1$s - %2$s | Loading...", clientName, clientVersion));
        //this.eventManager = new EventManager();
        //this.baseClient = BaseClient.instance;
        //baseClient.initialize();

        /**
         * Returns a formatted string using the specified locale, format string,
         * and arguments.
         *
         * @param  l
         *         The {@linkplain java.util.Locale locale} to apply during
         *         formatting.  If {@code l} is {@code null} then no localization
         *         is applied.
         *
         * @param  format
         *         A <a href="../util/Formatter.html#syntax">format string</a>
         *
         * @param  args
         *         Arguments referenced by the format specifiers in the format
         *         string.  If there are more arguments than format specifiers, the
         *         extra arguments are ignored.  The number of arguments is
         *         variable and may be zero.  The maximum number of arguments is
         *         limited by the maximum dimension of a Java array as defined by
         *         <cite>The Java&trade; Virtual Machine Specification</cite>.
         *         The behaviour on a
         *         {@code null} argument depends on the
         *         <a href="../util/Formatter.html#syntax">conversion</a>.
         *
         * @throws  java.util.IllegalFormatException
         *          If a format string contains an illegal syntax, a format
         *          specifier that is incompatible with the given arguments,
         *          insufficient arguments given the format string, or other
         *          illegal conditions.  For specification of all possible
         *          formatting errors, see the <a
         *          href="../util/Formatter.html#detail">Details</a> section of the
         *          formatter class specification
         *
         * @return  A formatted string
         *
         * @see  java.util.Formatter
         * @since  1.5
         */

    }
}
