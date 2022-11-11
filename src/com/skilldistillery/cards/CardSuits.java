package com.skilldistillery.cards;

public enum CardSuits {
HEARTS("Hearts"), SPADES("Spades"), CLUBS("Clubs"), DIAMONDS("Diamonds");


private String name;


CardSuits(String name) {
	this.name = name;
}
@Override
public String toString() {
	return this.name;
}
}




