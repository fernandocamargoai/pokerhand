package br.com.zg.pokerhand.recognizer;

import br.com.zg.pokerhand.model.Card;
import br.com.zg.pokerhand.model.CardComparable;
import br.com.zg.pokerhand.model.Category;

import java.util.List;

public class FourOfAKindRecognizer extends Recognizer {

	@Override
	public Result recognizes(List<Card> cards) {
		List<CardComparable> cardComparables = groupCards(cards);
		return countGroupsOfSize(cardComparables, 4) == 1 ? new Result(Category.FOUR_OF_A_KIND, cardComparables) : null;
	}

}
