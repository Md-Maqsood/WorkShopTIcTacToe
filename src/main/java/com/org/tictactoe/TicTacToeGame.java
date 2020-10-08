package com.org.tictactoe;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TicTacToeGame {
	static final Logger logger = LogManager.getLogger(TicTacToeGame.class);

	public static char[] setUpBoard() {
		char[] board=new char[10];
		for (int i = 1; i < board.length; i++) {
			board[i] = ' ';
		}
		return board;
	}

	public static void main(String[] args) {
		char[] board = setUpBoard();
	}
}
