package com.powerLife.myTask.view;

import javax.swing.*;
import java.awt.*;


public class MainView extends JFrame {

    private final JPanel genJPanel = new JPanel(new BorderLayout());
    private final JPanel board = new JPanel(new GridLayout(8, 8));
    private final JPanel[][] squares = new JPanel[8][8];
    private final JToolBar tools = new JToolBar();
    private final JButton setHor = new JButton("Setup Horse");
    private final JButton start = new JButton("Start");
    private final JButton stop = new JButton("Stop");
    private final JButton about = new JButton("About");
    private final ImageIcon horse = new ImageIcon("src/main/resources/horse2.png");
    private final ImageIcon mark = new ImageIcon("src/main/resources/galka.png");

    public MainView() {
        initView();
    }

    public void initView() {
        setToolBar();
        setBoard();
        setGenJPanel();
        setFrame();
    }

    public void setFrame() {
        setTitle("HorseGo");
        setSize(650, 650);
        setLocationRelativeTo(null);
        setResizable(false);
        add(genJPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void setGenJPanel() {
        genJPanel.add(tools, BorderLayout.PAGE_START);
        genJPanel.add(board);
    }

    public void setBoard() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                squares[i][j] = new JPanel();
                if ((i + j) % 2 == 0) {
                    squares[i][j].setBackground(Color.gray);
                } else {
                    squares[i][j].setBackground(Color.white);
                }
                board.add(squares[i][j]);
            }
        }
    }

    public void setToolBar() {
        tools.setFloatable(false);
        tools.add(setHor);
        tools.add(start);
        tools.add(stop);
        tools.addSeparator();
        tools.add(about);
        tools.addSeparator();
    }

    public void removeHorse(int h, int v) {
        squares[h][v].repaint();
        squares[h][v].revalidate();
        squares[h][v].removeAll();
        squares[h][v].setVisible(true);

        squares[h][v] = new JPanel();
        if ((h + v) % 2 == 0) {
            squares[h][v].setBackground(Color.gray);
        } else {
            squares[h][v].setBackground(Color.white);
        }
        setVisible(true);
    }

    public void setHorse(int h, int v) {
        squares[h][v].add(new JLabel(horse));
        setVisible(true);
    }

    public void killCell(int h, int v) {
        squares[h][v].removeAll();
        squares[h][v].add(new JLabel(mark));
        setVisible(true);
    }


    public JButton getSetHor() {
        return setHor;
    }

    public JButton getStart() {
        return start;
    }

    public JButton getStop() {
        return stop;
    }

    public JButton getAbout() {
        return about;
    }
}