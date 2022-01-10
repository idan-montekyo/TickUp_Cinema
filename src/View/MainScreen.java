package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainScreen extends MoviesFrame {
    private static final String mainScreenBackgroundPath = "cinema.png";
    private JButton showMoviesButton = new JButton("MOVIES");
    private JButton showOrdersButton = new JButton("ORDERS");
    private JButton login = new JButton("LOGIN");

    MainScreen(){
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
            public void actionPerformed(ActionEvent ae) {
                switchToMoviesWindow();
            }
        });

        showOrdersButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                switchToOrdersWindow();
            }
        });

        login.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                boolean flag = loginUser();
                if(flag)
                    showOrdersButton.setEnabled(true);
            }
        });
    }

    private void switchToMoviesWindow(){
        MoviesScreen moviesScreen = new MoviesScreen();

        moviesScreen.setVisible(true);
        this.setVisible(false);
    }

    private void switchToOrdersWindow(){
        OrdersManagerScreen ordersManagerScreen = new OrdersManagerScreen();

        ordersManagerScreen.setVisible(true);
        this.setVisible(false);
    }

    private boolean loginUser(){
        String message = "Please enter your employee id number:";
        String userId = JOptionPane.showInputDialog(this, message, null);

        if(userId.equals("1234"))
            return true;

        return false;
    }
}