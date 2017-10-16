package com.skilldistillery.blackjack;

import java.util.Scanner;

public class Game{

public static void main(String[] args) {
	System.out.println("-----------------");
	System.out.println("|--  Welcome  --|");
	System.out.println("|--    to     --|");
	System.out.println("|-- BlackJack --|");
	System.out.println("|--  Casino!  --|");
	System.out.println("-----------------");
	
	//make the playing deck
	Deck gameDeck = new Deck();
	gameDeck.fiftyTwoCards();
	gameDeck.shuffle();
	
	//make a deck for the player
	
	Deck playerDeck = new Deck();
	
	Deck dealerDeck = new Deck();
	
	double playerWallet = 500;
	
	Scanner kb = new Scanner(System.in);
	//Game loop
	while (playerWallet > 0) {//continue playing
		//Takes bet
		System.out.println("You have $" + playerWallet + ", how much do you want to bet?" );
		double playerBet = kb.nextDouble();
		if(playerBet > playerWallet) {
			System.out.println("You cannot bet more than you have. Time to go home.");
			break;
		}
		
		
		//player gets 2 cards
		playerDeck.draw(gameDeck);
		playerDeck.draw(gameDeck);
		
		//dealer gets 2 cards
		dealerDeck.draw(gameDeck);
		dealerDeck.draw(gameDeck);
		
		boolean roundEnd = false;
		
		while(true) {
			//display players hand
			System.out.println("Your cards:" + playerDeck.toString());
			
			System.out.println("Your hand's total is: " + playerDeck.cardsRank());
		
			//display dealer hand
			System.out.println("Dealer's cards: " + dealerDeck.getCard(0).toString() + " and Facedown card" );
			
			//choice of hit or stay
			System.out.println("What would you like to do (1)Hit or (2) Stay?");
			int choice = kb.nextInt();
			
			//hit
			if(choice == 1) {
				playerDeck.draw(gameDeck);
				System.out.println("You draw a: " + playerDeck.getCard(playerDeck.fullDeck()-1).toString());
			if(playerDeck.cardsRank() > 21) {
				System.out.println(playerDeck.cardsRank() +" Bust!");
				playerWallet -= playerBet;
				roundEnd = true;
				break;
			}
		}
		//stay	
		if(choice==2) {
			break;
		}
	  }
		//dealers hand reveal
		System.out.println("Dealers hand:" + dealerDeck.toString());
		if((dealerDeck.cardsRank() > playerDeck.cardsRank()) && roundEnd == false) {
			System.out.println("Dealer wins...");
			playerWallet -= playerBet;
			roundEnd = true;
		}
		//dealer hits or stays
		while((dealerDeck.cardsRank() < 17) && roundEnd == false) {
			dealerDeck.draw(gameDeck);
			System.out.println("Dealer draws a: " + dealerDeck.getCard(dealerDeck.fullDeck()-1).toString());
		}
		
		System.out.println("Dealer's hand equals: " + dealerDeck.cardsRank());
		if((dealerDeck.cardsRank() > 21) && roundEnd == false) {
			System.out.println("Dealer busts! You win!");
			playerWallet += playerBet;
			roundEnd = true;
		}
		
		if((playerDeck.cardsRank() == dealerDeck.cardsRank()) && roundEnd == false) {
			System.out.println("Push. No one wins. Player gets bet back.");
			roundEnd = true;
		}
		
		if((playerDeck.cardsRank() > dealerDeck.cardsRank()) && roundEnd == false) {
			System.out.println("You win!");
			playerWallet += playerBet;
			roundEnd = true;
		}
		//return player cards to deck
		playerDeck.returnCardsToDeck(gameDeck);
		//return dealer cards to deck
		dealerDeck.returnCardsToDeck(gameDeck);
		System.out.println("End of hand.");
	}
	System.out.println("GAME OVER. You are broke.");
	
   }
}