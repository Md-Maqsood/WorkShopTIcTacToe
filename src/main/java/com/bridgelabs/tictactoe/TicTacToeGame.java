package com.bridgelabs.tictactoe;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TicTacToeGame {
	private static final int head=0;
	private static final int tail=1;
	static char playerLetter, computerLetter;
	static Players playerToMove;
	private static int[][] winningCombinations=new int[][] {
		{0,1,2},
		{3,4,5},
		{6,7,8},
		{0,3,6},
		{1,4,7},
		{2,5,8},
		{0,4,8},
		{2,4,6}
	};
	public enum Players{
		PLAYER, COMPUTER
	}
	
	public enum GameStatus{
		TIE, PLAYER_WON, COMPUTER_WON, CHANGE_TURN
	}
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
	public static boolean checkIfPositionIsAvailable(int position, char[] board) {
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
			if(checkIfPositionIsAvailable(position, board)) {
				return position;
			}else {
				logger.info("Selected index is already filled");
			}
		}
	}
	
	/**
	 * uc5
	 * @param position
	 * @param letter
	 * @param board
	 * @return
	 */
	public static char[] makeMove(int position, char letter, char[] board) {
		board[position]=letter;
		return board;
	}
	
	/**uc6
	 * @return
	 */
	public static Players getWhoStartsFirst() {
		int a=(int)(Math.floor(Math.random()*10)) % 2;
		if(a==head) {
			logger.info("Player moves first");
			return Players.PLAYER;
		}else {
			logger.info("Computer moves first");
			return Players.COMPUTER;
		}
	}
	
	/**
	 * uc7
	 * @param letter
	 * @param board
	 * @return
	 */
	public static GameStatus getGameStatus(char letter, char[] board) {
		for(int [] combination: winningCombinations) {
			if((board[combination[0]]==letter)&&(board[combination[1]]==letter)&&(board[combination[2]]==letter)){
				if(letter==playerLetter) {
					return GameStatus.PLAYER_WON;
				}
				else {
					return GameStatus.COMPUTER_WON;
				}
			}
		}
		for(int position=0;position<board.length-1;position++) {
			if(board[position]==' ') {
				return GameStatus.CHANGE_TURN;
			}
		}
		return GameStatus.TIE;
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		char[] board= setUpBoard();
		char playerChoice=chooseLetter(sc);
		if(playerChoice=='X') {
			playerLetter='X';
			computerLetter='O';
		}
		else {
			playerLetter='O';
			computerLetter='X';
		}
		Players firstToMove=getWhoStartsFirst();
		playerToMove=firstToMove;
		while(true) {
			GameStatus gameStatus;
			if(playerToMove==Players.PLAYER) {
				displayBoard(board);
				int desiredPosition=getPlayersMovePosition(sc, board);
				makeMove(desiredPosition, playerLetter, board);
				gameStatus=getGameStatus(playerLetter, board);
			}
			else {
				displayBoard(board);
				int desiredPosition=getPlayersMovePosition(sc, board);
				makeMove(desiredPosition, computerLetter, board);
				gameStatus=getGameStatus(computerLetter, board);
			}
			if(gameStatus==GameStatus.PLAYER_WON) {
				logger.info("Player won.");
				displayBoard(board);
				break;
			}else if(gameStatus==GameStatus.COMPUTER_WON) {
				logger.info("Computer won.");
				displayBoard(board);
				break;
			}else if(gameStatus==GameStatus.CHANGE_TURN) {
				if(playerToMove==Players.PLAYER) {
					playerToMove=Players.COMPUTER;
				}else {
					playerToMove=Players.PLAYER;
				}
			}else if(gameStatus==GameStatus.TIE) {
				logger.info("Game ended in a tie.");
				break;
			}
			
		}
		
		
	}
}
