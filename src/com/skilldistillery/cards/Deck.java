package com.skilldistillery.cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

	//has-a composition/ association
private List<Card> deck = new ArrayList<>();


public Deck() {
	Rank[] ranks = Rank.values();
	CardSuits[] cardsuits = CardSuits.values();

	for( CardSuits cardsuits1 : cardsuits) {
	
//for each suit(all 4 of them
for(Rank rank : ranks) {
	
	//for each rank(all 13)
	Card aCard = new Card (cardsuits1, rank);
	deck.add(aCard);
}
}
}
public void fancyShuffle() {
Collections.shuffle(deck);	
}
	public int checkDeckSize() {
		return deck.size();
		
	}
public Card dealCard() {
//deal top card
	return deck.remove(1);


}


}
