package gameplay;

import graphics.CounterGrid;
import graphics.MainFrame;
import graphics.NextButton;

import javax.swing.*;
import java.awt.*;

public class Gameplay {
    private final CounterGrid counterGrid;
    private final MainFrame mainFrame;
    private int[] rowNum = {6, 6, 6, 6, 6, 6, 6};

    public Gameplay(MainFrame mainFrame, CounterGrid counterGrid) {
        this.mainFrame = mainFrame;
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

        WinCheck winCheck = new WinCheck(gridInt);

        while (true) { // Beginning of Game
            int pos;
            while (true) {

                mainFrame.repaint();

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
            int check = 0;
            if (rowNum[0] == 0) {
                for (int i = 1; i < 7; i++) {
                    if (rowNum[i] == 0) {
                        check++;
                    } else break;
                }
            }


            // Updating the main Frame when a new counter is placed
            // TODO: Remove next button from changing the color
            counterGrid.getArr().get(rowNum[pos] * 7 + pos).setColor(gridInt, nextButton.getTurn());
            mainFrame.repaint();


            JLabel icon = new JLabel();
            icon.setIcon(new ImageIcon(getClass().getResource("/resources/downArrow.png")));

            // TODO: Make method to check if player wins inside on WinCheck Class and convert 'prints' to a JOptionPane
            if (winCheck.checkWin() == 2) {
                JOptionPane.showMessageDialog(mainFrame, "Player 1: WINS!", "Winner", JOptionPane.INFORMATION_MESSAGE, icon.getIcon());
                System.out.println("Player 1: WINSSS ");
                break;
            } else if (winCheck.checkWin() == 1) {
                System.out.println("Player 2: WINSSS");
                break;
            } else if (check == 6) {
                System.out.println("DRAW");
                break;
            } else {
                System.out.println("Continue!");
            }


            // TODO: Change Next Button to reset button
//            nextButton.buttonClick();
            nextButton.nextTurn();
            printArr(gridInt);
            System.out.println();
        }
    }

    public boolean endGame(int[][] gridInt) {
        int restart = JOptionPane.showConfirmDialog(mainFrame, "Would You like to play again?", "Game Over!", JOptionPane.YES_NO_OPTION);
        if (restart == JOptionPane.YES_OPTION) {
            counterGrid.clearGrid(gridInt);

            rowNum = new int[]{6, 6, 6, 6, 6, 6, 6};
            startGame(mainFrame.getNextButton(), gridInt);
            return true;
        }

        mainFrame.dispose();
        return false;
    }

}
