package graphics;

import javax.swing.*;
import java.awt.*;

public class Counter extends JLabel {

    private final Rectangle DIMENS;
    private final int row;
    private final int column;
    private Color color;



    public Counter(int row, int column, int color, Rectangle dimens) {
        /**
         * A Circle Counter that can be Red, Yellow, White
         *
         * @param row    The Row that the counter is placed in
         * @param column The Column that the counter is placed in
         * @param color  Color of Counter represented by Int
         * @param dimens The Dimension of the Main Frame
         */

        this.row = row;
        this.column = column;

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


    public void setColor(int[][] gridInt, int color) {
        /**
         * Takes an Int and converts it to one of three color
         *
         * @param gridInt An Int[][] that contains the colors of every Counter in the counterGrid
         * @param color   The color of the counter represented by a either 0, 1, or 2
         */

        if (color == 0) {
            this.color = Color.WHITE;
        } else if (color == 1) {
            this.color = Color.YELLOW;
        } else {
            this.color = Color.RED;
        }

        gridInt[row][column] = color;
    }
}
