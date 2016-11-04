import java.util.Scanner;

public class MiniTicTacToe {
	
	public static final char X = 'X';
	public static final char O = 'O';
	public static final char EMPTY = ' ';
	public static final int DEFUALT_SIZE = 3;
	
	private char[][] board;
	private Scanner keyboard;

	public static void main(String[] args) {
		MiniTicTacToe game = new MiniTicTacToe();
		game.run();
	}

	private void run() {
		
		keyboard = new Scanner(System.in);
		board = initiateBoard(DEFUALT_SIZE, DEFUALT_SIZE);
		boolean playing = true;
		int numberOfSquares = board.length * board[0].length;
		String currentMove;
		char currentPlayer;
		int index, row, col;
		
		System.out.println("Welcome to Tic Tac Toe");
		while (playing) {
			
			for (int turn = 0; turn < numberOfSquares; turn++) {
				printBoard();
				currentPlayer = whosTurn(turn);
				currentMove = getMove(currentPlayer + "'s turn to make a move: ");
				index = currentMove.indexOf(',');
				row = Integer.parseInt(currentMove.substring(0, index));
				col = Integer.parseInt(currentMove.substring(index + 1));
				board[row][col] = currentPlayer;
				if (hasWon(row, col)) {
					System.out.println(currentPlayer + "has won.");
					break; // for loop
				} else if (turn == numberOfSquares) {
					System.out.println("Stalemate!");
				}
			}
			if (playingAgain()) {
				resetBoard();
			} else {
				playing = false;
			}
			
		}
		
	}

	private void resetBoard() {
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[row].length; col++) {
				board[row][col] = EMPTY;
			}
		}
	}

	private boolean playingAgain() {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean hasWon(int row, int col) {
		// TODO Auto-generated method stub
		return false;
	}

	private String getMove(String anouncement) {
		// TODO Implement getMove()
		String input = "";
		while (!validMove(input)) {
			System.out.print(anouncement);
			input = keyboard.nextLine();
		}
		return input;
	}

	private boolean validMove(String input) {
		// TODO Auto-generated method stub
		// input = 12,14
		String temp = "";
		int indexOfComma;
		String row, col;
		int rowNr, colNr;
		temp = input;
		if (temp.length() < 3) {
			return false;
		}
		temp = temp.replace(' ', '\u0000'); // replaces whitespace with the empty char ''
		indexOfComma = temp.indexOf(',');
		if (indexOfComma == -1) {
			return false;
		}
		row = temp.substring(0, indexOfComma);
		col = temp.substring(indexOfComma + 1);
		if (isNumber(row) && isNumber(col)) {
			rowNr = Integer.parseInt(row);
			colNr = Integer.parseInt(col);
		} else {
			return false;
		}
		if (rowNr < 0 || colNr < 0) {
			return false;
		}
		if (rowNr >= board.length || colNr >= board[0].length) {
			return false;
		}
		if (board[rowNr][colNr] != EMPTY) {
			return false;
		}
		return true;
	}

	private boolean isNumber(String number) {
		try {
			Integer.parseInt(number);
			return true;
		} catch (NumberFormatException e) { }
		return false;
	}

	private char whosTurn(int turn) {
		char ch;
		if (turn % 2 == 0) {
			ch = X;
		} else {
			ch = O;
		}
		return ch;
	}

	private String printBoard() {
		String result = "";
		for (int row = 0; row < board.length; row++) {
			result += "+-----+\n";
			result += "|";
			for (int col = 0; col < board[row].length; col++) {
				result += board[row][col] + "|";
			}
			result += "\n";
		}
		result += "+-----+";
		return result;
	}

	private char[][] initiateBoard(int numberOfRows, int numberOfColumns) {
		return new char[numberOfRows][numberOfRows];
	}

}
