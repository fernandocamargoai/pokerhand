package br.com.zg.pokerhand.model;

public class Card implements CardComparable, Comparable<Card>{

	private CardValue value;
	private Suit suit;

	public Card(CardValue value, Suit suit) {
		this.value = value;
		this.suit = suit;
	}

	public CardValue getValue() {
		return value;
	}

	public Suit getSuit() {
		return suit;
	}

	@Override
	public String toString() {
		return value.getValue() + suit.toString();
	}

	@Override
	public int compareTo(Card o) {
		if(value.ordinal() != o.value.ordinal()){
			return o.value.ordinal() - value.ordinal();
		}
		return suit.ordinal() - o.suit.ordinal();
	}

	@Override
	public int size() {
		return 1;
	}
}
