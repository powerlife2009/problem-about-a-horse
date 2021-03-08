package com.powerLife.myTask.view;

import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

@Component
public class AboutView extends JDialog {

    public AboutView() {
        JPanel jPanel = new JPanel();

        JLabel head = new JLabel("A knight's tour");
        head.setHorizontalAlignment(JLabel.CENTER);
        head.setForeground(Color.DARK_GRAY);
        head.setFont(new Font("Georgia", Font.BOLD, 30));
        jPanel.add(head);

        JLabel textEn = new JLabel("<html><p align=\"center\">" +
                "A knight's tour is a sequence of moves of a knight<</br>\n" +
                "<br>on a chessboard such that the knight visits every</br>\n" +
                "<br>square exactly once.</br>" +
                "<br>The knight's tour problem is the mathematical problem</br>\n" +
                "<br>of finding a knight's tour.</br>" +
                "<br>* * *</br>" +
                "<br>This uses Warnsdorff's rule to calculate the next square </br>" +
                "<br>each time. This specifies that the next square should be </br>" +
                "<br>the one that has the least number of available moves.</br>" +
                "</p></html>");
        textEn.setBorder(BorderFactory.createEmptyBorder(40, 10, 10, 10));
        textEn.setHorizontalAlignment(JLabel.CENTER);
        textEn.setForeground(Color.BLACK);
        textEn.setFont(new Font("Georgia", Font.BOLD, 13));
        jPanel.add(textEn);

        JLabel author = new JLabel("<html><p align=\"center\">" +
                "<br>-------------------------------------</br>" +
                "<br>Author of this program: Vitaliy Chernykh</br>" +
                "<br>vitaliy.200989@gmail.com</br></p></html>");
        author.setBorder(BorderFactory.createEmptyBorder(30, 10, 10, 10));
        author.setHorizontalAlignment(JLabel.CENTER);
        author.setForeground(Color.DARK_GRAY);
        author.setFont(new Font("Georgia", Font.BOLD, 15));
        jPanel.add(author);

        add(jPanel);
        setModal(true);
        setResizable(false);
        setSize(500, 400);
        setLocationRelativeTo(null);
    }

    public void initAboutView() {
        setVisible(true);
    }
}
