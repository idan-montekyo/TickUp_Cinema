package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Controller.*;

// Main app's screen
public class MainScreen extends MoviesFrame {
    // Fields
    private static final String mainScreenBackgroundPath = "src\\View\\images\\cinema.png";
    private JButton showMoviesButton = new JButton("MOVIES");
    private JButton showOrdersButton = new JButton("ORDERS");
    private JButton login = new JButton("LOGIN");

    public MainScreen(){
        // Show Movies button
        showMoviesButton.setBounds(244, 320, 250, 70);
        showMoviesButton.setFont(new Font("Tahoma", Font.BOLD, 30));
        showMoviesButton.setBackground(buttonColor);
        showMoviesButton.setFocusable(false);
        showMoviesButton.setForeground(textColor);
        this.add(showMoviesButton);

        // Show Orders button
        showOrdersButton.setBounds(504, 320, 250, 70);
        showOrdersButton.setFont(new Font("Tahoma", Font.BOLD, 30));
        showOrdersButton.setBackground(buttonColor);
        showOrdersButton.setFocusable(false);
        showOrdersButton.setForeground(textColor);
        showOrdersButton.setEnabled(false);
        this.add(showOrdersButton);

        // Login button
        login.setBounds(15, 10, 80, 30);
        login.setFont(new Font("Tahoma", Font.BOLD, 12));;
        login.setBackground(buttonColor);
        login.setForeground(textColor);
        login.setFocusable(false);
        this.add(login);

        // Set background
        JLabel label = new JLabel();
        ImageIcon image = new ImageIcon(mainScreenBackgroundPath);
        label.setIcon(image);
        label.setSize(999, 563);
        this.getContentPane().add(label);

        // Movies button listener
        showMoviesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                ProgramManager.switchToMoviesWindow();
            }
        });

        // Orders button listener
        showOrdersButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                ProgramManager.switchToOrdersWindow();
            }
        });

        // Login button listener
        login.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                boolean flag = ProgramManager.loginUser();

                if(flag)
                    showOrdersButton.setEnabled(true);
            }
        });
    }
}