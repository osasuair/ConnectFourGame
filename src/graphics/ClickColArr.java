package graphics;

import javax.swing.*;
import java.awt.*;

public class ClickColArr extends JPanel {
    private final ClickableCol[] clickColArr = new ClickableCol[7];

    public ClickColArr(MainFrame mainFrame) {
        setLayout(new GridLayout(0, 7));
        setBackground(new Color(0, 0, 0, 0));
        setSize(mainFrame.getWidth(), mainFrame.getHeight());

        // Create the 7 Columns to be interacted with and add them to the JPanel
        for (int i = 0; i < 7; i++) {
            clickColArr[i] = new ClickableCol(i);
            add(clickColArr[i]);
        }
    }

    public ClickableCol[] getClickColArr() {
        return clickColArr;
    }

    public void start(MainFrame mainFrame) {
        for (int i = 0; i < 7; i++) {
            clickColArr[i].addListener(mainFrame);
        }
    }

    private void reset() {
        for (int i = 0; i < 7; i++) {
            clickColArr[i].setActive(false);
        }
    }

    // Loops through the rows to see which one is active
    public int getActiveId() {
        int i;
        for (i = 0; i < 8; i++) {
            if (i == 7) {
                i = -1;
                break;
            }
            if (clickColArr[i].isActive()) break;
        }
        return i;
    }
}
