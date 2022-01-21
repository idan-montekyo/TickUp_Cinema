package View;

import Controller.ProgramManager;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

// Screens with a list of all movies in the cinema and their images
public class MoviesScreen extends MoviesFrame {
    // Fields
    private JButton next = new JButton("Choose Movie");
    private ImageIcon movieImage = new ImageIcon();
    private JLabel image = new JLabel();

    private int selectedMovie;

    public MoviesScreen(){
        // Screen title
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

        // Movies list (from the controller)
        ArrayList<String> mv = ProgramManager.getMoviesTitles();

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

        // Selected movie's image
        image.setHorizontalAlignment(SwingConstants.LEFT);
        image.setVerticalAlignment(SwingConstants.CENTER);
        imagePanel.add(image);

        // Button to continue to the next screen
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

        // Next screen button listener
        next.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                ProgramManager.switchToMovieInfoWindow(selectedMovie);
            }
        });

        // Movies list listener
        list.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent event) {
                next.setEnabled(true);  // Enable button to the next stage (screen)
                // Get user selection
                JList source = (JList)event.getSource();
                int selectedMovie = source.getSelectedIndex();
                // Show selected movie's poster
                String imagePath = ProgramManager.getMoviePoster(selectedMovie);
                image.setIcon(new ImageIcon(imagePath));
                // Save movie's name and path
                setSelectedMovie(selectedMovie);
            }
        });
    }

    // Save the selected movie index in the list
    private void setSelectedMovie(int movieIndex){
        this.selectedMovie = movieIndex;
    }
}
