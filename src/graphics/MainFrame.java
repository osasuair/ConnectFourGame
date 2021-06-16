package graphics;

import javax.swing.*;
import java.awt.*;


public class MainFrame extends JFrame {
    public ResetButton reset;
    private final ClickRowArr clickRows = new ClickRowArr(this);


    /**
     * Creates a window for the grid
     *
     * @param title   Title of the frame
     * @param w       width
     * @param h       height
     */
    public MainFrame(String title, int w, int h, int[][] gridInt) {

        // Using the Border Layout to organize the different elements in the game
        this.setLayout(new BorderLayout());

        // Adding the Clickable rows from the ClickRowArr class to the main frame
        add(clickRows, BorderLayout.CENTER);
        clickRows.start(this);

        // Adding the reset button
        reset = new ResetButton(gridInt);
        add(reset, BorderLayout.PAGE_END);

        // Set Frame title, size, minimum size, border, and location
        setTitle(title);
        setSize(w, h);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public ClickRowArr getClickRows() {
        return clickRows;
    }

    public ResetButton getResetButton() {
        return reset;
    }
}
