package com.skilldistillery.blackjack.app;

import java.util.Scanner;

import com.skilldistillery.blackjack.entities.Card;
import com.skilldistillery.blackjack.entities.Dealer;
import com.skilldistillery.blackjack.entities.Deck;
import com.skilldistillery.blackjack.entities.Player;

public class BlackJackApp {
	private Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		BlackJackApp app = new BlackJackApp();
		app.launch();
	}

	public void launch() {
		String blackjack = ".-------." + ".-------." + "\n" + "| ** ** |" + "| ** ** |" + "\n" + "|*  *  *|"
				+ "|*  *  *|" + "\n" + "| *   * |" + "| *   * |" + "\n" + "|   *   |" + "|   *   |" + "\n" + "|   B   |"
				+ "|   J   |" + "\n" + "'-------'" + "'-------'";

		System.out.println(blackjack);

		Deck deck = new Deck();
		deck.shuffleCard();
		System.out.println("-------------------");
		System.out.println("| Deck's size: " + deck.deckSize() + " |");
		System.out.println("-------------------");
		Player player = new Player();
		Dealer dealer = new Dealer();

		boolean isPlayerRound = true;
		//boolean isDealerRound = true;

		// Start dealing
		// Player gets two cards
		player.receiveCard(dealer.dealerDealCard(deck));
		player.receiveCard(dealer.dealerDealCard(deck));

		// Dealer gets two card
		dealer.hit(deck.dealCard());
		dealer.hit(deck.dealCard());

		// Dealer's visible cards
		System.out.println("Dealer currently has " + dealer.checkDeckSize() + " cards");
		dealer.displayCards();
		System.out.println("Dealer's visible score is " + dealer.getVisibleCardsValue());

		System.out.println();

		// Player's cards
		System.out.println("Player currently has " + player.checkDeckSize() + " cards");
		player.displayCards();
		System.out.println("Player's score is " + player.getHandValue());
		String hitOrStayDecision = "";

		System.out.println("-------------------");
		System.out.println("| Deck's size: " + deck.deckSize() + " |");
		System.out.println("-------------------");

		/* Player's turn */
		while (isPlayerRound) {

			if (deck.deckSize() > 0) {
				System.out.println();
				if (player.getHandValue() == 21) {
					isPlayerRound = false;
				}
//				else if (player.isBust()) {
//					isPlayerRound = false;
//				}
				else if (!dealer.isBust() && !dealer.isBlackjack()) {
					System.out.println("Player's move: (H or S)");
					hitOrStayDecision = sc.nextLine();
					if (hitOrStayDecision.toLowerCase().equals("hit") || hitOrStayDecision.toLowerCase().equals("h")) {
						Card cardDrawn = dealer.dealerDealCard(deck);
						player.receiveCard(cardDrawn);
						System.out.println("Player draw a: " + cardDrawn + " - value of " + cardDrawn.getValue());
						System.out.println("Player has " + player.checkDeckSize() + " cards.");
						System.out.println("-------------------");
						System.out.println("| Deck's size: " + deck.deckSize() + " |");
						System.out.println("-------------------");
						if (player.isBust()) {
							System.out
									.println("Player's current score is " + player.getHandValue() + ". You are busted");
							isPlayerRound = false;
						} else {
							player.displayCards();
							System.out.println("Player's score is " + player.getHandValue());
						}

					} else {
						System.out.println("Player chose to stay. Nothing change in your score!");
						isPlayerRound = false;

					}
					if (player.isBlackjack()) {
						isPlayerRound = false;
					}
				}
			} else {
				System.out.println("No more card left!");
				isPlayerRound = false;
			}

		}
		/* Dealer's turn */
		System.out.println();
		while (dealer.getHandValue() < 17 && !player.isBust() && !dealer.isBust() && deck.deckSize() > 0 ) {
			if (deck.deckSize() > 0) {
				System.out.println("Dealer is hitting: ");
				Card cardDrawn = deck.dealCard();
				dealer.hit(cardDrawn);
				System.out.println("Dealer draw a: " + cardDrawn + " - value of " + cardDrawn.getValue());
				dealer.checkDeckSize();
				if (dealer.isBust()) {
					System.out.println("Dealer's current score is " + dealer.getHandValue() + ". You are busted");
				} else {
					dealer.displayCards();
					System.out.println("Dealer's visible score is " + dealer.getVisibleCardsValue());
					if (dealer.getHandValue() > 17) {
						System.out.println("Dealer isn't allowed to take more card per house's rule!");
					}
				}
				System.out.println("-------------------");
				System.out.println("| Deck's size: " + deck.deckSize() + " |");
				System.out.println("-------------------");
			} else {
				System.out.println("No more card left!");
			}
		}
		System.out.println("=====================================");
		System.out.println("OUTCOME OF THE GAME");
		System.out.println("-------------------");
		System.out.println("Dealer has " + dealer.checkDeckSize() + " cards.");
		System.out.println("Dealer's score is: " + dealer.getHandValue());
		System.out.println();

		System.out.println("Player has " + player.checkDeckSize() + " cards.");
		System.out.println("Player's score is: " + player.getHandValue());
		System.out.println("***************************************");
		if (player.isBlackjack())
		{
			System.out.println("Player is blackjack!!!!");
		}
		if (dealer.isBlackjack()) {
			System.out.println("Dealer is blackjack!!!!");
		}
		if (!player.isBust() && !dealer.isBust()) {
			if (player.getHandValue() > dealer.getHandValue()) {
				System.out.println("Player is the winner!");
			} else if (player.getHandValue() < dealer.getHandValue()) {
				System.out.println("Dealer is the winner!");
			} else {
				System.out.println("Dealer and Player has same score!");
			}
		} else if (player.isBust()) {
			System.out.println("Player is busted. Dealer is the winner!");
		} else {
			System.out.println("Dealer is busted. Player is the winner!");
		}
		System.out.println("***************************************");

	}

}
