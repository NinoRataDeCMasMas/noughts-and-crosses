package game;

import java.util.Scanner;

public class NoughtsAndCrossesGame {
	
	private Player player1;
	private Player player2;
	private Board board;
	private Scanner scanner;

	
	NoughtsAndCrossesGame(){
		board = new Board();
		scanner = new Scanner(System.in);
	}
	
	
	public void play() {
		
		initPlayers();
		board.print();
		nextTurn();

	    while (scanner.hasNextInt()) { 
	    	  
	      if (makeMove(scanner.nextInt())) {
	    	    changeTurn();
	    	  	nextTurn();
	      }else {
	    	  	System.out.println("La casilla esta ocupada o no existe, Elija otra por favor");
	      }
	      
	      board.print();
	     
	      if(doWeHaveWinner()) {
	    	  	endGame();
	    	   	break;
	      }
	      
	    }
	}
	
	private void endGame() {
		scanner.close();
	    System.out.println("Fin del juego: ");
	}
	
	private boolean doWeHaveWinner() {
		
		Player player = checkForWinner();
		
		if (player != null) {
			System.out.println("El ganador es " + player.getName());
			return true;
		}
		
		if(board.getNumberOfMoves() == 0) {
			System.out.println("Empate");
			return true;
		}
			
		
		return false;
	}
	
	private Player checkForWinner(){
		
		for (int i = 0; i < 3; i++) {

			for (int j = 1; j < 2; j++) {

				if (board.getBoard()[j][i] == board.getBoard()[j - 1][i] && board.getBoard()[j][i] == board.getBoard()[j + 1][i]) {

					return getPlayer(board.getBoard()[j][i]);
					
				}
			}
		}

		if (board.getBoard()[1][1] == board.getBoard()[0][0] && board.getBoard()[1][1] == board.getBoard()[2][2]) {

			return getPlayer(board.getBoard()[1][1]);
	
		}

		if (board.getBoard()[1][1] == board.getBoard()[0][2] && board.getBoard()[1][1] == board.getBoard()[2][0]) {
			return getPlayer(board.getBoard()[1][1]);
		}
		
		return null;
		
	}
	
	private Player getPlayer(String symbol) {
		if(symbol == player1.getSymbol()) {
			return player1;
		}else if(symbol == player2.getSymbol()) {
			return player2;
		}else {
			return null;
		}
	}
	
	private void nextTurn() {
		if(player1.isTurn()) {
			System.out.println( player1.getName() +":["+player1.getSymbol()+"] Elija un numero de casilla entre 1 y 9.");
		}else {
			System.out.println( player2.getName() +":["+player2.getSymbol()+"] Elija un numero de casilla entre 1 y 9.");
		}
	}
	
	private void changeTurn() {
		if(player1.isTurn()) {		
			player1.setTurn(false);
			player2.setTurn(true);
		}else {
			player1.setTurn(true);
			player2.setTurn(false);
		}
	}
	
	private boolean makeMove(int position) {
		switch (position) {

		case 1: return board.markPosition(0,0, getSymbolTurn());

		case 2: return board.markPosition(0,1, getSymbolTurn());

		case 3: return board.markPosition(0,2, getSymbolTurn());
	
		case 4: return board.markPosition(1,0, getSymbolTurn());

		case 5: return board.markPosition(1,1, getSymbolTurn());
	
		case 6: return board.markPosition(1,2, getSymbolTurn());
	
		case 7: return board.markPosition(2,0, getSymbolTurn());
	
		case 8: return board.markPosition(2,1, getSymbolTurn());

		case 9: return board.markPosition(2,2, getSymbolTurn());
		
		default:
			System.out.println("Por Favor, Ingrese Solo Un Digito Del 1 al 9.");
			return true;
		}
	}
	
	private String getSymbolTurn() {
		if(player1.isTurn()) {
			return player1.getSymbol();
		}else {
			return player2.getSymbol();
		}
	}
	

	
	private void initPlayers() {
		
		player1 = new Player("X");
		player1.setTurn(true);
		
		player2 = new Player("0");
		player2.setTurn(false);
		
		System.out.println("Proporcione el nombre del jugador 1");
		player1.setName(scanner.next());
		
		System.out.println("Proporcione el nombre del jugador 2");
		player2.setName(scanner.next());
		
	}
	

}
