package com.skilldistillery.cardgame;

import com.skilldistillery.cards.Card;

public class BlackjackHand extends Hand {
	
	public BlackjackHand() {
		
	}
	
	public int getHandValue() {
		
		int totalValue = 0;
		for (Card card : this.cards) {
			totalValue += card.getValue();
		}
		return totalValue;
	}
	
	public boolean isBlackjack() {
	
		boolean result = false;
		if(getHandValue() == 21) {
			result = true;
		}
		return result;
	}
	
	public boolean isBust() {
		
		boolean result = false;
		if(getHandValue() > 21) {
			result = true;
		}
		return result;
	}


}
