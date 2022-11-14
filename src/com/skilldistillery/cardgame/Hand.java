package com.skilldistillery.cardgame;

import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.cards.Card;

public class Hand {
	private List<Card> hand = new ArrayList<Card>(0);

	public void addCard(Card card) {
		getHand().add(card);
	}

	public int getCardsInHand() {
		int tVal = 0;
		for (Card card : getHand()) {
			System.out.println(card);
			tVal = card.getValue() + tVal;

		}
		return tVal;
		
	}

	public void getValueOfHand() {
		int tVal = 0;
		for (Card card : getHand()) {
			tVal = card.getValue() + tVal;
		}
		

	}

	public int cardsInHand() {
		int size = getHand().size();
		return size;
	}

	public int getHandValue() {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<Card> getHand() {
		return hand;
	}

	public void setHand(List<Card> hand) {
		this.hand = hand;
	}

}
