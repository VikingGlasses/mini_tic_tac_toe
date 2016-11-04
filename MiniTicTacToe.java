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
		
		System.out.println("Welcome to Tic Tac Toe");
		while (playing) {
			
			for (int turn = 0; turn < numberOfSquares; turn++) {
				printBoard();
				currentPlayer = whosTurn(turn);
				System.out.print(currentPlayer + "'s turn to make a move: ");
				currentMove = getMove();
				if (hasWon(currentMove)) {
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

	private boolean hasWon(String currentMove) {
		// TODO Auto-generated method stub
		return false;
	}

	private String getMove() {
		// TODO Implement getMove()
		return null;
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
