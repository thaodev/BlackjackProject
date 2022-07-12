package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.List;

public class Dealer {
	
	private BlackjackHand hand;
	
	public Dealer() {
		hand = new BlackjackHand();
	}

	public void hit(Card card) {
		
		hand.addCard(card);
	}
	
	public int checkDeckSize() {
		return hand.deckSize();
	}
	
	public Card dealerDealCard(Deck deck) {
		Card card = deck.dealCard();
		return card;
	}
	
	public int getHandValue() {
		return hand.getHandValue();
	}
	public void displayCards() {
		List<Card> cardsInHand = new ArrayList<>();
		cardsInHand.addAll(hand.displayCards());
		for (int i = 1; i < cardsInHand.size(); i++) {
			System.out.println(cardsInHand.get(i));
		}
	}

	public int getVisibleCardsValue() {
		int sum = 0;
		List<Card> cardsInHand = new ArrayList<>();
		cardsInHand.addAll(hand.displayCards());
		for (int i = 1; i < cardsInHand.size(); i++) {
			sum += cardsInHand.get(i).getValue();
		}
		return sum;
	}
	
	public boolean isBust() {
		return hand.isBust();
	}
	
	public boolean isBlackjack() {
		return hand.isBlackjack();
	}
	
	


}
