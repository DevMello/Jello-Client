package me.dev.gui.logger.panels;

import me.dev.gui.logger.TextAreaOutputStream;

import javax.swing.*;
import java.awt.*;
import java.io.PrintStream;

public class ErrorPanel extends JPanel {
    static JTextArea text = new JTextArea();
    public ErrorPanel() {

        text.setLineWrap(true);
        text.setWrapStyleWord(true);
        text.setEditable(false);
        PrintStream con=new PrintStream(new TextAreaOutputStream(text));
        System.setOut(con);
        System.setErr(con);

        JScrollPane pane = new JScrollPane();
        pane.setViewportView(text);

        super.setLayout(new GridLayout(1,1));
        super.add(pane);
        super.setPreferredSize(new Dimension(400,300));
    }
    public static void addToConsole(String words)
    {
        text.append(words);
    }
}
