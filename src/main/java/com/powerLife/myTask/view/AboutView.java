package com.powerLife.myTask.view;

import javax.swing.*;
import java.awt.*;

public class AboutView extends JDialog {

    public AboutView() { // TODO: 24.02.2021 Реализовать содержимое окна
        JPanel jPanel = new JPanel();

        JLabel head = new JLabel("A knight's tour");
        head.setHorizontalAlignment(JLabel.CENTER);
        head.setForeground(Color.DARK_GRAY);
        head.setFont(new Font("Georgia", Font.BOLD, 30));
        jPanel.add(head);

        JLabel textEn = new JLabel("<html><p align=\"center\">" +
                "A knight's tour is a sequence of moves of a knight<</br>\n" +
                "<br>on a chessboard such that the knight visits every</br>\n" +
                "<br>square exactly once. If the knight ends on a square</br>\n" +
                "<br>that is one knight's move from the beginning square</br>\n" +
                "<br>(so that it could tour the board again immediately,</br>\n" +
                "<br>following the same path), the tour is closed;</br>\n" +
                "<br>otherwise, it is open.</br>\n" +
                "<br>The knight's tour problem is the mathematical problem</br>\n" +
                "<br>of finding a knight's tour. Creating a program to</br>\n" +
                "<br>find a knight's tour is a common problem given to</br>\n" +
                "<br>computer science students. Variations of the knight's</br>\n" +
                "<br>tour problem involve chessboards of different sizes</br>\n" +
                "<br>than the usual 8 × 8, as well as irregular</br>\n" +
                "<br>(non-rectangular) boards.</br>\n" +
                "</p></html>");
        textEn.setHorizontalAlignment(JLabel.CENTER);
        textEn.setForeground(Color.BLACK);
        textEn.setFont(new Font("Georgia", Font.BOLD, 13));
        jPanel.add(textEn);

        add(jPanel);
        setModal(true);
        setResizable(false);
        setSize(500, 350);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
