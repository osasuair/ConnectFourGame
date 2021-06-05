package graphics;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CounterGrid{
    private ArrayList<Counter> connectGrid = new ArrayList<>();

    /**
     * Creates a Grid that contains Multiple counters and adds it to the JFrame- buildFrame
     * @param buildFrame The main JFrame
     * @param gridInt An Int[][] that contains the colors of every Counter in the counterGrid
     */
    public void createGrid(JFrame buildFrame, int[][] gridInt) {
        JPanel counterGrid = new JPanel();
        counterGrid.setSize(700, 600);
        counterGrid.setLayout(new GridLayout(6, 7));

        for (int i = 0; i < 42; i++) {
            int row = (int) Math.floor(i/7);
            int column = i%7;
            Counter count = new Counter(row, column, 2, counterGrid.getBounds());
            counterGrid.add(count);
            connectGrid.add(count);
            connectGrid.get(i).setColor(gridInt, gridInt[row][column]);

        }

        buildFrame.add(counterGrid, BorderLayout.CENTER);
    }

    public ArrayList<Counter> getArr(){
        return connectGrid;
    }

    /**
     * Sets the Color of all the counters to white and sets the entire int arr to 0 to represent the change
     * @param gridInt An Int[][] that contains the colors of every Counter in the counterGrid
     */
    public void clearGrid(int[][] gridInt) {

        int counter = 0;
        for (int i = 0; i < gridInt.length; i++){
            for (int j = 0; j < gridInt[i].length; j++) {
                connectGrid.get(counter).setColor(gridInt, 0/*gridInt[i][j]*/);
                counter++;
            }
        }
    }
}

