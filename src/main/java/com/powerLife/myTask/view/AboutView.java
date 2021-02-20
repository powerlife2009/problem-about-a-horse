package com.powerLife.myTask.view;

import javax.swing.*;


public class AboutView extends JDialog{

    public AboutView() {
        setTitle("About Program");
        setSize(400,250);
        setResizable(false);
        setModal(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}
