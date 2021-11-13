package graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class ClickableCol extends JPanel {
    private final Color TRANS_YELLOW = new Color(255, 255, 0, 116);
    private final int id;
    private boolean active;

    public ClickableCol(int id) {
        /**
         * Function takes in the id of column as arg and draws column
         *
         * @param id integer that defines the number of column
         */

        this.id = id;
        setSize(100, 700);
        setBackground(new Color(0, 0, 0, 0)); // Transparent
        setIgnoreRepaint(true);
    }

    public ClickableCol addListener(MainFrame mainFrame) {
        /**
         * event listener to set column to active when it is clicked
         *
         * @param mainFrame The frame where the clickable columns are placed
         * */

        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                active = true;
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                setBackground(TRANS_YELLOW);
                mainFrame.repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setBackground(new Color(0, 0, 0, 0));
                mainFrame.repaint();
            }
        });
        return this;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
