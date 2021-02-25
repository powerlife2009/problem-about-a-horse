package com.powerLife.myTask.view;


import javax.swing.*;
import java.awt.*;

public class AboutView extends JDialog {

    private final JPanel jPanel = new JPanel();
    private final JLabel jLabel1 = new JLabel();
    private final JLabel jLabel2 = new JLabel();
    private final JButton jButton = new JButton("ок");
    private final String text = "Задача о ходе коня";
    private final String test = "<html><h2>What is Google Labs?</h2>" +
            "<font face=’verdana’ size = 2>" +
            " Google Labs is a playground <br>" +
            " where our more adventurous users can play around with <br>" +
            " prototypes of some of our wild and crazy ideas and <br>" +
            " offer feedback directly to the engineers who developed<br>" +
            " them. Please note that Labs is the first phase in <br>" +
            " a lengthy product development process and none of this <br>" +
            " stuff is guaranteed to make it onto Google.com. <br>" +
            " While some of our crazy ideas might grow into the <br>" +
            " next Gmail or iGoogle, others might turn out to be, <br>" +
            " well, just plain crazy.</html>";

    public AboutView() { // TODO: 24.02.2021 Реализовать содержимое окна
        jLabel1.setText(text);
        jLabel1.setHorizontalAlignment(JLabel.CENTER);
        jLabel1.setForeground(Color.DARK_GRAY);
        jLabel1.setFont(new Font(null, Font.BOLD, 30));
        jPanel.add(jLabel1);

        jLabel2.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        jLabel2.setText(test);
        jLabel2.setHorizontalAlignment(JLabel.CENTER);
        jLabel2.setForeground(Color.BLUE);
        jLabel2.setFont(new Font(null, Font.BOLD, 20));
        jPanel.add(jLabel2);

        add(jPanel);
        setModal(true);
        setResizable(false);
        setSize(500, 350);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
