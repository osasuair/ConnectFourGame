package graphics;

import java.awt.*;

class Grid extends Canvas {

    private int width, height, rows, columns;

    Grid(int w, int h, int r, int c) {
        setSize(width = w, height = h);
        rows =  r;
        columns = c;
    }

    @Override
    public void paint(Graphics g) {
        int k;
        width = getSize().width;
        height = getSize().height;

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

