package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MovieInfo extends MoviesFrame {

    MovieInfo(){
        JLabel movieName = new JLabel("Movie name", SwingConstants.CENTER);
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
        blank.setBounds(0, 80, 600, 43);
        blank.setBackground(backgroundColor);

        JPanel contentPanel = new JPanel();
        contentPanel.setBounds(0, 123, 600, 420);
        contentPanel.setBackground(backgroundColor);

        String content = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed vitae elementum sapien, id interdum tellus. Vestibulum ut condimentum orci. Duis placerat dolor nunc, quis fermentum dolor rhoncus vitae. Sed vel neque sed lorem sodales pharetra.\nNullam vel dui felis. Sed malesuada mattis magna ac egestas. Vestibulum ultricies ligula id ex euismod finibus. Nulla malesuada erat vel risus interdum sollicitudin. Nulla imperdiet volutpat ipsum, eget aliquet lorem pellentesque et. Etiam vitae ex diam.\nLorem ipsum dolor sit amet, consectetur adipiscing elit. Sed vitae elementum sapien, id interdum tellus. Vestibulum ut condimentum orci. Duis placerat dolor nunc, quis fermentum dolor rhoncus vitae. Sed vel neque sed lorem sodales pharetra.\nNullam vel dui felis. Sed malesuada mattis magna ac egestas. Vestibulum ultricies ligula id ex euismod finibus. Nulla malesuada erat vel risus interdum sollicitudin. Nulla imperdiet volutpat ipsum, eget aliquet lorem pellentesque et. Etiam vitae ex diam.";

        JTextArea textArea = new JTextArea(content, 6, 20);
        textArea.setFont(new Font("Tahoma", Font.PLAIN, 16));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setOpaque(false);
        textArea.setEditable(false);
        textArea.setBackground(backgroundColor);
        textArea.setForeground(textColor);

        JScrollPane contentScroller = new JScrollPane(textArea);
        contentScroller.setPreferredSize(new Dimension(450, 350));
        contentScroller.getViewport().setOpaque(false);
        contentScroller.setOpaque(false);
        contentScroller.setBorder(null);

        contentPanel.add(contentScroller);

        JPanel imagePanel = new JPanel();
        imagePanel.setBounds(600, 80, 399, 270);
        imagePanel.setBackground(backgroundColor);
        imagePanel.setLayout(new BorderLayout());

        ImageIcon movieImage = new ImageIcon("movie1.jpg");
        JLabel image = new JLabel();
        image.setIcon(movieImage);
        image.setHorizontalAlignment(SwingConstants.CENTER);
        image.setVerticalAlignment(SwingConstants.CENTER);

        imagePanel.add(image);

        JPanel screenings = new JPanel();
        screenings.setBounds(600, 350, 399, 100);
        screenings.setBackground(backgroundColor);

        JPanel bottom = new JPanel();
        bottom.setBounds(600, 450, 399, 113);
        bottom.setBackground(backgroundColor);

        JButton next = new JButton("Choose Screening");
        next.setBounds(150, 480, 99, 50);
        next.setFont(new Font("Tahoma", Font.BOLD, 22));;
        next.setBackground(buttonColor);
        next.setForeground(textColor);
        next.setFocusable(false);
        next.setHorizontalAlignment(SwingConstants.CENTER);
        next.setVerticalAlignment(SwingConstants.CENTER);

        bottom.add(next);

        String sc[]= { "VIP 12:00 - 14:00","16:00 - 18:00", "3D 20:00 - 22:00", "VIP 20:00 - 22:00"};

        JList list = new JList(sc);
        list.setBackground(buttonColor);
        list.setForeground(textColor);
        list.setFont(new Font("Tahoma", Font.PLAIN, 16));

        JScrollPane listScroller = new JScrollPane(list);
        listScroller.setPreferredSize(new Dimension(280, 70));

        screenings.add(listScroller);
        this.add(top);
        this.add(blank);
        this.add(contentPanel);
        this.add(imagePanel);
        this.add(screenings);
        this.add(bottom);

        next.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                                       switchToNextWindow();
                                   }
        });
    }

    private void switchToNextWindow(){
        TicketsScreen ticketsScreen = new TicketsScreen();

        ticketsScreen.setVisible(true);
        this.setVisible(false);
    }
}
