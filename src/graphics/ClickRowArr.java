package graphics;

import javax.swing.*;
import java.awt.*;

public class ClickRowArr extends JPanel {
    private final ClickableRow[] clickRowArr = new ClickableRow[7];

    public ClickRowArr(MainFrame mainFrame) {
        setLayout(new GridLayout(0, 7));
        setBackground(new Color(0, 0, 0, 0));
        setSize(mainFrame.getWidth(), mainFrame.getHeight());

        // Create the 7 Columns to be interacted with and add them to the JPanel
        for (int i = 0; i < 7; i++) {
            clickRowArr[i] = new ClickableRow(i);
            add(clickRowArr[i]);
        }
    }

    public ClickableRow[] getClickRowArr() {
        return clickRowArr;
    }

    public void start(MainFrame mainFrame) {
        for (int i = 0; i < 7; i++) {
            clickRowArr[i].addListener(mainFrame);
        }
    }

    private void reset() {
        for (int i = 0; i < 7; i++) {
            clickRowArr[i].setActive(false);
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
            if (clickRowArr[i].isActive()) break;
        }
        return i;
    }
}
