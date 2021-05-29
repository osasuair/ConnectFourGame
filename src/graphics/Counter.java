package graphics;

import org.w3c.dom.css.Rect;

import javax.swing.*;
import java.awt.*;

public class Counter extends JPanel {

    Color color;
    Rectangle dimens;
    int x, y;

    public Counter(int color, int x, int y, Rectangle dimens){
        if(color == 0){
            this.color = Color.RED;
        }
        else{
            this.color = Color.YELLOW;
        }
        this.x = x;
        this.y = y;
        this.dimens = dimens;
    }

    public void paintCircle(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, dimens.width/7, dimens.height/6);
        setVisible(true);
    }
}
