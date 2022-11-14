package com.skilldistillery.players;

import com.skilldistillery.cardgame.Hand;
import com.skilldistillery.cards.Deck;

public class Player {
	private String name;
	private Hand hand;

	public Player(String name, Hand hand) {
		super();
		this.name = name;
		this.setHand(hand);
		
	}

	public Player() {
		
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void getHand() {
		
	}
	public void setHand(Hand hand) {
		this.hand = hand;
	}



	public void hitOrStay(Deck deck, Hand hd, int s) {
		
		
	}
}
