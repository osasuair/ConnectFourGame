package graphics;

import javax.swing.*;
import java.awt.*;


public class MainFrame extends JFrame {
    private final NextButton nextButton = new NextButton();
    private final ClickRowArr clickRows = new ClickRowArr(this);


    /**
     * Creates a window for the grid
     *
     * @param title   Title of the frame
     * @param w       width
     * @param h       height
     * @param rows    # of rows
     * @param columns # of columns
     */
    public MainFrame(String title, int w, int h, int rows, int columns) {

        // Using the Border Layout to organize the different elements in the game
        this.setLayout(new BorderLayout());

//        // Adding the drawn grid into the frame using the CounterGrid class
//        add(new Grid(w, h, rows, columns));


        // Adding the Clickable rows from the ClickRowArr class to the main frame
        add(clickRows, BorderLayout.CENTER);
        clickRows.start(this);

        // Adding the next button
        add(nextButton, BorderLayout.PAGE_END);

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

    public NextButton getNextButton() {
        return nextButton;
    }
}
