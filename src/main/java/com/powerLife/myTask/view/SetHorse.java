package com.powerLife.myTask.view;

import javax.swing.*;
import java.awt.*;

public class SetHorse extends JWindow {

    private final JButton[][] chessBoard = new JButton[8][8];

    public SetHorse() {
        setLayout(new GridLayout(8, 8));
        setBoard();
        setSize(280, 280);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void setBoard() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                chessBoard[i][j] = new JButton();
                if ((i + j) % 2 == 0) {
                    chessBoard[i][j].setBackground(Color.gray);
                } else {
                    chessBoard[i][j].setBackground(Color.white);
                }
                add(chessBoard[i][j]);
            }
        }
    }

    public JButton[][] getChessBoard() {
        return chessBoard;
    }
}
