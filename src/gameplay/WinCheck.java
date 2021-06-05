package gameplay;

public class WinCheck {
    private final int[][] gridInt;

    public WinCheck(int[][] gridInt) {
        this.gridInt = gridInt;
    }

    public int checkWin(){

        final int HEIGHT = gridInt.length;
        final int WIDTH = gridInt[0].length;
        final int EMPTY_SLOT = 0;
        for (int r = 0; r < HEIGHT; r++) { // iterate rows, bottom to top
            for (int c = 0; c < WIDTH; c++) { // iterate columns, left to right
                int player = gridInt[r][c];
                if (player == EMPTY_SLOT)
                    continue; // don't check empty slots

                if (c + 3 < WIDTH &&
                        player == gridInt[r][c+1] && // look right
                        player == gridInt[r][c+2] &&
                        player == gridInt[r][c+3])
                    return player;
                if (r + 3 < HEIGHT) {
                    if (player == gridInt[r+1][c] && // look up
                            player == gridInt[r+2][c] &&
                            player == gridInt[r+3][c])
                        return player;
                    if (c + 3 < WIDTH &&
                            player == gridInt[r+1][c+1] && // look up & right
                            player == gridInt[r+2][c+2] &&
                            player == gridInt[r+3][c+3])
                        return player;
                    if (c - 3 >= 0 &&
                            player == gridInt[r+1][c-1] && // look up & left
                            player == gridInt[r+2][c-2] &&
                            player == gridInt[r+3][c-3])
                        return player;
                }
            }
        }
        return EMPTY_SLOT; // no winner found
    }
}
