package com.skilldistillery.players;

import com.skilldistillery.cardgame.Hand;
import com.skilldistillery.cards.Card;
import com.skilldistillery.cards.Deck;

public class Dealer extends Player {
	private Deck deck;
	private Hand hand;
	
	
		
	public Dealer() {
		super();
		
	}

	public Dealer(Deck deck, Hand hand) {
		super();
		this.deck = deck;
		this.hand = hand;
	}

	public Deck getDeck() {
		return deck;
	}

	public void setDeck(Deck deck) {
		this.deck = deck;
	}

	public Hand getHand() {
		return hand;
	}

	public void setHand(Hand hand) {
		this.hand = hand;
	}

	public Card dealCard() {
		return deck.dealCard();
		
	}
	
	public void shuffle(Deck deck) {
		deck.shuffle();
		
	}
	
	public int revealedDealerCardVal() {
		int value = 0;
		for(int i = 1; i < this.hand.getCards().size(); i++) {
			this.hand.getCards().get(i);
			value += this.hand.getCards().get(i).getValue();
		}
		return value;
	}	
	
	public int hiddenDealerCardVal() {
		int value = 0;
		for(int i = 0; i < this.hand.getCards().size() - 1; i++) {
			System.out.println(this.hand.getCards().get(i));
			value = this.hand.getCards().get(i).getValue();
		}
		return value;
	}

}
