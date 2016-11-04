import java.util.Scanner;

public class MiniTicTacToe {
	
	public static final char X = 'X';
	public static final char O = 'O';
	public static final char EMPTY = ' ';
	
	private char[][] board;
	private Scanner keyboard;

	public static void main(String[] args) {
		MiniTicTacToe game = new MiniTicTacToe();
		game.run();
	}

	private void run() {
		
		keyboard = new Scanner(System.in);
		board = initiateBoard();
		boolean playing = true;
		int numberOfSquares = board.length * board[0].length;
		String currentMove;
		
		// TODO print welcome message
		System.out.println("Welcome to Tic Tac Toe");
		// --loop-- 
		while (playing) {
			//   --take turn loop--
			for (int turn = 0; turn < numberOfSquares; turn++) {
				//     print board
				printBoard();
				//     print 'X' or 'O' turn to move
				printTurn(turn);
				//     make a move
				currentMove = getMove();
				//     IF winning move
				if (winner(currentMove)) {
					//       break turn loop
					// print winner
					break;
				} else if (turn == numberOfSquares) {
					// print draw message
				}
			}
			//   --END turn loop--
		}
		// --END loop--
		
	}

	private boolean winner(String currentMove) {
		// TODO Auto-generated method stub
		return false;
	}

	private String getMove() {
		// TODO Auto-generated method stub
		return null;
	}

	private void printTurn(int turn) {
		// TODO Auto-generated method stub
		
	}

	private void printBoard() {
		// TODO Auto-generated method stub
		
	}

	private char[][] initiateBoard() {
		// TODO Auto-generated method stub
		return null;
	}

}
