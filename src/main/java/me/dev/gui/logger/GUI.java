package me.dev.gui.logger;

import me.dev.gui.logger.panels.ConsolePanel;
import me.dev.gui.logger.panels.ErrorPanel;
import me.dev.gui.logger.panels.InfoPanel;
import me.dev.gui.logger.panels.WarnPanel;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class GUI extends JFrame
{
    private final ConsolePanel console;
    private final ErrorPanel error;
    private final WarnPanel warn;
    private final InfoPanel info;
    //private final Bot bot;

    public GUI()
    {
        super();
        error = new ErrorPanel();
        warn = new WarnPanel();
        info = new InfoPanel();
        console = new ConsolePanel();
    }
    public void init()
    {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("DevMello's Logger");
        JTabbedPane tabs = new JTabbedPane();
        tabs.add("Console", console);
        tabs.add("Errors", error);
        tabs.add("Info", info);
        tabs.add("Warnings", warn);
        getContentPane().add(tabs);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        addWindowListener(new WindowListener()
        {
            @Override public void windowOpened(WindowEvent e) { /* unused */ }
            @Override public void windowClosing(WindowEvent e)
            {
                try
                {
                    //bot.shutdown();
                    dispose();
                    setVisible(false);
                }
                catch(Exception ex)
                {
                    System.exit(0);
                }
            }
            @Override public void windowClosed(WindowEvent e) { /* unused */ }
            @Override public void windowIconified(WindowEvent e) { /* unused */ }
            @Override public void windowDeiconified(WindowEvent e) { /* unused */ }
            @Override public void windowActivated(WindowEvent e) { /* unused */ }
            @Override public void windowDeactivated(WindowEvent e) { /* unused */ }
        });
    }
    public void destroy() {
        dispose();
        setVisible(false);
    }
}