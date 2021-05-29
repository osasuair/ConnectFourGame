package graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;


public class BuildFrame extends JFrame {

    /**
     * Creates a window for the grid
     * @param title Title of the frame
     * @param w width
     * @param h height
     * @param rows # of rows
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

        // Automatically resize window to correct aspect ratio
        this.addComponentListener(new ResizeListener());

        // Adding the drawn grid into the frame using the Draw class
        Draw draw = new Draw(w, h , rows, columns);
        add(draw);

        // Set Frame title, size, minimum size, border, and location
        setTitle(title);
        setSize(w, h);
        setMinimumSize(new Dimension(700, 600));
        setLocationRelativeTo(null);
        getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.BLACK));
        setVisible(true);

    }


    private class ResizeListener extends ComponentAdapter {
        @Override
        public void componentResized(ComponentEvent arg0) {
            Rectangle b = arg0.getComponent().getBounds();
            arg0.getComponent().setBounds(b.x, b.y, b.width, b.width*6/7);
        }
    }
}
