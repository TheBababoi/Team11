package Items;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

public abstract class Item {
    protected GamePanel gamePanel;
    protected String name;
    protected String description;
    private BufferedImage image;
    protected int price;
    protected boolean stackable = false;
    private   int amount = 1;

    public Item(GamePanel gamePanel) {
        this.gamePanel = gamePanel;

    }

    public void getSprite(String path){
        try {
            image = ImageIO.read(new FileInputStream(path));
        } catch (IOException e){
            e.printStackTrace();
        }
    }


    public String getDescription() {
        return description;
    }


    public int getPrice() {
        return price;
    }

    public boolean isStackable() {
        return stackable;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public BufferedImage getImage() {
        return image;
    }

    public String getName() {
        return name;
    }
}
