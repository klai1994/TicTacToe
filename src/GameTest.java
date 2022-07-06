import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GameTest {

	@Test
	void test() {
		Main main = new Main();
		char[][] board = new char[3][3];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j <  board.length; j++) {
				board[i][j] = '-';
			}
		}
		boolean output = main.isClear(board);
		assertEquals(false, output);
	}

}
