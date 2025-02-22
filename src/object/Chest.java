package object;

import Items.Item;
import Items.equipment.LegendaryPen;
import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.FileInputStream;
import java.io.IOException;

public class Chest extends SuperObject{
    private Item content;
    public Chest(GamePanel gamePanel, Item item) {
        super(gamePanel);
        name = "Chest";
        content = item;
        try {
            image = ImageIO.read(new FileInputStream("src/sprites/objects/chest.png"));
        } catch (IOException e) {
                e.printStackTrace();

        }
    }

    public Item getContent() {
        return content;
    }


}

