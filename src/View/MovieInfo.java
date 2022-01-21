package View;

import Controller.ProgramManager;
import Model.MoviesAndScreenings.Screening;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

// Screen that represents the movie data: name, content, image, screenings
public class MovieInfo extends MoviesFrame {
    // Fields
    JButton next = new JButton("Choose Screening");
    Screening selectedScreening;

    public MovieInfo(int movieIndex){
        // Get movie data from the controller
        String movieNameStr = ProgramManager.getMovieName(movieIndex);
        String movieImagePath = ProgramManager.getMoviePoster(movieIndex);
        ArrayList<Screening> screeningsList = ProgramManager.getMovieScreenings(movieIndex);
        String content = ProgramManager.getMovieSummary(movieIndex);

        // Movie name
        JLabel movieName = new JLabel(movieNameStr, SwingConstants.CENTER);
        movieName.setFont(new Font("Tahoma", Font.BOLD, 30));
        movieName.setBounds(0, 0, 999, 60);
        movieName.setForeground(textColor);
        movieName.setHorizontalAlignment(SwingConstants.CENTER);
        movieName.setVerticalAlignment(SwingConstants.BOTTOM);

        // Panel that holds the movie name
        JPanel top = new JPanel();
        top.setBounds(0, 0, 999, 80);
        top.setLayout(new BorderLayout());
        top.add(movieName);
        top.setBackground(backgroundColor);

        // Spacer for beautification
        JPanel spacer = new JPanel();
        spacer.setBounds(0, 80, 999, 43);
        spacer.setBackground(backgroundColor);

        // Panel that holds the content
        JPanel contentPanel = new JPanel();
        contentPanel.setBounds(0, 123, 700, 220); // **
        contentPanel.setBackground(backgroundColor);

        // The movie content
        JTextArea textArea = new JTextArea(content, 6, 30);
        textArea.setFont(new Font("Tahoma", Font.PLAIN, 16));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setOpaque(false);
        textArea.setEditable(false);
        textArea.setBackground(backgroundColor);
        textArea.setForeground(textColor);

        JScrollPane contentScroller = new JScrollPane(textArea);
        contentScroller.setPreferredSize(new Dimension(500, 200));
        contentScroller.getViewport().setOpaque(false);
        contentScroller.setOpaque(false);
        contentScroller.setBorder(null);

        contentPanel.add(contentScroller);

        // Panel that holds the image
        JPanel imagePanel = new JPanel();
        imagePanel.setBounds(700, 123, 299, 420);
        imagePanel.setBackground(backgroundColor);
        imagePanel.setLayout(new BorderLayout());

        // The movie image
        ImageIcon movieImage = new ImageIcon(movieImagePath);
        JLabel image = new JLabel();
        image.setIcon(movieImage);
        image.setHorizontalAlignment(SwingConstants.LEFT);
        image.setVerticalAlignment(SwingConstants.TOP);

        imagePanel.add(image);

        // Panel that holds the screenings
        JPanel screenings = new JPanel();
        screenings.setBounds(0, 343, 700, 100);
        screenings.setBackground(backgroundColor);

        // The screen lower part
        JPanel bottom = new JPanel();
        bottom.setBounds(0, 443, 700, 100);
        bottom.setBackground(backgroundColor);

        // Button to continue to the next screen
        next.setBounds(150, 480, 99, 50);
        next.setFont(new Font("Tahoma", Font.BOLD, 22));;
        next.setBackground(buttonColor);
        next.setForeground(textColor);
        next.setFocusable(false);
        next.setHorizontalAlignment(SwingConstants.CENTER);
        next.setVerticalAlignment(SwingConstants.TOP);
        next.setEnabled(false);

        bottom.add(next);

        // List of the movie screenings
        JList list = new JList(screeningsList.toArray());
        list.setBackground(buttonColor);
        list.setForeground(textColor);
        list.setFont(new Font("Tahoma", Font.PLAIN, 16));

        JScrollPane listScroller = new JScrollPane(list);
        listScroller.setPreferredSize(new Dimension(500, 70));

        screenings.add(listScroller);
        this.add(top);
        this.add(spacer);
        this.add(contentPanel);
        this.add(imagePanel);
        this.add(screenings);
        this.add(bottom);

        // Next screen button listener
        next.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                                       ProgramManager.switchToTicketsWindow(selectedScreening);
                                   }
        });

        // Screenings list listener
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
