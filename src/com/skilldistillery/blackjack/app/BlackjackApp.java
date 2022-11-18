package com.skilldistillery.blackjack.app;

import java.util.Scanner;

import com.skilldistillery.cardgame.BlackjackHand;
import com.skilldistillery.cards.Deck;
import com.skilldistillery.players.Dealer;
import com.skilldistillery.players.Player;

public class BlackjackApp {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		BlackjackApp app = new BlackjackApp();
		app.run(scanner);
	}

	public void run(Scanner scanner) {
		System.out.println("Welcome to Blackjack.");
		while (true) {

			Dealer dealer = new Dealer(new Deck(), new BlackjackHand());
			Deck deck = dealer.getDeck();
			Player player = new Player(new BlackjackHand());
			while (deck.checkDeckSize() >= 10) {
				dealer.getHand().clear();
				player.getHand().clear();
				dealer.shuffle(deck);
				System.out.println("Player is dealt: " + player.getHand().addCard(dealer.dealCard()).toString());
				System.out.println("Player hand total: " + player.getHand().getHandValue());
				dealer.getHand().addCard(dealer.dealCard()).toString();
				System.out.println("Dealer is dealt: a card face down.");
				System.out.println("Dealer hand total: unknown");
				System.out.println("Player is dealt: " + player.getHand().addCard(dealer.dealCard()).toString());
				System.out.println("Player hand total: " + player.getHand().getHandValue());
				System.out.println("Dealer is dealt: " + dealer.getHand().addCard(dealer.dealCard()).toString());
				System.out.println("Dealer hand total: " + dealer.revealedDealerCardVal()
						+ " plus unknown value of face down card.");
				System.out.println();
				if (dealer.getHand().getHandValue() == 21) {
					System.out.println("Dealer has a score of: " + dealer.getHand().getHandValue());
					System.out.println("Dealer: Blackjack! Dealer Wins!");
				} else if (player.getHand().getHandValue() == 21) {
					System.out.println("Player: Blackjack! Player Wins!");
					System.out.println();
				} else {
					while (true) {
						System.out.println();
						System.out.println("Hit or Stand: ");
						System.out.println();
						String userInput = scanner.nextLine();
						if (userInput.equalsIgnoreCase("Hit")) {
							System.out.println("Player: 'Hit me!'");
							System.out.println(
									"Player is dealt: " + player.getHand().addCard(dealer.dealCard()).toString());
							System.out.println("Player score is now: " + player.getHand().getHandValue());
							if (player.getHand().getHandValue() > 21) {
								System.out.println("Player: Bust! Player lost this round.");
								System.out.println("Dealer wins!");
								System.out.print("Would you like to play another round? (y/n): ");
								userInput = scanner.nextLine();
								if (userInput.equals("y")) {
									break;
								} else if (userInput.equals("n")) {
									System.out.println();
									exitProgram();
								}

							} else {
								continue;
							}

						} else if (userInput.equalsIgnoreCase("Stand")) {
							System.out.println("Player: 'Stand'");

							System.out.println("Dealer reveals face down card: " + dealer.hiddenDealerCardVal());
							System.out.println("Dealer score is now: " + dealer.getHand().getHandValue());
							while (true) {
								if (dealer.getHand().getHandValue() >= 17 && dealer.getHand().getHandValue() <= 21) {
									System.out.println("Dealer score is now: " + dealer.getHand().getHandValue());
									compareCards(player.getHand().getHandValue(), dealer.getHand().getHandValue());
									System.out.println();
									break;
								} else if (dealer.getHand().getHandValue() < 17) {

									while (dealer.getHand().getHandValue() < 17) {
										if (!(deck.checkDeckSize() >= 10)) {
											break;
										}
										System.out.println("Dealer is dealt: "
												+ dealer.getHand().addCard(dealer.dealCard()).toString());
										System.out.println("Dealer score is now: " + dealer.getHand().getHandValue());
										if (dealer.getHand().getHandValue() > 21) {
											System.out.println("Dealer: Bust!");
											System.out.println("Dealer loses this round.");
											System.out.println("Player wins!");
											break;

										}

									}
									compareCards(player.getHand().getHandValue(), dealer.getHand().getHandValue());
									playAnother(scanner);
								}

							}

						}
						playAnother(scanner);
						break;
					}

				}

			}
			System.out.println("Not enough cards in deck to play another round. Start a new game? (y/n)");
			String userInput = scanner.nextLine();
			if (userInput.equals("y")) {
				continue;
			} else {
				break;
			}
		}
		exitProgram();
	}

	public void compareCards(int playerHand, int dealerHand) {
	  if (playerHand == dealerHand) {
		System.out.println("This round ended in a tie!");
	}
	else if (playerHand > dealerHand) {
			System.out.println("Player wins!");
		} else if (dealerHand > 21) {
			System.out.println("Player wins!");
		} else if (playerHand == 21) {
			System.out.println("Player Wins!!!");
		} else if (playerHand < dealerHand) {
			System.out.println("Dealer wins! Better Luck Next Time!");
		} else if (playerHand > 21) {
			System.out.println("Dealer wins! Better Luck Next Time!");
		} else if (dealerHand == 21) {
			System.out.println("Dealer wins! Better Luck Next Time!");}
	}

	public void exitProgram() {
		System.out.println("Thanks for playing!");
		System.exit(0);
	}

	public void playAnother(Scanner scanner) {

		String userInput = "";
		System.out.print("Would you like to play another round? (y/n): ");
		userInput = scanner.nextLine();
		while (true) {
			if (userInput.equals("y")) {
				System.out.println();
				break;
			} else if (userInput.equals("n")) {
				System.out.println();
				exitProgram();
			}

		}

	}

}
