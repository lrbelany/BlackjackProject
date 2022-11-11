package com.skilldistillery.cards;

import java.util.Objects;

public class Card {
//has-a or (association)
	
	private Rank rank;
	private CardSuits cardsuits;


public Card() {}
public Card(CardSuits cardsuits, Rank rank) {
	this.cardsuits = cardsuits;
	this.rank = rank;
}

public int getValue() {
	return this.rank.getValue();
}

public Rank getRank() {
	return rank;
}
public void setRank(Rank rank) {
	this.rank = rank;
}
public CardSuits getCardsuits() {
	return cardsuits;
}
public void setCardsuits(CardSuits cardsuits) {
	this.cardsuits = cardsuits;
}
@Override
public int hashCode() {
	return Objects.hash(cardsuits, rank);
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Card other = (Card) obj;
	return cardsuits == other.cardsuits && rank == other.rank;
}
@Override
public String toString() {
	return "Card [rank=" + rank + ", cardsuits=" + cardsuits + "]";
}



}

