package View;

import javax.swing.*;
import java.awt.*;

// Abstract frame class that has the common properties to all screens
public abstract class MoviesFrame extends JFrame {
    // Fields and defines
    protected static final Color backgroundColor = new Color(106, 4, 15);
    protected static final Color buttonColor = new Color(10, 9, 8);
    protected static final Color textColor = new Color(229, 229, 229);

    private static final String appName = "TickUP";
    private static final String appIconPath = "src\\View\\images\\ticket.png";

    private static final int appWidth = 999;
    private static final int appHeight = 563;

    MoviesFrame(){
        // App screen properties
        this.setTitle(appName);
        this.setSize(appWidth, appHeight);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        ImageIcon icon = new ImageIcon(appIconPath);
        this.setIconImage(icon.getImage());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
    }
}
