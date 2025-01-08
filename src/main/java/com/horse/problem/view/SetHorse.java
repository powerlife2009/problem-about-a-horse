package com.horse.problem.view;

import com.horse.problem.controller.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

@Component
public class SetHorse extends JWindow {

    private final JButton[][] chessBoard = new JButton[8][8];
    private final MainView mainView;
    private final Controller controller;

    @Autowired
    public SetHorse(MainView mainView, Controller controller) {
        this.mainView = mainView;
        this.controller = controller;
        setLayout(new GridLayout(8, 8));
        setSize(280, 280);
        setBoard();
        setLocationRelativeTo(null);
    }

   private void setBoard() {
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

    public void initSetHorView() {
        setVisible(true);
    }

    public void setHorseOnCell(int h, int v) {
        chessBoard[h][v].addActionListener(e -> {
            controller.newBoard();
            mainView.removeHorse(
                    controller.getLogics().nowHorsePositionH(),
                    controller.getLogics().nowHorsePositionV());
            mainView.setStartButtonActivity(true);
            controller.setHorseStartPosition(h, v);
            controller.setHorseOnBoard();
            this.dispose();
            mainView.setEnabled(true);
        });
    }
}
