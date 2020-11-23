package Blackjack;

public class Card{
	private Suit suit;
	private Value symbol;

	public Card(Suit suit, Value symbol){
		this.suit = suit;
		this.symbol = symbol;
	}
	public String getSuit(){
		return this.suit.toString() + "  " + this.symbol.toString();
	}
	public Value getValue() {
		return this.symbol;
	}
	
}
