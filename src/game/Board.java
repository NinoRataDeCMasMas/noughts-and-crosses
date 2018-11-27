package game;

public class Board {

	
	Board(){
		board = new String[3][3];
		numberOfMoves = 9;
		initialize();
	}

	public String[][] getBoard() {
		return board;
	}

	private void initialize() {
		int position = 1;

        for(int i=0;i<3;i++){
        		for(int j=0; j<3;j++){
        			board[i][j] = Integer.toString(position);
        			position++;
            }
        }
	}

	public void print() {

		System.out.println("\n");
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (j < 2) {
					System.out.print(" " + board[i][j] + " |");
				} else {
					System.out.print(" " +  board[i][j] + " ");
				}
			}
			if (i < 2) {
				System.out.println("\n-----------");
			}
		}
		System.out.println("\n");

	}

	public boolean markPosition(int x, int y, String symbol) {
		if(board[x][y] != "X" && board[x][y] != "0") {
			board[x][y] = symbol;
			numberOfMoves--;
			return true;
		}else {
			return false;
		}
	}

	public int getNumberOfMoves(){
		return numberOfMoves;
	}



}
