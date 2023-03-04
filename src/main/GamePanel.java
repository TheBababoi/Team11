package main;

import backroundTile.BackgroundTileManager;
import creature.Hero;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {

    final int originalSpriteSize = 16;
    final int scaling = 5;

    final public int spriteSize = originalSpriteSize * scaling; //5*16=80px
    final public int maxScreenColumn = 24;
    final public int maxScreenRow = 13;
    final int screenHeight = spriteSize*maxScreenRow; //13*80=1040px
    final int screenWidth = spriteSize* maxScreenColumn;

    int FPS = 60;


    Thread thread;
    KeyboardInputs keyboardInputs = new KeyboardInputs();
    Hero hero = new Hero(this,keyboardInputs);
    BackgroundTileManager backgroundTileManager = new BackgroundTileManager(this);

    public GamePanel(){

        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setBackground(Color.magenta);
        this.setDoubleBuffered(true); // might improve rendering idk
        this.addKeyListener(keyboardInputs);
        this.setFocusable(true); //game panel will focus on receiving keyboard inputs

    }

    public void beginThread(){

        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        while (thread!= null){ //implementing the game loop using the "sleep" method (stack overflow is your friend)

            double drawInterval = 1000000000/FPS; //dividing 1 second by 60 frames
            double nextDrawTime = System.nanoTime() + drawInterval; // drawing every 0.0166 secs
            //System.out.println("exe is running");
            refresh();
            repaint(); // refreshing and repainting the screen constantly


            try {
                double remainingTime = nextDrawTime - System.nanoTime(); //how much time remains after every drawing
                remainingTime = remainingTime/1000000; //converting nanosecond to milli
                Thread.sleep((long)remainingTime);
                nextDrawTime += drawInterval; // setting next draw time

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void refresh(){
        hero.refresh();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g; // changing the Graphics to Graphics2D
        backgroundTileManager.draw(g2);
        hero.draw(g2);
    }

}
