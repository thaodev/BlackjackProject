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

		Deck deck = new Deck();
		deck.shuffleCard();
		Player player = new Player();
		Dealer dealer = new Dealer();

		// Start dealing
		// Player gets two cards
		player.hit(deck.dealCard());
		player.hit(deck.dealCard());

		// Dealer gets two card
		dealer.hit(deck.dealCard());
		dealer.hit(deck.dealCard());
		boolean endRound = false;

		/* Player's turn */

		// Dealer's visible cards
		dealer.checkDeckSize();
		dealer.displayCards();
		if (dealer.getHandValue() > 17) {
			System.out.println("Dealer doesn't allow to take any more card per the house's rule!!!");
		}
		System.out.println();

		// Player's cards
		player.checkDeckSize();
		player.displayCards();

		while (!endRound) {
			System.out.println();
			String hitOrStayDecision = "";

			if (!dealer.isBust() && !dealer.isBlackjack()) {

				System.out.println("Player's move: (H or S)");
				hitOrStayDecision = sc.nextLine();
				if (hitOrStayDecision.toLowerCase().equals("hit") || hitOrStayDecision.toLowerCase().equals("h")) {
					Card cardDrawn = deck.dealCard();
					player.hit(cardDrawn);
					System.out.println("Player draw a: " + cardDrawn + " - value of " + cardDrawn.getValue());
					player.checkDeckSize();
					if (player.isBust()) {
						System.out.println("Player's current score is " + player.getHandValue() + ". You are busted");
						endRound = true;
					} else {
						player.displayCards();
					}
				} else {
					System.out.println("Player chose to stay. Nothing change in your score!");

				}
				if (player.isBlackjack()) {
					endRound = true;
				}
			}

			/* Dealer's turn */
			System.out.println();
			if (!player.isBust() && dealer.getHandValue() < 17) {
				System.out.println("Dealer's move: (H or S)");
				hitOrStayDecision = sc.nextLine();
				if (hitOrStayDecision.toLowerCase().equals("hit") || hitOrStayDecision.toLowerCase().equals("h")) {
					Card cardDrawn = deck.dealCard();
					dealer.hit(cardDrawn);
					System.out.println("Player draw a: " + cardDrawn + " - value of " + cardDrawn.getValue());
					dealer.checkDeckSize();
					if (dealer.isBust()) {
						System.out.println("Player's current score is " + dealer.getHandValue() + ". You are busted");
						endRound = true;

					} else {
						dealer.displayCards();
					}
				} else {
					System.out.println("Dealer chose to stay. Nothing change in your score!");

				}
			}
		}
		System.out.println("=====================================");
		System.out.println("OUTCOME OF THE GAME");
		dealer.checkDeckSize();
		System.out.println("Dealer's score is: " + dealer.getHandValue());
		System.out.println();
		player.checkDeckSize();
		//player.displayCards();
		System.out.println("**************************************");
		if (player.isBlackjack()) {
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
		System.out.println("**************************************");

	}

}
