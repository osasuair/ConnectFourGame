package graphics;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CounterGrid{
    private ArrayList<Counter> connectGrid = new ArrayList<>();

    /**
     * Creates a Grid that contains Multiple counters and adds it to the JFrame- buildFrame
     * @param buildFrame The main JFrame
     * @param gridInt An Int[] that contains the colors of every Counter in the counterGrid
     */
    public void createGrid(JFrame buildFrame, int[] gridInt) {
        JPanel counterGrid = new JPanel();
        counterGrid.setSize(700, 600);
        counterGrid.setLayout(new GridLayout(6, 7));

        for (int i = 0; i < 42; i++) {
            Counter count = new Counter(i, 2, counterGrid.getBounds());
            counterGrid.add(count);
            connectGrid.add(count);
            connectGrid.get(i).setColor(gridInt, gridInt[i]);
        }

        buildFrame.add(counterGrid, BorderLayout.CENTER);
    }

    public ArrayList<Counter> getArr(){
        return connectGrid;
    }

    /**
     * Sets the Color of all the counters to white and sets the entire int arr to 0 to represent the change
     * @param gridInt An Int[] that contains the colors of every Counter in the counterGrid
     */
    public void clearGrid(int[] gridInt) {
        int j =0;
        for (int i = 0; i< gridInt.length; i++) {
            j++;
            System.out.print(gridInt[i] + " ");
            connectGrid.get(i).setColor(gridInt, gridInt[i]);

            if (j % 7 ==0){
                System.out.println();
            }
        }
    }
}

