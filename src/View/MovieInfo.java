package View;

import Controller.Manager;
import Model.MoviesAndScreenings.Screening;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MovieInfo extends MoviesFrame {
    JButton next = new JButton("Choose Screening");
    Screening selectedScreening;

    public MovieInfo(String movieNameStr, String movieImagePath){
        ArrayList<Screening> screeningsList = Manager.getMovieScreenings(movieNameStr);
        String content = Manager.getMovieSummary(movieNameStr);

        JLabel movieName = new JLabel(movieNameStr, SwingConstants.CENTER);
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

        ImageIcon movieImage = new ImageIcon(movieImagePath);
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

        next.setBounds(150, 480, 99, 50);
        next.setFont(new Font("Tahoma", Font.BOLD, 22));;
        next.setBackground(buttonColor);
        next.setForeground(textColor);
        next.setFocusable(false);
        next.setHorizontalAlignment(SwingConstants.CENTER);
        next.setVerticalAlignment(SwingConstants.CENTER);
        next.setEnabled(false);

        bottom.add(next);

        JList list = new JList(screeningsList.toArray());
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
                                       Manager.switchToTicketsWindow(selectedScreening);
                                   }
        });

        list.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent event) {
                next.setEnabled(true);  // Enable button to the next stage (screen)
                // Get user selection
                JList source = (JList)event.getSource();
                Screening selected = (Screening)source.getSelectedValue();
                selectedScreening = selected;
            }
        });
    }
}
