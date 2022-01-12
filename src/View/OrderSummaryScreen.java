package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OrderSummaryScreen extends MoviesFrame {

    OrderSummaryScreen(){
        JLabel movieName = new JLabel("Order Details", SwingConstants.CENTER);
        movieName.setFont(new Font("Tahoma", Font.BOLD, 30));
        movieName.setBounds(0, 0, 999, 60);
        movieName.setForeground(textColor);
        movieName.setHorizontalAlignment(SwingConstants.CENTER);
        movieName.setVerticalAlignment(SwingConstants.BOTTOM);

        JPanel top = new JPanel();
        top.setBounds(0, 0, 999, 80);
        top.setLayout(new BorderLayout());
        top.add(movieName);
        top.setBackground(backgroundColor);

        JPanel blank = new JPanel();
        blank.setBounds(0, 80, 999, 93);
        blank.setBackground(backgroundColor);

        JPanel contentPanel = new JPanel();
        contentPanel.setBounds(0, 173, 999, 277);
        contentPanel.setBackground(backgroundColor);

        String content = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed vitae elementum sapien, id interdum tellus. Vestibulum ut condimentum orci. Duis placerat dolor nunc, quis fermentum dolor rhoncus vitae. Sed vel neque sed lorem sodales pharetra.\nNullam vel dui felis. Sed malesuada mattis magna ac egestas. Vestibulum ultricies ligula id ex euismod finibus. Nulla malesuada erat vel risus interdum sollicitudin. Nulla imperdiet volutpat ipsum, eget aliquet lorem pellentesque et. Etiam vitae ex diam.";

        JTextArea textArea = new JTextArea(content, 6, 20);
        textArea.setFont(new Font("Tahoma", Font.PLAIN, 16));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setOpaque(false);
        textArea.setEditable(false);
        textArea.setBackground(backgroundColor);
        textArea.setForeground(textColor);

        JScrollPane contentScroller = new JScrollPane(textArea);
        contentScroller.setPreferredSize(new Dimension(500, 250));
        contentScroller.getViewport().setOpaque(false);
        contentScroller.setOpaque(false);
        contentScroller.setBorder(null);

        contentPanel.add(contentScroller);

        JPanel bottom = new JPanel();
        bottom.setBounds(0, 450, 999, 113);
        bottom.setBackground(backgroundColor);

        JButton next = new JButton("Pay");
        next.setBounds(350, 480, 299, 50);
        next.setFont(new Font("Tahoma", Font.BOLD, 22));;
        next.setBackground(buttonColor);
        next.setForeground(textColor);
        next.setFocusable(false);
        next.setHorizontalAlignment(SwingConstants.CENTER);
        next.setVerticalAlignment(SwingConstants.CENTER);

        bottom.add(next);

        this.add(top);
        this.add(blank);
        this.add(contentPanel);
        this.add(bottom);

        next.addActionListener(new ActionListener() {
                                   public void actionPerformed(ActionEvent ae) {
                                       switchToNextWindow();
                                   }
                               }
        );
    }

    private void switchToNextWindow(){
        MainScreen mainScreen = new MainScreen();

        mainScreen.setVisible(true);
        this.setVisible(false);
    }
}
