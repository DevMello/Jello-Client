import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Arrays;

import net.minecraft.client.main.Main;

import javax.swing.*;

public class Start
{
    public static void main(final String[] args) {
        final String system = System.getProperty("os.name").toLowerCase();
        File file;
        if (system.contains("win") && (file = new File(new File(System.getenv("APPDATA")), ".minecraft")).exists()) {
            System.out.println("Loaded client for Windows");
        }
        else {
            if (!system.contains("mac") || !(file = new File(new File(System.getProperty("user.home")), "Library/Application Support/minecraft")).exists()) {
                throw new RuntimeException("Failed to determine Minecraft directory");
            }
            System.out.println("Loaded client for MacOS");
        }
        //create a Java Swing window names launcher
        JFrame window = new JFrame();
        window.setTitle("Jello Client Launcher");
        window.setSize(500, 500);
        //create a button named "launch"
        JButton launch = new JButton("Launch");
        launch.setSize(100, 100);
        //set the button location
        launch.setLocation(200, 200);
        //set the window to visible
        //add the button to the window
        window.add(launch);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //add a listener to the button
        File finalFile = file;
        launch.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                //create a new instance of the main class
                Main.main(concat(new String[] { "--version", "client", "--accessToken", "0", "--assetIndex", "1.8", "--userProperties", "{}", "--gameDir", finalFile.getAbsolutePath(), "--assetsDir", new File(finalFile, "assets").getAbsolutePath(), "--username", "Steve" }, args));
                //close the window
                //window.dispose();
            }
        });
        //create a window called Launcher


    }


    public static <T> T[] concat(final T[] first, final T[] second) {
        final T[] result = Arrays.copyOf(first, first.length + second.length);
        System.arraycopy(second, 0, result, first.length, second.length);
        return result;
    }
}