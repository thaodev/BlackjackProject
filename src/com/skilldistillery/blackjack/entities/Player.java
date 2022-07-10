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
	
	public int checkDeckSize() {
		return hand.deckSize();
	}	
	public void displayCards() {
		List<Card> cardsInHand = new ArrayList<>();
		cardsInHand.addAll(hand.displayCards());
		for (int i = 0; i < cardsInHand.size(); i++) {
			System.out.println(cardsInHand.get(i));
		}
	}

	public List<Card> cardsInHand() {
		return hand.displayCards();
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
