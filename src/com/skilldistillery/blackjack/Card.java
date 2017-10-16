package com.skilldistillery.blackjack;

public class Card {

	private Rank rank;
	private Suit suit;

	public String toString() {
		return this.rank.toString() + "-" + this.suit.toString();
	}

	public Card(Rank rank, Suit suit) {
		super();
		this.rank = rank;
		this.suit = suit;
	}

	
	

	public Rank getRank() {
		return this.rank;
	}

}
