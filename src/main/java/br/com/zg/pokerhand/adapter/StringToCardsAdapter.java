package br.com.zg.pokerhand.adapter;

import br.com.zg.pokerhand.model.Card;
import br.com.zg.pokerhand.model.CardValue;
import br.com.zg.pokerhand.model.Suit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StringToCardsAdapter {

	public static List<Card> toCards(String cardsString){
		String[] cards = cardsString.split(" ");
		if(cards.length != 5){
			throw new RuntimeException("PokerHand inválida!");
		}

		List<Card> cardList = new ArrayList<>();
		for(String card : cards){
			CardValue cardValue = CardValue.valueOf(card.charAt(0));
			Suit suit = Suit.valueOf(new String(new char[]{card.charAt(1)}));
			cardList.add(new Card(cardValue, suit));
		}

		Collections.sort(cardList);

		return cardList;
	}

}
