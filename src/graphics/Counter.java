package graphics;

import javax.swing.*;
import java.awt.*;

public class Counter extends JLabel {

    private final Rectangle DIMENS;
    private Color color;
    private int id, colorInt;


    /**
     * A Circle Counter that can be Red, Yellow, White
     *
     * @param id     identification
     * @param color  Color of Counter represented by Int
     * @param dimens
     */
    public Counter(int id, int color, Rectangle dimens) {
        this.id = id;

        colorInt = color;
        if (color == 0) {
            this.color = Color.WHITE;
        } else if (color == 1) {
            this.color = Color.YELLOW;
        } else {
            this.color = Color.RED;
        }
        this.DIMENS = dimens;
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(color);
        g.fillOval(0, 0, DIMENS.width / 7, DIMENS.height / 6);
        setVisible(true);
    }

    public int getColorInt() {
        return colorInt;
    }

    /**
     * Takes an Int and converts it to one of three color
     *
     * @param arr
     * @param color
     */
    public void setColor(int[] arr, int color) {
        if (color == 0) {
            this.color = Color.WHITE;
        } else if (color == 1) {
            this.color = Color.YELLOW;
        } else {
            this.color = Color.RED;
        }

        arr[id] = color;
    }
}
