package View;

import Controller.Manager;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MoviesScreen extends MoviesFrame {
    // Frame fields
    private JButton next = new JButton("Choose Movie");
    private ImageIcon movieImage = new ImageIcon();
    private JLabel image = new JLabel();
    // More fields for controller
    private int selectedMovie;

    public MoviesScreen(){
        JLabel title = new JLabel("MOVIES", SwingConstants.CENTER);
        title.setFont(new Font("Tahoma", Font.BOLD, 40));
        title.setBounds(0, 0, 999, 60);
        title.setForeground(textColor);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setVerticalAlignment(SwingConstants.CENTER);

        JPanel top = new JPanel();
        top.setBounds(0, 0, 999, 80);
        top.setLayout(new BorderLayout());
        top.add(title);
        top.setBackground(backgroundColor);

        ArrayList<String> mv = Manager.getMoviesTitles();

        JPanel contentPanel = new JPanel();
        contentPanel.setBounds(0, 80, 700, 370);
        contentPanel.setBackground(backgroundColor);

        JPanel imagePanel = new JPanel();
        imagePanel.setBounds(700, 80, 299, 370);
        imagePanel.setBackground(backgroundColor);
        imagePanel.setLayout(new BorderLayout());

        JPanel bottom = new JPanel();
        bottom.setBounds(0, 450, 999, 113);
        bottom.setBackground(backgroundColor);

        JList list = new JList(mv.toArray());
        list.setBackground(buttonColor);
        list.setForeground(textColor);
        list.setFont(new Font("Tahoma", Font.PLAIN, 20));

        JScrollPane listScroller = new JScrollPane(list);
        listScroller.setPreferredSize(new Dimension(400, 330));

        image.setHorizontalAlignment(SwingConstants.LEFT);
        image.setVerticalAlignment(SwingConstants.CENTER);
        imagePanel.add(image);

        next.setBounds(460, 430, 99, 50);
        next.setFont(new Font("Tahoma", Font.BOLD, 25));;
        next.setBackground(buttonColor);
        next.setForeground(textColor);
        next.setFocusable(false);
        next.setHorizontalAlignment(SwingConstants.CENTER);
        next.setVerticalAlignment(SwingConstants.CENTER);
        next.setEnabled(false);

        bottom.add(next);
        contentPanel.add(listScroller);
        this.add(top);
        this.add(contentPanel);
        this.add(imagePanel);
        this.add(bottom);

        next.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                Manager.switchToMovieInfoWindow(selectedMovie);
            }
        });

        list.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent event) {
                next.setEnabled(true);  // Enable button to the next stage (screen)
                // Get user selection
                JList source = (JList)event.getSource();
                int selectedMovie = source.getSelectedIndex();
                // Show selected movie's poster
                String imagePath = Manager.getMoviePoster(selectedMovie);
                image.setIcon(new ImageIcon(imagePath));
                // Save movie's name and path
                setSelectedMovie(selectedMovie);
            }
        });
    }

    private void setSelectedMovie(int movieIndex){
        this.selectedMovie = movieIndex;
    }
}
