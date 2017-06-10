package br.com.zg.pokerhand.model;

import java.util.List;

public class CardGroup implements CardComparable {

	private List<Card> cards;
	private CardValue value;

	public CardGroup(List<Card> cards) {
		this.cards = cards;
		this.value = cards.get(0).getValue();
	}


	@Override
	public CardValue getValue() {
		return value;
	}

	@Override
	public int size() {
		return cards.size();
	}
}
