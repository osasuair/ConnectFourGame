package graphics;

import gameplay.Gameplay;

import javax.swing.*;
import java.awt.*;


public class BuildFrame extends JFrame {

    /**
     * Creates a window for the grid
     *
     * @param title   Title of the frame
     * @param w       width
     * @param h       height
     * @param rows    # of rows
     * @param columns # of columns
     */
    public BuildFrame(String title, int w, int h, int rows, int columns) {

        // Using the Border Layout to organize the different elements in the game
        this.setLayout(new BorderLayout());

        // Adding the drawn grid into the frame using the CounterGrid class
        add(new Grid(w, h, rows, columns));

        // Set Frame title, size, minimum size, border, and location
        setTitle(title);
        setSize(w, h);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
