package gameplay;

import graphics.CounterGrid;
import graphics.NextButton;

import javax.swing.*;

public class Gameplay {
    CounterGrid counterGrid;
    JFrame buildFrame;

    public Gameplay(JFrame buildFrame, CounterGrid counterGrid) {
        this.buildFrame = buildFrame;
        this.counterGrid = counterGrid;

        JOptionPane.showMessageDialog(null,
                """
                        Connect 4 Game!
                        To Start select one of 7 positions to place your counter.
                        After you place your counter, your bot opponent will place
                        their counter.
                        To win you must get 4 of your counters in row, Vertical,
                        Horizontal, or Diagonal, before the bot does!!!""",
                "Let's Start!", JOptionPane.INFORMATION_MESSAGE);
    }

    private static void printArr(int[][] gridInt) {
        for (int i = 0; i < gridInt.length; i++) {
            for (int j = 0; j < gridInt[i].length; j++) {
                System.out.print(gridInt[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * When the game begins it asks the user to select a position
     *
     * @param nextButton Button that tells the program to move on to the next turn
     * @param gridInt    An Int[][] that contains the colors of every Counter in the counterGrid
     */
    public void startGame(NextButton nextButton, int[][] gridInt) {

        int[] rowNum = {6, 6, 6, 6, 6, 6, 6};
        int pos;

        WinCheck winCheck = new WinCheck(gridInt);

        outerloop:
        while (true) { // Beginning of Game
            while (true) {

                buildFrame.repaint();
                // TODO: change word input to a mouse press over one of the 7 columns
                String posStr = JOptionPane.showInputDialog("Enter Position");

                // Converting the isle number to the correct position in the array
                if (isInteger(posStr)) {
                    pos = Integer.parseInt(posStr) - 1;
                    if (pos >= 0 && pos <= 6) {
                        rowNum[pos]--;
                        break;
                    }
                }
            }
            if (rowNum[pos] == -1) break outerloop;
            // Updating the main Frame when a new counter is placed
            counterGrid.getArr().get(rowNum[pos] * 7 + pos).setColor(gridInt, nextButton.getTurn());
            buildFrame.repaint();
            if (winCheck.checkWin() == 2) {
                System.out.println("Player 1: WINSSS ");
                break outerloop;
            } else if (winCheck.checkWin() == 1) {
                System.out.println("Player 2: WINSSS");
                break outerloop;
            } else {
                System.out.println("Continue!");
            }


//            nextButton.buttonClick();
            nextButton.nextTurn();
            printArr(gridInt);
            System.out.println();
        }
    }

    private boolean isInteger(String position) {
        try {
            Integer.parseInt(position);
            return true;
        } catch (Exception NumberFormatException) {
            return false;
        }
    }

}
