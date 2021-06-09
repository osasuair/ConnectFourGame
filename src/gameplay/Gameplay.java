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
     * @param nextButton Button that tells the program to move on to the next turn
     * @param gridInt    An Int[][] that contains the colors of every Counter in the counterGrid
     */
    public void startGame(NextButton nextButton, int[][] gridInt) {

        int[] rowNum = {6, 6, 6, 6, 6, 6, 6};
        int pos;

        WinCheck winCheck = new WinCheck(gridInt);


        while (true) { // Beginning of Game
            while (true) {

                buildFrame.repaint();
                // TODO: change word input to a mouse press over one of the 7 columns
                String posStr = JOptionPane.showInputDialog("Enter Position");

                // Converting the isle number to the correct position in the array
                if (isInteger(posStr)) {
                    pos = Integer.parseInt(posStr) - 1;
                    if (pos >= 0 && pos <= 6) {

                        // Error when user tries to place counter in a slot that is already filled.
                        // TODO: Change to JOptionPane.showMessage...
                        if (rowNum[pos] == 0) {
                            System.out.println("Not Possible");
                            continue;
                        }
                        rowNum[pos]--;
                        break;
                    }
                }
            }


            // Updating the main Frame when a new counter is placed
            counterGrid.getArr().get(rowNum[pos] * 7 + pos).setColor(gridInt, nextButton.getTurn());
            buildFrame.repaint();

            // TODO: Make method to check if player wins inside on WinCheck Class and convert 'prints' to a JOptionPane
            if (winCheck.checkWin() == 2) {
                System.out.println("Player 1: WINSSS ");
                break;
            } else if (winCheck.checkWin() == 1) {
                System.out.println("Player 2: WINSSS");
                break;
            } else {
                System.out.println("Continue!");
            }


            nextButton.buttonClick();
//            nextButton.nextTurn();
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
