package com.org.tictactoe;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TicTacToeGame {
	static final Logger logger = LogManager.getLogger(TicTacToeGame.class);
	static char[] board;
	/**
	 * uc1
	 * @return
	 */
	public static char[] setUpBoard() {
		board=new char[10];
		for (int i = 0; i < board.length-1; i++) {
			board[i] = ' ';
		}
		return board;
	}

	public static void main(String[] args) {
		setUpBoard();		
	}
}
