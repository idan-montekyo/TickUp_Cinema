package View;

import Controller.ProgramManager;
import Model.MovieOrders.Order;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OrderSummaryScreen extends MoviesFrame {
    JTextField text = new JTextField(20);
    JButton next = new JButton("Place Order");
    private Order order;
    private String phoneNumber;

    public OrderSummaryScreen(Order order){
        this.order = order;

        JLabel movieName = new JLabel("Order Details", SwingConstants.CENTER);
        movieName.setFont(new Font("Tahoma", Font.BOLD, 30));
        movieName.setBounds(0, 0, 999, 60);
        movieName.setForeground(textColor);
        movieName.setHorizontalAlignment(SwingConstants.CENTER);
        movieName.setVerticalAlignment(SwingConstants.CENTER);

        JPanel top = new JPanel();
        top.setBounds(0, 0, 999, 80);
        top.setLayout(new BorderLayout());
        top.add(movieName);
        top.setBackground(backgroundColor);

        JPanel blank = new JPanel();
        blank.setBounds(0, 80, 999, 3);
        blank.setBackground(backgroundColor);

        JPanel contentPanel = new JPanel();
        contentPanel.setBounds(0, 83, 999, 277);
        contentPanel.setBackground(backgroundColor);

        String content = order.toString();

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

        JPanel blank2 = new JPanel();
        blank2.setBounds(0, 360, 999, 40);
        blank2.setBackground(backgroundColor);

        JPanel phone = new JPanel();
        phone.setBounds(0, 400, 999, 60);
        phone.setBackground(backgroundColor);

        JLabel message = new JLabel("Plese enter your phone number:");
        message.setFont(new Font("Tahoma", Font.PLAIN, 16));
        message.setBackground(backgroundColor);
        message.setForeground(textColor);
        message.setHorizontalAlignment(SwingConstants.CENTER);
        message.setVerticalAlignment(SwingConstants.CENTER);

        text.setFont(new Font("Tahoma", Font.PLAIN, 16));
        text.setBackground(buttonColor);
        text.setForeground(textColor);
        text.setSize(200, 20);
        text.setHorizontalAlignment(SwingConstants.CENTER);

        phone.add(message);
        phone.add(text);

        JPanel bottom = new JPanel();
        bottom.setBounds(0, 460, 999, 103);
        bottom.setBackground(backgroundColor);

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
        this.add(blank2);
        this.add(phone);
        this.add(bottom);

        text.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                warn();
            }
            public void removeUpdate(DocumentEvent e) {
                warn();
            }
            public void insertUpdate(DocumentEvent e) {
                warn();
            }

            public void warn() {
                if (Integer.parseInt(text.getText()) <= 0){
                    next.setEnabled(false);
                }
                else
                {
                    next.setEnabled(true);
                    phoneNumber = text.getText();
                }
            }
        });

        next.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                ProgramManager.PlaceOrder(phoneNumber);
            }
        });
    }
}
