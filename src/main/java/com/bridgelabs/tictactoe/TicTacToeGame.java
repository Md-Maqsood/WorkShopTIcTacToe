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
	
	/**
	 * uc2
	 * @param sc
	 * @return
	 */
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
	
	/**
	 * uc3
	 * @param board
	 */
	public static void displayBoard(char[] board) {
		for(int i=0;i<board.length-1;i++) {
			System.out.print(board[i]+" ");
			if(i%3==2) {
				System.out.println();
			}
		}
	}

	/**
	 * uc4
	 * @param position
	 * @param board
	 * @return
	 */
	public static boolean positionIsFree(int position, char[] board) {
		return board[position]==' ';
	}
	/**
	 * uc4
	 * @param sc
	 * @param board
	 * @return
	 */
	public static int getPlayersMovePosition(Scanner sc, char[] board) {
		while(true) {
			logger.info("Select the index from 1 to 9");
			int position=sc.nextInt()-1;
			if(positionIsFree(position, board)) {
				return position;
			}else {
				logger.info("Selected index is already filled");
			}
		}
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
		displayBoard(board);
		int desiredPosition=getPlayersMovePosition(sc, board);
		
		
	}
}
