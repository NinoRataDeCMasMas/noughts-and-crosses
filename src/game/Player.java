package game;

public class Player {
	
	private String name;
	private boolean turn;
	private String symbol;
	
	public Player() {
		super();
	}
	
	public Player(String symbol) {
		super();
		this.symbol = symbol;
	}

	public Player(String name, boolean turn, String symbol) {
		super();
		this.name = name;
		this.turn = turn;
		this.symbol = symbol;
	}
	
	

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public boolean isTurn() {
		return turn;
	}
	
	public void setTurn(boolean turn) {
		this.turn = turn;
	}

	public String getSymbol() {
		return symbol;
	}

}
