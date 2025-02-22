package creature.enemies;

import Items.consumables.Mushroom;
import creature.Enemy;
import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;



public class NanosMagos extends Enemy {
    public boolean alive = true;
    public boolean defeated = false;

    public NanosMagos(GamePanel gamePanel) {
        super(gamePanel);
        getSprites("src/sprites/hero");
        name = "NanosMagos";
        direction = "right";
        speed = 3;
        actionCounterMax = 30;
        setBattleStats();
        setDrops(gamePanel);
        spritesizeX = 300;
        spritesizeY = 500;
        spriteX = gamePanel.getScreenWidth() / 2 -150;
        spriteY = 200;
        battleText = "I am you";





    }

    @Override
    public void setDrops(GamePanel gamePanel) {
        drop = new  Mushroom(gamePanel);
        dropChance = 10;
        goldDrop = 10;
    }

    @Override
    public void setBattleStats() {
        maxHealth = 100;
        health = maxHealth;
        strength = 10;
        defence = 10;
        dexterity = 11;
        exp = 20;

        enemyMoves();
    }

    @Override
    public void setBattleSprites(BufferedImage image) {
        try{
            battleImageDefault = ImageIO.read(new FileInputStream("src/sprites/hero/down1.png"));
            battleImageAttack = ImageIO.read(new FileInputStream("src/sprites/hero/down2.png"));
            battleImageHurt = ImageIO.read(new FileInputStream("src/sprites/hero/up1.png"));

        }catch (IOException e) {
            e.printStackTrace();
        }


    }



    @Override
    public void enemyMoves() {
        attackMove[0] = "Thunder";
        attackPower[0] = 2;
        attackAccuracy[0] = 7;
        attackMove[1] = "Rain";
        attackPower[1] = 2;
        attackAccuracy[1] = 1;
        attackMove[2] = "Wind";
        attackAccuracy[2] = 8;
        attackPower[2] = 2;
        attackMove[3] = "Fog";
        attackPower[3] = 2;
        attackAccuracy[3] = 8;

    }



}
