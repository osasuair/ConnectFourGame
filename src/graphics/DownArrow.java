package graphics;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class DownArrow extends JPanel {
    BufferedImage img;

    @Override
    public void paint(Graphics g){
        g.drawImage(img, 0, 0, this);
    }
}
