package graphics;

import java.awt.*;

public class Grid {

    public void drawGrid(Graphics g, int width, int height, int rows, int columns) {
        int k;
        int htOfRow = height / rows;
        for (k = 0; k < rows; k++) {
            g.setColor(new Color(22,123,255));
            g.drawLine(0, k * htOfRow, width, k * htOfRow);
        }

        int wdOfRow = width / columns;
        for (k = 0; k < columns; k++) {
            g.drawLine(k * wdOfRow, 0, k * wdOfRow, height);
        }
    }
}
