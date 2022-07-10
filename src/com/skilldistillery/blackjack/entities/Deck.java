package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Deck {
	private List<Card> deck;
	
	public Deck() {
		deck = createDeck();
	}

	private List<Card> createDeck() {
		List<Card> deck = new ArrayList<>();;
		for(Rank rank : Rank.values())
		{
			for (Suit suit : Suit.values()) {
				deck.add(new Card(suit, rank));
			}
		}
		return deck;
	}
	
	public int deckSize() {
		return deck.size();
	}
	
	
	public Card dealCard() {
		Card card = deck.remove(0);
		return card;
	}
	
	public void shuffleCard() {
		Collections.shuffle(deck);
	}

}
