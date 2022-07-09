package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.List;

public class Player {
	private BlackjackHand hand;
	
	public Player() {
		hand = new BlackjackHand();
	}
	
	public void hit(Card card) {
		hand.addCard(card);
		
	}
	
	public void checkDeckSize() {
		System.out.println("Player currently has " + hand.deckSize() + " cards.");
	}	
	public void displayCards() {
		int sum = 0;
		List<Card> cardsInHand = new ArrayList<>();
		cardsInHand.addAll(hand.displayCards());
		for (int i = 0; i < cardsInHand.size(); i++) {
			sum += cardsInHand.get(i).getValue();
			System.out.println(cardsInHand.get(i));
		}
		System.out.println("Total current value of player's cards is " + sum);
	}
	
	public int getHandValue() {
		int score = 0;
		score = hand.getHandValue();
		return score;
	}
	
	public boolean isBust() {
		return hand.isBust();
	}
	
	public boolean isBlackjack() {
		return hand.isBlackjack();
	}

}
