package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.List;

public class BlackjackHand extends Hand{

	public BlackjackHand() {
		cards = new ArrayList<>();
	}

	@Override
	public int getHandValue() {
		int sum = 0;
		for (Card card : cards) {
			if(card.getRank() == Rank.ACE && sum > 10) {
				sum += card.getSecondValue();
			} else {
				sum += card.getValue();
			}
		}
		return sum;
	}
	
	public boolean isBlackjack() {
		boolean isHandBlackjack = true;
		List<Rank> listOfRank = getRankInCards(cards);
		if (cards.size() == 2 && listOfRank.contains(Rank.ACE)  && getHandValue() == 21 ) {
			isHandBlackjack = true;
		} else {
			isHandBlackjack =  false;
		}
		
		return isHandBlackjack;
		
	}
	
	public boolean isBust() {
		if (getHandValue() > 21) {
			return true;
		} else {
			return false;
		}
		
	}
	
	public List<Rank> getRankInCards(List<Card> cards){
		List<Rank> listOfRank = new ArrayList<>();
		for (Card card : cards) {
			listOfRank.add(card.getRank());
		}
		return listOfRank;
	}

}
