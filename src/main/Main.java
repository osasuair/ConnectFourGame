package main;

import graphics.BuildFrame;
import graphics.CounterGrid;
import graphics.NextButton;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {

        // The main frame for the Connect Four Game
        BuildFrame buildFrame = new BuildFrame("Connect Four", 715, 661, 6, 7);

        // The CounterGrid class contains a JPanel that is used to store the counters and the gridInt Array stores what counters is in what positions.
        CounterGrid counterGrid = new CounterGrid();
        int[] gridInt = new int[42];
        counterGrid.createGrid(buildFrame, gridInt);

        // Adding the next button
        buildFrame.add(new NextButton(), BorderLayout.PAGE_END);

        buildFrame.setVisible(true);

        counterGrid.getArr().get(15).setColor(gridInt, 1);

        System.out.println();
        printArr(gridInt);
    }

    private static void printArr(int[] gridInt) {
        for (int i = 0; i < gridInt.length; i++) {
            System.out.print(gridInt[i] + " ");
            if ((i + 1) % 7 == 0) {
                System.out.println();
            }
        }
    }
}
