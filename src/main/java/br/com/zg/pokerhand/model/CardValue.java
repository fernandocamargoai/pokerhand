package br.com.zg.pokerhand.model;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public enum CardValue {

	TWO('2'),
	THREE('3'),
	FOUR('4'),
	FIVE('5'),
	SIX('6'),
	SEVEN('7'),
	EIGHT('8'),
	NINE('9'),
	TEN('T'),
	J('J'),
	Q('Q'),
	K('K'),
	A('A');

	private char value;

	private static final Map<Character, CardValue> charToCard;

	static {
		charToCard = Arrays.stream(CardValue.values())
				.collect(Collectors.toMap(card -> card.value, card -> card));
	}

	CardValue(char value) {
		this.value = value;
	}

	public char getValue() {
		return value;
	}

	public static CardValue valueOf(char card){
		return charToCard.get(card);
	}
}
