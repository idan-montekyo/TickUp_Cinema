package View;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

public class OrdersManagerScreen extends MoviesFrame {
    private JTextArea textArea = new JTextArea("", 6, 20);

    public OrdersManagerScreen(){
        JLabel title = new JLabel("Orders", SwingConstants.CENTER);
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

        String orders[]= { "order1", "order2", "order3", "order4", "order5", "order6", "order7", "order8"};

        JPanel ordersPanel = new JPanel();
        ordersPanel.setBounds(0, 80, 500, 403);
        ordersPanel.setBackground(backgroundColor);

        JPanel orderInfo = new JPanel();
        orderInfo.setBounds(500, 80, 499, 403);
        orderInfo.setBackground(backgroundColor);

        JPanel bottom = new JPanel();
        bottom.setBounds(0, 450, 999, 80);
        bottom.setBackground(backgroundColor);

        JList list = new JList(orders);
        list.setBackground(buttonColor);
        list.setForeground(textColor);
        list.setFont(new Font("Tahoma", Font.PLAIN, 20));

        JScrollPane listScroller = new JScrollPane(list);
        listScroller.setPreferredSize(new Dimension(400, 350));

        textArea.setFont(new Font("Tahoma", Font.PLAIN, 16));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setOpaque(false);
        textArea.setEditable(false);
        textArea.setBackground(backgroundColor);
        textArea.setForeground(textColor);

        JScrollPane contentScroller = new JScrollPane(textArea);
        contentScroller.setPreferredSize(new Dimension(350, 250));
        contentScroller.getViewport().setOpaque(false);
        contentScroller.setOpaque(false);
        contentScroller.setBorder(null);

        orderInfo.add(contentScroller);
        ordersPanel.add(listScroller);
        this.add(top);
        this.add(ordersPanel);
        this.add(orderInfo);
        this.add(bottom);

        list.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                JList source = (JList)event.getSource();
                String selected = source.getSelectedValue().toString();
                System.out.println(selected);
                String content = "Lorem ipsum dolor sit amet, consectetur adipiscing elit.\nSed vitae elementum sapien, id interdum tellus.\nVestibulum ut condimentum orci. Duis placerat dolor nunc, quis fermentum dolor rhoncus vitae.\nSed vel neque sed lorem sodales pharetra.\nNullam vel dui felis. Sed malesuada mattis magna ac egestas.";
                textArea.setText(content);
            }
        });
    }
}
