package dynamicprogramming;

/*
Robot can move up, down, left and right
 */
public class CountNoOfWaysOfRobotMove {

    // moves i.e. right, left, up, down
    private final int[] rows = {0, 0, -1, 1};
    private final int[] cols = {1, -1, 0, 0};

    private final int SIZE = 4;
    private final int ROW = 4;
    private final int COL = 4;

    private int count = 0;

    public void getNoOfWays() {
        boolean[][] visited = new boolean[ROW][COL];
        getNoOfWaysUtil(visited, 0, 0);
    }

    private void getNoOfWaysUtil(boolean[][] visited, int srcRow, int srcCol) {
        //check for base case
        if (srcRow == ROW - 1 && srcCol == COL - 1) {
            count++;
            return;
        }

        // mark this node as visited.
        visited[srcRow][srcCol] = true;

        //iterate over all moves
        for (int i = 0; i < SIZE; i++) {
            //check for valid moves
            if ((srcRow + rows[i]) < ROW && (srcRow + rows[i]) >= 0 && (srcCol + cols[i]) < COL &&
                    (srcCol + cols[i]) >= 0 && !visited[srcRow + rows[i]][srcCol + cols[i]]) {
                getNoOfWaysUtil(visited, srcRow + rows[i], srcCol + cols[i]);
            }
        }

        // mark this node as unvisited
        visited[srcRow][srcCol] = false;
    }


    public static void main(String[] args) {
        CountNoOfWaysOfRobotMove move = new CountNoOfWaysOfRobotMove();
        move.getNoOfWays();

        System.out.println(move.count);
    }

}

