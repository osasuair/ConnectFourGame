package graphics;

import javax.swing.*;
import java.awt.*;

class Draw extends JPanel {

    private int width, height;
    private final int ROWS, COLUMNS;

    Draw(int w, int h, int r, int c) {
        setSize(width = w, height = h);
        ROWS = r;
        COLUMNS = c;
    }

    @Override
    public void paintComponent(Graphics g) {
        width = getSize().width;
        height = getSize().height;

        new Grid().drawGrid(g, width, height, ROWS, COLUMNS);

    }
}

