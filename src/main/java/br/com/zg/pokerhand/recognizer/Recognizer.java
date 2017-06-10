package br.com.zg.pokerhand.recognizer;

import br.com.zg.pokerhand.model.*;
import br.com.zg.pokerhand.model.comparator.CardComparableComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class Recognizer {

	public abstract Result recognizes(List<Card> cards);

	protected List<CardComparable> groupCards(List<Card> cards) {
		List<CardComparable> cardComparables = new ArrayList<>();

		Map<CardValue, List<Card>> groups = cards.stream().collect(Collectors.groupingBy(Card::getValue));

		for (Map.Entry<CardValue, List<Card>> entry : groups.entrySet()){
			List<Card> groupOfCards = entry.getValue();
			if(groupOfCards.size() == 1){
				cardComparables.add(groupOfCards.get(0));
			}
			else{
				cardComparables.add(new CardGroup(groupOfCards));
			}
		}

		Collections.sort(cardComparables, new CardComparableComparator());

		return cardComparables;
	}

	protected long countGroupsOfSize(List<CardComparable> cardComparables, int size){
		return cardComparables.stream()
				.filter(cardComparable -> cardComparable.size() == size)
				.count();
	}

	protected boolean isFlush(List<Card> cards){
		return cards.stream().map(Card::getSuit).allMatch(naipe -> naipe == cards.get(0).getSuit());
	}

	protected boolean isStraight(List<Card> cards){
		Card currentCard = cards.get(0);
		for(int i=1; i<cards.size(); i++){
			Card card = cards.get(i);
			if(currentCard.getValue().ordinal() -1 != card.getValue().ordinal()){
				return false;
			}
			currentCard = card;
		}
		return true;
	}

	public static class Result {
		private Category category;
		private List<? extends CardComparable> cardComparables;

		public Result(Category category, List<? extends CardComparable> cardComparables) {
			this.category = category;
			this.cardComparables = cardComparables;
		}

		public Category getCategory() {
			return category;
		}

		public List<? extends CardComparable> getCardComparables() {
			return cardComparables;
		}
	}
}
