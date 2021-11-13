package graphics;

import javax.swing.*;
import java.awt.*;


public class MainFrame extends JFrame {
    private final ClickColArr clickRows = new ClickColArr(this);



    public MainFrame(String title, int w, int h, int[][] gridInt) {
        /**
         * Creates a window for the grid
         *
         * @param title   Title of the frame
         * @param w       width
         * @param h       height
         */


        // Adding the Clickable rows from the ClickRowArr class to the main frame
        add(clickRows, BorderLayout.CENTER);
        clickRows.start(this);


        // Set Frame title, size, minimum size, border, and location
        setTitle(title);
        setSize(w, h);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public ClickColArr getClickRows() {
        return clickRows;
    }
}
