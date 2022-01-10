package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SeatsRegularScreen extends MoviesFrame {
    private static final Color screenColor = new Color(227, 213, 202);
    private static final Color availableSeat = new Color(42, 157, 143);
    private static final Color unavailableSeat = new Color(231, 111, 81);
    private static final Color selectedSeat = new Color(33, 158, 188);

    SeatsRegularScreen(){
        JLabel title = new JLabel("Choose Seats", SwingConstants.CENTER);
        title.setFont(new Font("Tahoma", Font.BOLD, 30));
        title.setBounds(0, 0, 999, 60);
        title.setForeground(textColor);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setVerticalAlignment(SwingConstants.BOTTOM);

        JPanel top = new JPanel();
        top.setBounds(0, 0, 999, 80);
        top.setLayout(new BorderLayout());
        top.add(title);
        top.setBackground(backgroundColor);

        JPanel screen = new JPanel();
        screen.setBounds(200, 110, 599, 10);
        screen.setBackground(screenColor);

        JPanel spacer1 = new JPanel();
        spacer1.setBounds(0, 110, 200, 10);
        spacer1.setBackground(backgroundColor);

        JPanel spacer2 = new JPanel();
        spacer2.setBounds(799, 110, 200, 10);
        spacer2.setBackground(backgroundColor);

        JPanel spacer3 = new JPanel();
        spacer3.setBounds(0, 80, 999, 30);
        spacer3.setBackground(backgroundColor);

        final int w = 40;
        final int h = 40;

        ArrayList<JButton> seats = new ArrayList<>();

        int x = 315;
        int y = 50;

        for (int i = 0; i < 4; i++){
            for (int j = 0; j < 5; j++){
                JButton b = new JButton();
                b.setBounds(x + j * 80, y + i * 50, w, h);
                b.setBackground(availableSeat);
                seats.add(b);
            }
        }

        JPanel theater = new JPanel();
        theater.setBounds(0, 120, 999, 313);
        theater.setBackground(backgroundColor);
        theater.setLayout(null);
        for (JButton seat: seats) {
            theater.add(seat);
        }

        JButton next = new JButton("Continue");
        next.setBounds(0, 433, 80, 50);
        next.setFont(new Font("Tahoma", Font.BOLD, 22));;
        next.setBackground(buttonColor);
        next.setForeground(textColor);
        next.setFocusable(false);
        next.setHorizontalAlignment(SwingConstants.CENTER);
        next.setVerticalAlignment(SwingConstants.CENTER);

        JPanel bottom = new JPanel();
        bottom.setBounds(0, 433, 999, 130);
        bottom.add(next);
        bottom.setBackground(backgroundColor);

        this.add(top);
        this.add(spacer3);
        this.add(screen);
        this.add(spacer1);
        this.add(screen);
        this.add(spacer2);
        this.add(theater);
        this.add(bottom);

        next.addActionListener(new ActionListener() {
                                   public void actionPerformed(ActionEvent ae) {
                                       switchToNextWindow();
                                   }
                               }
        );
    }

    private void switchToNextWindow(){
        OrderScreen orderScreen = new OrderScreen();

        orderScreen.setVisible(true);
        this.setVisible(false);
    }
}
