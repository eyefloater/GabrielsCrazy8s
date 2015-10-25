package com.gaby;

import java.util.List;

public class RunGame {

	public static void main(String[] args) {

		System.out.println("WELCOME TO FULLY AUTOMATED CRAZY EIGHTS!");
		// creates deck
		Deck deck = new Deck();
		
		// prints out deck (FOR TESTING)
		//deck.check();
		// creates shuffled deck
		ShuffledDeck shuffledDeck = new ShuffledDeck(deck);
		
		// prints out shuffled deck (FOR TESTING)
		//shuffledDeck.check();
		// says whether deck is full or not
		if (shuffledDeck.checkAll()) {
			System.out.println("We have a full deck.");
		} else {
			System.out.println("We don't have a full deck.");

		}
		// names players
		String playerOneName = "First Player";
		String playerTwoName = "Second Player";

		// instantiates two players
		Player playerOne = new Player(playerOneName);
		Player playerTwo = new Player(playerTwoName);

		// deal cards from shuffled deck
		List<Card> listForPlayerOne = shuffledDeck.dealCards();
		playerOne.setPlayerHand(listForPlayerOne);

		List<Card> listForPlayerTwo = shuffledDeck.dealCards();
		playerTwo.setPlayerHand(listForPlayerTwo);
		

		// print out Players' hands
		playerOne.printHand();
		playerTwo.printHand();

		//creates discard pile, gets and prints out top card
		DiscardPile discardPile = new DiscardPile();
		Card faceUpCard = shuffledDeck.getTopCard();
		discardPile.addCard(faceUpCard);
		faceUpCard.print();
		System.out.println("\nGAME BEGINS!");
		
		// main game loop. 
		while (true) {
			
			// prints player one's hand
			playerOne.printHand();
			
			//instantiates top card in stockpile
			Card newCard = shuffledDeck.getTopCard();
			
			//ends game and runs scoring if there are no cards left in stockpile
			if (newCard == null) {
				System.out.println("\nNo cards left in deck. GAME OVER.");
				int playerOneScore = Scoring.getScore(listForPlayerOne);
				int playerTwoScore = Scoring.getScore(listForPlayerTwo);
				System.out.println("Player one's score is "+playerOneScore);
				System.out.println("Player two's score is "+playerTwoScore);
				break;
			}
			
			// if there is a card left in stockpile, player draws it, adds it to their hand
			if (newCard != null) {
				System.out.print("You drew a(n) ");
				newCard.print();
				playerOne.addCard(newCard);
				
				//gets card on top of discard pile
				Card topCard = discardPile.getTopCard();
				
				//prints discard top card, if there is one
				if (topCard != null) {
					System.out.print("Top card on discard pile is: ");
					topCard.print();

					// player one discards.
					Card discardedCard = playerOne.discard(topCard);
					if (discardedCard != null) {
						discardPile.addCard(discardedCard);
						System.out.print(playerOneName + " discarded ");
						discardedCard.print();
					}
					
					// error check, in case the discard is empty for some reason
				} else {
					System.out.println("Error: Discard pile is empty.");
					break;
				}
			}
			
			// prints player two's hand
			playerTwo.printHand();
			
			//gets top card from stockpile
			Card newCardTwo = shuffledDeck.getTopCard();
			
			//ends game and runs scoring if there are no cards left in stockpile
			if (newCardTwo == null) {
				System.out.println("\nNo cards left in deck. GAME OVER.");;
				int playerOneScore = Scoring.getScore(listForPlayerOne);
				int playerTwoScore = Scoring.getScore(listForPlayerTwo);
				System.out.println("Player one's score is "+playerOneScore);
				System.out.println("Player two's score is "+playerTwoScore);
				break;
			}
			
			
			// if there is a card left in stockpile, player draws it, adds it to their hand
			if (newCardTwo != null) {
				System.out.print("You drew a(n) ");
				newCardTwo.print();
				playerTwo.addCard(newCardTwo);
				
				//gets card on top of discard pile, prints it
				Card topCard = discardPile.getTopCard();
				if (topCard != null) {
					System.out.print("Top card on discard pile is: ");
					topCard.print();

					// player two discards.
					Card discardedCard = playerTwo.discard(topCard);
					if (discardedCard != null) {
						discardPile.addCard(discardedCard);
						System.out.print(playerTwoName + " discarded ");
						discardedCard.print();
					}
				} else {
					System.out.println("Error: Discard pile is empty.");
					break;
				}
			}

		}
		
	}
}