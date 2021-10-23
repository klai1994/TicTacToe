import java.util.Scanner;

public class Main {

	static final int BOARD_SIZE = 3;
	static char[][] board = new char[BOARD_SIZE][BOARD_SIZE];
	static Scanner scanner = new Scanner(System.in);
	
	// true = player 1, false = player 2
	static boolean playerTurn = true;	
	static int colChoice;
	static int rowChoice;
	
	static String player1Name;
	static String player2Name;
	
	public static void main(String[] args) {	
		
		clearBoard();	
		
		System.out.println("Player 1 (X), please enter your name.");
		player1Name = scanner.nextLine();
		System.out.println("Player 2 (O), please enter your name.");
		player2Name = scanner.nextLine();
		
		showBoard();
		
		while (true) {
			if (playerTurn == true) {
				getPlayerMove(BOARD_SIZE, playerTurn);
				showBoard();
			}
			else {				
				getPlayerMove(BOARD_SIZE, playerTurn);
				showBoard();
			}
			playerTurn = !playerTurn;
			
			if (checkVictory() == 'X') {
				System.out.println(player1Name + " is the winner!");
				clearBoard();
				showBoard();
			}
			else if (checkVictory() == 'O') {
				System.out.println(player2Name + " is the winner!");
				clearBoard();
				showBoard();
			}
		}

	}

	static private char checkVictory() {
		
		int horizontal = 1;
		int vertical = 1;
		int diagonal = 1;
		int backDiagonal = 0;
		
		for (int i = 0; i < BOARD_SIZE - 1; i++) {
			for (int j = 0; j < BOARD_SIZE - 1; j++) {
				if (board[i][j] == board[i][j + 1]) {
					horizontal++;
				}
				if (board[j][i] == board[j + 1][i]) {
					vertical++;
				}
			}
			
			if (horizontal == BOARD_SIZE || vertical == BOARD_SIZE) {
				return board[i][i];
			}
			horizontal = 1;
			vertical = 1;
		}
		
		for (int i = 0; i < BOARD_SIZE - 1; i++) {
			if (board[i][i] == board[i + 1][i + 1]) {
				diagonal++;
			}
			if (board[BOARD_SIZE - 1][BOARD_SIZE - 1] == board[BOARD_SIZE - i - 1][BOARD_SIZE - i - 1]) {
				backDiagonal++;
			}
			if (diagonal == BOARD_SIZE || backDiagonal == BOARD_SIZE) {
				return board[i][i];
			}
		}

		return '-';
	}
	
	private static void getPlayerMove(int boardSize, boolean playerTurn) {
	
		while (true) {
			System.out.println((playerTurn ? player1Name : player2Name) + "'s turn.");
			
			System.out.println(String.format("Choose a column (%d-%d).", 1, boardSize));
			colChoice = scanner.nextInt();
			System.out.println(String.format("Choose a row (%d-%d).", 1, boardSize));
			rowChoice = scanner.nextInt();
			
			// Check to make sure it is in bounds first
			if (colChoice < 1 || colChoice > boardSize || rowChoice < 1 || rowChoice > boardSize) {
				System.out.println("That position is invalid. Please try again.");
				continue;
			}
			
			// Decrementing to make it easier to access array index
			colChoice--;
			rowChoice--;
			if (board[colChoice][rowChoice] != '-') {
				System.out.println("That position is already filled. Please choose another.");
				continue;
			}
			break;
		}
		
		if (playerTurn) {
			board[colChoice][rowChoice] = 'X';
		}
		else {
			board[colChoice][rowChoice] = 'O';
		}
	}

	private static void clearBoard() {
		for (int i = 0; i < BOARD_SIZE; i++){
			for (int j = 0; j < BOARD_SIZE; j++) {
				board[i][j] = '-';
			}
		}
	}
	
	private static void showBoard() {
		for (int i = 0; i < BOARD_SIZE; i++){
			for (int j = 0; j < BOARD_SIZE; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}	
	}

}
