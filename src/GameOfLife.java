
/* 
 * Complexity of algorithm is O(m*n), where m is no of rows,  n is number of coloum.
 *  
 * */

public class GameOfLife {

	int m;
	int n;

	public void gameOfLife(int[][] board) {

		if (board == null || board.length == 0)
			return;

		m = board.length;
		n = board[0].length;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {

				int count = countLives(board, i, j);

				if (board[i][j] == 1 && (count < 2 || count > 3)) {
					board[i][j] = 2;
				}

				if (board[i][j] == 0 && (count == 3)) {
					board[i][j] = 3;
				}

			}
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == 3) {
					board[i][j] = 1;
				}

				if (board[i][j] == 2) {
					board[i][j] = 0;
				}
			}
		}

	}

	private int countLives(int[][] board, int i, int j) {

		int count = 0;

		int[][] dirs = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 }, { -1, -1 }, { -1, 1 }, { 1, 1 }, { 1, -1 } };

		for (int[] dir : dirs) {
			int r = i + dir[0];
			int c = j + dir[1];

			if (r >= 0 && c >= 0 && r < m && c < n && (board[r][c] == 1 || board[r][c] == 2)) {
				count++;
			}
		}

		return count;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] board = { { 0, 1, 0 }, { 0, 0, 1 }, { 1, 1, 1 }, { 0, 0, 0 } };

		GameOfLife objIn = new GameOfLife();

		objIn.gameOfLife(board);

	}

}
