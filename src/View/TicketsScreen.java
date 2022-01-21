package View;

import Controller.ProgramManager;
import Model.MoviesAndScreenings.Screening;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class TicketsScreen extends MoviesFrame {
    JButton next = new JButton("Continue");
    Screening screening;
    private int[] tickets = {0, 0, 0, 0};

    public TicketsScreen(Screening selectedScreening){
        this.screening = selectedScreening;

        JLabel title = new JLabel("Choose Tickets", SwingConstants.CENTER);
        title.setFont(new Font("Tahoma", Font.BOLD, 22));
        title.setBounds(0, 0, 999, 60);
        title.setForeground(textColor);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setVerticalAlignment(SwingConstants.CENTER);

        JPanel top = new JPanel();
        top.setBounds(0, 0, 999, 150);
        top.setLayout(new BorderLayout());
        top.add(title);
        top.setBackground(backgroundColor);

        String[] numberOfTickets = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};

        JComboBox ticket1 = new JComboBox(numberOfTickets);
        JComboBox ticket2 = new JComboBox(numberOfTickets);
        JComboBox ticket3 = new JComboBox(numberOfTickets);
        JComboBox ticket4 = new JComboBox(numberOfTickets);

        JLabel label1 = new JLabel("Regular ticket");
        label1.setForeground(textColor);
        label1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        label1.setHorizontalAlignment(SwingConstants.LEFT);
        label1.setVerticalAlignment(SwingConstants.CENTER);

        JLabel label2 = new JLabel("Veteran ticket");
        label2.setForeground(textColor);
        label2.setFont(new Font("Tahoma", Font.PLAIN, 16));
        label2.setHorizontalAlignment(SwingConstants.LEFT);
        label2.setVerticalAlignment(SwingConstants.CENTER);

        JLabel label3 = new JLabel("Student ticket");
        label3.setForeground(textColor);
        label3.setFont(new Font("Tahoma", Font.PLAIN, 16));
        label3.setHorizontalAlignment(SwingConstants.LEFT);
        label3.setVerticalAlignment(SwingConstants.CENTER);

        JLabel label4 = new JLabel("Policeman / soldier ticket");
        label4.setForeground(textColor);
        label4.setFont(new Font("Tahoma", Font.PLAIN, 16));
        label4.setHorizontalAlignment(SwingConstants.LEFT);
        label4.setVerticalAlignment(SwingConstants.CENTER);

        JPanel spacer1 = new JPanel();
        spacer1.setBounds(0, 150, 300, 200);
        spacer1.setBackground(backgroundColor);

        JPanel spacer3 = new JPanel();
        spacer3.setBounds(700, 150, 299, 200);
        spacer3.setBackground(backgroundColor);

        JPanel t1 = new JPanel();
        t1.setBounds(300, 150, 250, 50);
        t1.setLayout(new BorderLayout());
        t1.add(label1);
        t1.setBackground(backgroundColor);

        JPanel o1 = new JPanel();
        o1.setBounds(550, 150, 150, 50);
        o1.add(ticket1);
        o1.setBackground(backgroundColor);

        JPanel t2 = new JPanel();
        t2.setBounds(300, 200, 250, 50);
        t2.setLayout(new BorderLayout());
        t2.add(label2);
        t2.setBackground(backgroundColor);

        JPanel o2 = new JPanel();
        o2.setBounds(550, 200, 150, 50);
        o2.add(ticket2);
        o2.setBackground(backgroundColor);

        JPanel t3 = new JPanel();
        t3.setBounds(300, 250, 250, 50);
        t3.setLayout(new BorderLayout());
        t3.add(label3);
        t3.setBackground(backgroundColor);

        JPanel o3 = new JPanel();
        o3.setBounds(550, 250, 150, 50);
        o3.add(ticket3);
        o3.setBackground(backgroundColor);

        JPanel t4 = new JPanel();
        t4.setBounds(300, 300, 250, 50);
        t4.setLayout(new BorderLayout());
        t4.add(label4);
        t4.setBackground(backgroundColor);

        JPanel o4 = new JPanel();
        o4.setBounds(550, 300, 150, 50);
        o4.add(ticket4);
        o4.setBackground(backgroundColor);

        next.setBounds(450, 430, 80, 50);
        next.setFont(new Font("Tahoma", Font.BOLD, 22));;
        next.setBackground(buttonColor);
        next.setForeground(textColor);
        next.setFocusable(false);
        next.setHorizontalAlignment(SwingConstants.CENTER);
        next.setVerticalAlignment(SwingConstants.CENTER);
        next.setEnabled(false);

        JPanel spacer2 = new JPanel();
        spacer2.setBounds(0, 350, 999, 43);
        spacer2.setBackground(backgroundColor);

        JPanel bottom = new JPanel();
        bottom.setBounds(0, 393, 999, 240);
        bottom.add(next);
        bottom.setBackground(backgroundColor);

        this.add(top);
        this.add(spacer1);
        this.add(spacer2);
        this.add(spacer3);
        this.add(t1);
        this.add(o1);
        this.add(t2);
        this.add(o2);
        this.add(t3);
        this.add(o3);
        this.add(t4);
        this.add(o4);
        this.add(bottom);

        ticket1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event) {
                JComboBox source = (JComboBox)event.getSource();
                int selectedNumOfTickets = source.getSelectedIndex();
                tickets[0] = selectedNumOfTickets;

                next.setEnabled(checkIfTicketsSelected());
            }
        });

        ticket2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event) {
                JComboBox source = (JComboBox)event.getSource();
                int selectedNumOfTickets = source.getSelectedIndex();
                tickets[2] = selectedNumOfTickets;

                next.setEnabled(checkIfTicketsSelected());
            }
        });

        ticket3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event) {
                JComboBox source = (JComboBox)event.getSource();
                int selectedNumOfTickets = source.getSelectedIndex();
                tickets[1] = selectedNumOfTickets;

                next.setEnabled(checkIfTicketsSelected());
            }
        });

        ticket4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event) {
                JComboBox source = (JComboBox)event.getSource();
                int selectedNumOfTickets = source.getSelectedIndex();
                tickets[3] = selectedNumOfTickets;

                next.setEnabled(checkIfTicketsSelected());
            }
        });

        next.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                ProgramManager.IsValidNumberOfTickets(screening, tickets);
            }
        });
    }

    // Checks if the user selected one ticket at least
    private boolean checkIfTicketsSelected(){
        if (Arrays.stream(tickets).sum() == 0)
            return false;
        return true;
    }
}
