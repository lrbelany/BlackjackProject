package com.skilldistillery.players;

import java.util.Scanner;

import com.skilldistillery.cardgame.Hand;
import com.skilldistillery.cards.Card;
import com.skilldistillery.cards.Deck;

public class Dealer extends Player {
	Hand hand;

	public Dealer(String name, Hand hand) {
		super(name, hand);

	}

	private void run() {

		System.out.println("*** BlackJack Game ***");
		String name = "Challenger";
		Hand hp = new Hand();
		Player player = new Player(name, hp);
		Hand hd = new Hand();
		Player chance = new Dealer("Chance", hd);
		Deck deck = new Deck();
		for(int i = 0; i<6; i++) {
		deck.generateDeck();}
		 while (deck.cardsLeft() > 12) {
			if (deck.cardsLeft()<=24) {
				System.out.println("Cards low, deck.");
				deck.emptyDeck();
				for (int i = 0; i < 6; i++) {
					deck.generateDeck();}
			}
			System.out.println("");
			Card d = null;
			hd = new Hand();
			hp = new Hand();
			for (int i = 0; i < 2; i++) {
				Card p = deck.dealCard();
				hp.addCard(p);
				d = deck.dealCard();
				hd.addCard(d);
			}
			System.out.println("");
			System.out.println("You are dealt:");
			int playVal = hp.getCardsInHand();
			
			System.out.println("Dealer is showing a(n) " + d.getRank() + " of " + d.getSuit());
			int dCheck = d.getValue();
			int pbj = 0;
			int turn;
			if (playVal == 21 && dCheck != 10 && dCheck != (11)) {
				System.out.println("Black Jack! ");
				pbj = 1;
			} else if (playVal == 21 && (dCheck == 10)) {
				System.out.println("You have 21... dealer checks their cards...  ");
				if (hd.getValueOfHand() == 21) {
					System.out.println("Sorry the dealer also has 21. Its a push");
				} else {
					System.out.println("The dealer does not have 21! BlackJack!");
					pbj = 1;
				}
			} else if (playVal == 21 && (dCheck == 11)) {
				if (hd.getValueOfHand() == 21) {
					System.out.println("Sorry the dealer also has 21. You push.");
				} else {
					System.out.println("The dealer does not have 21! BlackJack!");
					pbj = 1;
				}

			} else if (playVal < 21 && (dCheck == 11 || dCheck == 10)) {
				System.out.println("Dealer checks cards...");
				if (hd.getValueOfHand() == 21) {
					System.out.println("Sorry the dealer has 21. You lose");

				} else {
					System.out.println("The dealer does not have 21.");
				}

			}

			}
			int pbj = 0;
			if (hp.getValueOfHand() <= 21 && pbj < 1) {
				
				chance.hitOrStay(deck, hd);
			}
			System.out.println();
			 while ( scan.next() != "N") {
				System.out.println(
					"Would you like to keep playing [Y] or [N]? ");
				String cont = scan.next().toUpperCase();
				switch (cont) {
				case "Y":
					continue;
				case "N":
					break; 
				default:
					System.out.println("Invalid entry.");
					continue;
				}
			}
			
		}	
	
	
	
	public void hitOrStay(Deck deck, Hand hand) {
		System.out.println("Dealers cards:");
		int move = hand.getCardsInHand();
		

		if (move < 17) {
			System.out.println("Dealer has " + move + ", dealer hits.");
			Card d = deck.dealCard();
			hand.addCard(d);
			System.out.println("Dealer draws: " + d);
			hitOrStay(deck, hand);

		} else if (move == 17) {
			System.out.println("Dealer has a soft 17, dealer hits.");
			Card d = deck.dealCard();
			hand.addCard(d);
			System.out.println("Dealer draws: " + d);
			hitOrStay(deck, hand);
		} else if ((move > 17 && move < 22) || (move == 17)) {
			System.out.println("Dealer has " + move + ", dealer stays.");
		} else if (move > 21) {
			System.out.println("Dealer busted.");
		}
	}
}
