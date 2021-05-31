package graphics;

import javax.swing.*;
import java.awt.*;

public class Grid extends JLabel {
    int width, height, rows, columns;

    public Grid(int width, int height, int rows, int columns){
        this.width = width;
        this.height = height;
        this.rows = rows;
        this.columns = columns;
    }

    @Override
    public void paint(Graphics g){
        int k;
        int htOfRow = 600 / rows;
        for (k = 0; k < rows; k++) {
            g.setColor(new Color(22,123,255));
            g.drawLine(0, k * htOfRow, 700, k * htOfRow);
        }

        int wdOfRow = 700 / columns;
        for (k = 0; k < columns; k++) {
            g.drawLine(k * wdOfRow, 0, k * wdOfRow, 600);
        }
        setVisible(true);
    }
}
