package gameplay;

import graphics.CounterGrid;
import graphics.MainFrame;

import javax.swing.*;

public class Gameplay {
    private final CounterGrid counterGrid;
    private final MainFrame mainFrame;
    private int[] rowNum = {6, 6, 6, 6, 6, 6, 6};

    public Gameplay(MainFrame mainFrame, CounterGrid counterGrid) {
        this.mainFrame = mainFrame;
        this.counterGrid = counterGrid;

        JOptionPane.showMessageDialog(mainFrame,
                """
                        Connect 4 Game!
                        To Start select one of 7 positions to place your counter.
                        After you place your counter, your bot opponent will place
                        their counter.
                        To win you must get 4 of your counters in Vertical,
                        Horizontal, or Diagonal row, before the bot does!!!""",
                "Let's Begin!", JOptionPane.INFORMATION_MESSAGE);
    }

    private static void printArr(int[][] gridInt) {
        for (int[] ints : gridInt) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    /**
     * When the game begins it asks the user to select a position
     *
     * @param gridInt An Int[][] that contains the colors of every Counter in the counterGrid
     */
    public void startGame(int[][] gridInt) {

        WinCheck winCheck = new WinCheck(gridInt);
        boolean turn = false;

        while (true) { // Beginning of Game
            int pos;

            while (true) {

                mainFrame.repaint();

                // Get the selected column number
                do {
                    pos = mainFrame.getClickRows().getActiveId();
                } while (pos == -1);
                mainFrame.getClickRows().getClickRowArr()[pos].setActive(false);

                // Converting the isle number to the correct position in the array
                if (pos <= 6) {

                    // Error when user tries to place counter in a slot that is already filled.
                    if (rowNum[pos] == 0) {
                        JOptionPane.showMessageDialog(mainFrame, "ERROR: Not Possible Position!", "ERROR", JOptionPane.ERROR_MESSAGE);
                        continue;
                    }
                    rowNum[pos]--;
                    break;
                }

            }

            // Check for draws
            int checkDraw = 0;
            if (rowNum[0] == 0) {
                for (int i = 1; i < 7; i++) {
                    if (rowNum[i] == 0) {
                        checkDraw++;
                    } else break;
                }
            }

            // Updating the main Frame when a new counter is placed
            counterGrid.getArr().get(rowNum[pos] * 7 + pos).setColor(gridInt, (turn ? 1 : 2));
            turn = !turn; // Changing to the next turn

            mainFrame.repaint();

            //Check For Winner
            if (winCheck.winnerResult(mainFrame, checkDraw)) break;
            printArr(gridInt);
            System.out.println();
        }
    }

    public boolean endGame(int[][] gridInt) {
        int restart = JOptionPane.showConfirmDialog(mainFrame, "Would You like to play again?", "Game Over!", JOptionPane.YES_NO_OPTION);
        if (restart == JOptionPane.YES_OPTION) {
            counterGrid.clearGrid(gridInt);

            rowNum = new int[]{6, 6, 6, 6, 6, 6, 6};
            startGame(gridInt);
            return true;
        }

        mainFrame.dispose();
        return false;
    }

    public void reset(int[][] gridInt) {
        counterGrid.clearGrid(gridInt);
        rowNum = new int[]{6, 6, 6, 6, 6, 6, 6};
        startGame(gridInt);
    }

}
