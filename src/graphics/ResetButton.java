package graphics;

import gameplay.Gameplay;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// TODO: Fix Reset Button

public class ResetButton extends JButton {
    private Gameplay gameplay;
    private final int[][] gridInt;

    public ResetButton(int[][] gridInt) {
        this.gridInt = gridInt;
        setText("Reset");
    }

    public void startListener(){
        this.addActionListener(new ResetListen());
    }

    public ResetButton setGameplay(Gameplay gameplay) {
        this.gameplay = gameplay;
        return this;
    }

    public class ResetListen implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            gameplay.reset(gridInt);
            System.out.println("test");
        }
    }
}
