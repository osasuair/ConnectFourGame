package gameplay;

import graphics.MainFrame;

import javax.swing.*;
import java.util.Objects;

public class WinCheck {
    private final int[][] gridInt;
    private final ImageIcon winnerIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/trophy.png")));
    private final ImageIcon drawGameIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/handshake.png")));

    public WinCheck(int[][] gridInt) {
        this.gridInt = gridInt;
    }

    private int checkWin() {

        final int HEIGHT = gridInt.length;
        final int WIDTH = gridInt[0].length;
        final int EMPTY_SLOT = 0;

        for (int r = 0; r < HEIGHT; r++) { // iterate rows, bottom to top
            for (int c = 0; c < WIDTH; c++) { // iterate columns, left to right
                int player = gridInt[r][c];
                if (player == EMPTY_SLOT)
                    continue; // don't check empty slots

                if (c + 3 < WIDTH &&
                        player == gridInt[r][c + 1] && // look right
                        player == gridInt[r][c + 2] &&
                        player == gridInt[r][c + 3])
                    return player;
                if (r + 3 < HEIGHT) {
                    if (player == gridInt[r + 1][c] && // look up
                            player == gridInt[r + 2][c] &&
                            player == gridInt[r + 3][c])
                        return player;
                    if (c + 3 < WIDTH &&
                            player == gridInt[r + 1][c + 1] && // look up & right
                            player == gridInt[r + 2][c + 2] &&
                            player == gridInt[r + 3][c + 3])
                        return player;
                    if (c - 3 >= 0 &&
                            player == gridInt[r + 1][c - 1] && // look up & left
                            player == gridInt[r + 2][c - 2] &&
                            player == gridInt[r + 3][c - 3])
                        return player;
                }
            }
        }
        return EMPTY_SLOT; // no winner found
    }

    public boolean winnerResult(MainFrame mainFrame, int checkDraw) {
        int winner = checkWin();

        if (winner == 2) {
            JOptionPane.showMessageDialog(mainFrame, "Player 1: WINS!", "Winner", JOptionPane.INFORMATION_MESSAGE, winnerIcon);
            return true;
        } else if (winner == 1) {
            JOptionPane.showMessageDialog(mainFrame, "Player 2: WINS!", "Winner", JOptionPane.INFORMATION_MESSAGE, winnerIcon);
            return true;
        } else if (checkDraw == 6) {
            JOptionPane.showMessageDialog(mainFrame, "It's A DRAW!", "DRAW", JOptionPane.INFORMATION_MESSAGE, drawGameIcon);
            return true;
        } else {
            JOptionPane.showMessageDialog(mainFrame, "Next Turn!", "Continue", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
    }
}
