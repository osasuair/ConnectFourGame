package graphics;

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


        // When the user selects the exit button, they are prompted to confirm exit and if they choose yes, the
        // will close
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                if (JOptionPane.showConfirmDialog(null,
                        "Are you sure you want to close this window?", "Close Window?",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });

        // Using the Border Layout to organize the different elements in the game
        this.setLayout(new BorderLayout());

        // Adding the drawn grid into the frame using the CounterGrid class
        add(new Grid(w, h, rows, columns));

        // Set Frame title, size, minimum size, border, and location
        setTitle(title);
        setSize(w, h);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);

    }

}
