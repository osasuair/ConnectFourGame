package graphics;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NextButton extends JButton {
    private boolean turn = false, pressed = false;

    public NextButton() {
        setText("Red");
        addActionListener(new NextListen());
    }

    public void nextTurn() {
        turn = !turn;
    }

    public int getTurn() {
        if (turn) return 1;
        else return 2;
    }

    public void buttonClick() {
        // Waits until the user selects the next button
        while (!pressed) {
            System.out.print("");
        }
        pressed = false;
    }

    public class NextListen implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (turn) setText("Red");
            else setText("Yellow");
            turn = !turn;
            pressed = true;
        }
    }
}
