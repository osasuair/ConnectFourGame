package graphics;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NextButton extends JButton {
    public NextButton() {
        setText("Next Move");
        addActionListener(new NextListen());
    }

    public class NextListen implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Hello");
        }
    }
}
