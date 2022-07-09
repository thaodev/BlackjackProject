package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.List;

public class BlackjackHand extends Hand{
	//private List<Card> cardsInHand;
	
	

	public BlackjackHand() {
		cards = new ArrayList<>();
	}

	@Override
	public int getHandValue() {
		int sum = 0;
		for (Card card : cards) {
			sum += card.getValue();
		}
		return sum;
	}
	
	public boolean isBlackjack() {
		if (getHandValue() == 21) {
			return true;
		} else {
			return false;
		}
		
	}
	
	public boolean isBust() {
		if (getHandValue() > 21) {
			return true;
		} else {
			return false;
		}
		
	}

}
