package main;

import javax.swing.*;


public class Main {

    public static JFrame mainWindow;
    public static void main(String[] args) {


        mainWindow = new JFrame();
        GamePanel gamePanel = new GamePanel();

        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.setResizable(false);
        mainWindow.setTitle("Project Nanos Magos");
        mainWindow.setUndecorated(true);
        mainWindow.add(gamePanel);
        mainWindow.pack(); //makes window fit the panel
        mainWindow.setLocationRelativeTo(null);
        mainWindow.setVisible(true);

        gamePanel.setupGame();
        gamePanel.beginThread();






    }


}
