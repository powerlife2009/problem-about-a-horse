package com.powerLife.myTask.view;

import com.powerLife.myTask.listeners.AboutListener;
import com.powerLife.myTask.listeners.SetHorListener;
import com.powerLife.myTask.listeners.StartListener;
import com.powerLife.myTask.listeners.StopListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

@Component
public class MainView extends JFrame {

    private final ApplicationContext context;
    private final JPanel mainJPanel = new JPanel(new BorderLayout());
    private final JToolBar tools = new JToolBar();
    private final JButton setHor = new JButton("Setup Horse");
    private final JButton start = new JButton("Start");
    private final JButton stop = new JButton("Stop");
    private final JButton about = new JButton("About");
    private final JPanel board = new JPanel(new GridLayout(8, 8));
    private final JPanel[][] squares = new JPanel[8][8];
    private ImageIcon horse;
    private ImageIcon mark;
    private ImageIcon icon;

    @Autowired
    public MainView(ApplicationContext context) throws HeadlessException {
        this.context = context;
    }

    public void initView() {
        setImages();
        setToolBar();
        setBoard();
        setMainJPanel();
        setFrame();
        initListeners();
    }

    private void setFrame() {
        setTitle("A knight's tour");
        setIconImage(icon.getImage());
        setSize(650, 650);
        setLocationRelativeTo(null);
        setResizable(false);
        add(mainJPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void setMainJPanel() {
        mainJPanel.add(tools, BorderLayout.PAGE_START);
        mainJPanel.add(board);
    }

    private void setBoard() {
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

    private void setToolBar() {
        start.setEnabled(false);
        stop.setEnabled(false);

        tools.add(setHor);
        tools.add(start);
        tools.add(stop);
        tools.addSeparator();
        tools.add(about);
        tools.setFloatable(false);
    }

    private void setImages() {
        String s = System.getProperty("file.separator");
        this.horse = new ImageIcon("src" + s + "main" + s + "resources" + s + "horse.png");
        this.mark = new ImageIcon("src" + s + "main" + s + "resources" + s + "marker.png");
        this.icon = new ImageIcon("src" + s + "main" + s + "resources" + s + "icon.png");
    }

    /**
     * Удаление фигуры с клетки
     *
     * @param h по горизонтали
     * @param v по ветрикали
     */
    public void removeHorse(int h, int v) {
        squares[h][v].repaint();
        squares[h][v].revalidate();
        squares[h][v].removeAll();
        setVisible(true);
    }

    /**
     * Отображение фигуры в клетке
     *
     * @param h по горизонтали
     * @param v по вертикали
     */
    public void setHorse(int h, int v) {
        squares[h][v].add(new JLabel(horse));
        setVisible(true);
    }

    /**
     * Отображение клетки, как ранее занимаемая фигурой
     *
     * @param h по горизонтали
     * @param v по вертикали
     */
    public void markCell(int h, int v) {
        squares[h][v].removeAll();
        squares[h][v].add(new JLabel(mark));
        setVisible(true);
    }

    /**
     * Получение нового поля
     */
    public void getNewBoard() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                squares[i][j].repaint();
                squares[i][j].revalidate();
                squares[i][j].removeAll();
                board.add(squares[i][j]);
            }
        }
        buttonActivityAtStop();
        setVisible(true);
    }

    /**
     * Меняет активность кнопок на панели при старте алгоритма
     */
    public void buttonActivityAtStart() {
        setHor.setEnabled(false);
        start.setEnabled(false);
        stop.setEnabled(true);
    }

    /**
     * Меняет активность кнопок на панели при остановке алгоритма
     */
    public void buttonActivityAtStop() {
        setHor.setEnabled(true);
        stop.setEnabled(false);
    }

    /**
     * Инициализация слушателей кнопок
     */
    private void initListeners() {
        start.addActionListener(context.getBean(StartListener.class));
        setHor.addActionListener(context.getBean(SetHorListener.class));
        stop.addActionListener(context.getBean(StopListener.class));
        about.addActionListener(context.getBean(AboutListener.class));
    }

    public JButton getStart() {
        return start;
    }
}