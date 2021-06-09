package graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class ClickableRow extends JPanel {
    private final Color TRANS_YELLOW = new Color(255, 255, 0, 116);
    private final int id;
    private boolean active;

    public ClickableRow(int id) {
        this.id = id;
        setSize(100, 700);
        setBackground(new Color(0, 0, 0, 0)); // Transparent
        setIgnoreRepaint(true);
    }

    public ClickableRow addListener(MainFrame mainFrame) {
        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                active = true;
                System.out.println(id);
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

    public int getId() {
        return id;
    }
}
