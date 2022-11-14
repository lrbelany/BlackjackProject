package com.skilldistillery.blackjack.app;

import java.util.Scanner;

import com.skilldistillery.cardgame.Hand;
import com.skilldistillery.cards.Card;
import com.skilldistillery.cards.Deck;
import com.skilldistillery.players.Player;

public class BlackJackApp {
	Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);

		app.run();
		kb.close();
	}

	private void hitOrStay(Deck deck, Hand hand, Player player, Scanner scan) {
		System.out.println("");
		String c = (hand.cardsInHand() > 2 ? "[H]it or [S]tay" : "[H]it or [S]tay or [D]ouble?");
		System.out.println(c);
		String choice = scan.next().toUpperCase();
		Object turn;
		switch (choice) {
		case "H":
			Card p = deck.dealCard();
			System.out.println("You draw a(n) " + p);
			hand.addCard(p);
			if (bustCheck(hand) == 1) {
				break;
			} else {

			}
		case "S":
			break;
		case "D":
			if (hand.cardsInHand() > 2) {
				System.out.println("Invalid entry.");
				break;
			}

		}

	}

	private int bustCheck(Hand hand) {
	
		return 0;
	}

	static int getInt(Scanner keyb) {
		int temp = 0;
		while (!keyb.hasNextInt()) {
			System.out.print("Invalid Entry. Use whole numbers only: "); // notifies user of invalid entry
			keyb.next();
		}
		temp = keyb.nextInt();
		if (temp < 0) {
			System.err.print("Invalid Entry. Please make a valid entry:");
			temp = getInt(keyb);
		}
		return temp;
	}

}
