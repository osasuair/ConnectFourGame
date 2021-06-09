package main;

import gameplay.Gameplay;
import graphics.CounterGrid;
import graphics.MainFrame;


public class Main {
    public static void main(String[] args) {

        // The main frame for the Connect Four Game
        MainFrame mainFrame = new MainFrame("Connect Four", 715, 661, 6, 7);

        // The CounterGrid class contains a JPanel that is used to store the counters and the gridInt Array stores what counters is in what positions.
        CounterGrid counterGrid = new CounterGrid();
        int[][] gridInt = new int[6][7];
        counterGrid.createGrid(mainFrame, gridInt);

        Gameplay gameplay = new Gameplay(mainFrame, counterGrid);

        printArr(gridInt);
        System.out.println();
        gameplay.startGame(mainFrame.getNextButton(), gridInt);


    }

    private static void printArr(int[][] gridInt) {
        for (int[] ints : gridInt) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

}
