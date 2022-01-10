package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Controller.*;

public class MainScreen extends MoviesFrame {
    private static final String mainScreenBackgroundPath = "src\\View\\images\\cinema.png";
    private JButton showMoviesButton = new JButton("MOVIES");
    private JButton showOrdersButton = new JButton("ORDERS");
    private JButton login = new JButton("LOGIN");

    public MainScreen(){
        showMoviesButton.setBounds(244, 320, 250, 70);
        showMoviesButton.setFont(new Font("Tahoma", Font.BOLD, 30));
        showMoviesButton.setBackground(buttonColor);
        showMoviesButton.setFocusable(false);
        showMoviesButton.setForeground(textColor);
        this.add(showMoviesButton);

        showOrdersButton.setBounds(504, 320, 250, 70);
        showOrdersButton.setFont(new Font("Tahoma", Font.BOLD, 30));
        showOrdersButton.setBackground(buttonColor);
        showOrdersButton.setFocusable(false);
        showOrdersButton.setForeground(textColor);
        showOrdersButton.setEnabled(false);
        this.add(showOrdersButton);

        login.setBounds(15, 10, 80, 30);
        login.setFont(new Font("Tahoma", Font.BOLD, 12));;
        login.setBackground(buttonColor);
        login.setForeground(textColor);
        login.setFocusable(false);
        this.add(login);

        JLabel label = new JLabel();
        ImageIcon image = new ImageIcon(mainScreenBackgroundPath);
        label.setIcon(image);
        label.setSize(999, 563);
        this.getContentPane().add(label);

        showMoviesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                Manager.switchToMoviesWindow();
            }
        });

        showOrdersButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                Manager.switchToOrdersWindow();
            }
        });

        login.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                boolean flag = Manager.loginUser();

                if(flag)
                    showOrdersButton.setEnabled(true);
            }
        });
    }
}