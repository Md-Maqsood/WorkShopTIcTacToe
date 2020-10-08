package com.bridgelabs.tictactoe;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TicTacToeGame {
	static final Logger logger = LogManager.getLogger(TicTacToeGame.class);
	/**
	 * uc1
	 * @return
	 */
	public static char[] setUpBoard() {
		char[] board=new char[10];
		for (int i = 0; i < board.length-1; i++) {
			board[i] = ' ';
		}
		return board;
	}
	
	public static char chooseLetter(Scanner sc) {
		logger.info("Enter the letter choice ('X' or 'O'): ");
		char playerChoice=sc.nextLine().charAt(0);
		if(playerChoice=='X') {
		logger.info("Player Letter is 'X'. Computer Letter is 'O'.");
		}
		else {
			logger.info("Player Letter is 'O'. Computer Letter is 'X'.");
		}
		return playerChoice;
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		char[] board= setUpBoard();
		char playerLetter, computerLetter;
		char playerChoice=chooseLetter(sc);
		if(playerChoice=='X') {
			playerLetter='X';
			computerLetter='O';
		}
		else {
			playerLetter='O';
			computerLetter='X';
		}
		
	}
}
