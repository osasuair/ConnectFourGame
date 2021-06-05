package main;

import gameplay.Gameplay;
import graphics.BuildFrame;
import graphics.CounterGrid;
import graphics.NextButton;

import java.awt.*;

public class Main {
    public static void main(String[] args) {

        // The main frame for the Connect Four Game
        BuildFrame buildFrame = new BuildFrame("Connect Four", 715, 661, 6, 7);

        // The CounterGrid class contains a JPanel that is used to store the counters and the gridInt Array stores what counters is in what positions.
        CounterGrid counterGrid = new CounterGrid();
        int[][] gridInt = new int[6][7];
        counterGrid.createGrid(buildFrame, gridInt);

        // Adding the next button
        NextButton nextButton = new NextButton();
        buildFrame.add(nextButton, BorderLayout.PAGE_END);

        buildFrame.setVisible(true);


        System.out.println();

        // TODO: Move into a separate class/file

        Gameplay gameplay = new Gameplay(buildFrame, counterGrid);

        printArr(gridInt);
        System.out.println();
        gameplay.startGame(nextButton, gridInt);


    }

    private static void printArr(int[][] gridInt) {
        for (int i = 0; i < gridInt.length; i++) {
            for (int j = 0; j < gridInt[i].length; j++) {
                System.out.print(gridInt[i][j] + " ");
            }
            System.out.println();
        }
    }

}
