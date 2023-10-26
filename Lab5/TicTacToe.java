package Lab5;

public class TicTacToe {
	private static final char EMPTY = ' ';
	private char[][] board;

	public boolean checkRows() {
		for (int i = 0; i < board.length; i++) {
			char c = board[i][0]; // Get the first character of the row
			if (c != EMPTY) { // If it is not empty, check the rest of the row
				boolean win = true; // Assume it is a win until proven otherwise
				for (int j = 1; j < board[i].length; j++) {
					if (board[i][j] != c) { // If any character does not match, it is not a win
						win = false;
						break;
					}
				}
				if (win)
					return true; // If all characters match, it is a win
			}
		}
		return false; // If no row is a win, return false
	}

	public boolean checkColumns() {
		for (int j = 0; j < board[0].length; j++) {
			char c = board[0][j]; // Get the first character of the column
			if (c != EMPTY) { // If it is not empty, check the rest of the column
				boolean win = true; // Assume it is a win until proven otherwise
				for (int i = 1; i < board.length; i++) {
					if (board[i][j] != c) { // If any character does not match, it is not a win
						win = false;
						break;
					}
				}
				if (win)
					return true; // If all characters match, it is a win
			}
		}
		return false; // If no column is a win, return false
	}

	public boolean checkDiagonals() {
		// Check top-left to bottom-right diagonal
		char c = board[0][0]; // Get the top-left character
		if (c != EMPTY) { // If it is not empty, check the rest of the diagonal
			boolean win = true; // Assume it is a win until proven otherwise
			for (int i = 1; i < board.length; i++) {
				if (board[i][i] != c) { // If any character does not match, it is not a win
					win = false;
					break;
				}
			}
			if (win)
				return true; // If all characters match, it is a win
		}

		// Check bottom-left to top-right diagonal
		c = board[board.length - 1][0]; // Get the bottom-left character
		if (c != EMPTY) { // If it is not empty, check the rest of the diagonal
			boolean win = true; // Assume it is a win until proven otherwise
			for (int i = 1; i < board.length; i++) {
				if (board[board.length - i - 1][i] != c) { // If any character does not match, it is not a win
					win = false;
					break;
				}
			}
			if (win)
				return true; // If all characters match, it is a win
		}

		return false; // If no diagonal is a win, return false
	}
	public static void main(String[] args) {
		TicTacToe game = new TicTacToe();
	    game.board = new char[][]{
	        {'X', 'O', 'X'},
	        {'O', 'X', 'O'},
	        {'O', 'X', 'X'}
	    };
	    System.out.println(game.checkRows()); 
	    System.out.println(game.checkColumns()); 
	    System.out.println(game.checkDiagonals()); 
	}
	}
	

