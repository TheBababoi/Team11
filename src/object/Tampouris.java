package object;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.FileInputStream;
import java.io.IOException;

public class Tampouris extends SuperObject {

    public Tampouris(GamePanel gamePanel) {
        super(gamePanel);
        name = "Tampouris";
        try {
            image = ImageIO.read(new FileInputStream("src/sprites/backgroundTiles/029.png"));
        } catch (IOException e) {
            e.printStackTrace();
            ;
        }
    }
}

