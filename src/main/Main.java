package main;

import gameplay.Gameplay;
import graphics.CounterGrid;
import graphics.MainFrame;


public class Main {
    public static void main(String[] args) {

        int[][] gridInt = new int[6][7]; // The Grid that contains the position of all the counters

        // The main frame for the Connect Four Game
        MainFrame mainFrame = new MainFrame("Connect Four", 715, 661, gridInt);

        // The CounterGrid class contains a JPanel that is used to store the counters and the gridInt Array stores what counters is in what positions.
        CounterGrid counterGrid = new CounterGrid();
        counterGrid.createGrid(mainFrame, gridInt);

        // Class that controls the gameplay
        Gameplay gameplay = new Gameplay(mainFrame, counterGrid);
        mainFrame.getResetButton().setGameplay(gameplay).startListener();

        gameplay.startGame(gridInt);

        // Check if user wants to restart the game
        while (true) {
            boolean check = gameplay.endGame(gridInt);
            if (!check) break;
        }


    }
}
