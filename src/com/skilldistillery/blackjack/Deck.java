package com.skilldistillery.blackjack;

import java.util.ArrayList;
import java.util.Random;

public class Deck {

	private ArrayList<Card> cards;
	
	public Deck() {
		this.cards = new ArrayList<Card>();
		
	}
	
	public void fiftyTwoCards() {
		for(Rank cardRank : Rank.values()) {
		for (Suit cardSuit : Suit.values()) {
				this.cards.add(new Card(cardRank,cardSuit));
			}
		}
	}
	
	public void shuffle() {
		//create a temporary deck in order to shuffle cards
		ArrayList<Card> tempDeck = new ArrayList<Card>();
		//Get a random card
		Random random = new Random();
		int randomCardPull = 0;
		int fullSize = this.cards.size();
		for(int i = 0; i < fullSize; i++) {
			//pull random card
			randomCardPull = random.nextInt((this.cards.size()-1) + 1);
			tempDeck.add(this.cards.get(randomCardPull));
			//remove from actual deck
			this.cards.remove(randomCardPull);
		}
		//the cards are now shuffled and put back in the deck
		this.cards = tempDeck;
	}
	
	
	public String toString() {
		String cardNumber = "";
		for(Card cardA : this.cards) {
			cardNumber += "\n" + cardA.toString();
		
		}
		return cardNumber;
	}
	 	public void removeCard(int i) {
	 		this.cards.remove(i);
	 	}
	 	
	 	public Card getCard (int i) {
	 		return this.cards.get(i);
	 	}
	 	
	 	public void addCard(Card addCard) {
	 		this.cards.add(addCard);
	 	}
	 	
	 	//Draws from the deck
	 	public void draw(Deck comingFrom) {
	 		this.cards.add(comingFrom.getCard(0));
	 		comingFrom.removeCard(0);
	 	}
	 	
	 	public int fullDeck() {
	 		return this.cards.size();
	 	}
	 	// put cards back into deck
	 	public void returnCardsToDeck(Deck putInto) {
	 		int completeDeck = this.cards.size();
	 		
	 		for(int i = 0; i < completeDeck; i++) {
	 			putInto.addCard(this.getCard(i));
	 		}
	 		
	 		for(int i = 0; i < completeDeck; i++) {
	 			this.removeCard(0);
	 		}
	 	}
	 	
	 	
	 	
	 	public int cardsRank() {
	 		int totalValue = 0;
	 		int aces = 0;
	 		
	 		for(Card cardA : this.cards) {
	 			switch(cardA.getRank()) {
	 			case TWO: totalValue += 2;
	 			break;
	 			case  THREE : totalValue += 3;
	 			break;
	 			case FOUR: totalValue += 4;
	 			break;
	 			case FIVE : totalValue += 5;
	 			break;
	 			case SIX: totalValue += 6;
	 			break;
	 			case SEVEN : totalValue += 7;
	 			break;
	 			case EIGHT: totalValue += 8;
	 			break;
	 			case NINE : totalValue += 9;
	 			break;
	 			case TEN: totalValue += 10;
	 			break;
	 			case JACK : totalValue +=10;
	 			break;
	 			case QUEEN: totalValue += 10;
	 			break;
	 			case KING : totalValue += 10;
	 			break;
	 			case ACE : aces +=1;
	 			break;
	 			}
	 		}
	 		for(int i = 0; i < aces; i++) {
	 			
	 			if(totalValue > 10) {
	 				totalValue += 1;
	 			}
	 			else {
	 				totalValue += 11;
	 			}
	 		}
	 		
	 		return totalValue;
	 	}
	 	
}