package com.skilldistillery.cardgame;

import com.skilldistillery.cards.Card;

public class BlackjackHand extends Hand {

	public BlackjackHand() {
	}

	private void  bustCheck(Hand hand) {
		if (hand.getCardsInHand() > 21) {
			System.out.println("Bust! you have more than 21");
			
		}
		
	}

	private void outcome(Hand hp, Hand hd) {
		System.out.println("Player has: ");
		int p = hp.getCardsInHand();
		System.out.println("Dealer has: ");
		int d = hd.getCardsInHand();

		if (p == d && p < 21) {
			System.out.println("Push.");
		} else if (p < d && d <= 21) {
			System.out.println("Dealer wins.");
		} else if (p > d && p <= 21) {
			System.out.println("Player wins!");
		} else if (p > 21) {
			System.out.println("Player busted. Dealer wins!");
		} else if (d > 21) {
			System.out.println("Dealer busted. Player wins!");
		}
	}

	}

	@Override
	public int getHandValue() {
		int cardsValue = 0;

		for (Card card : Hand.this.cardsInHand() ) {
			cardsValue += card.getValue();

		}

		return cardsValue;

	}

}