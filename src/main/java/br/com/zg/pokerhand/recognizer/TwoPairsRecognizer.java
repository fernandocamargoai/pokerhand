package br.com.zg.pokerhand.recognizer;

import br.com.zg.pokerhand.model.Card;
import br.com.zg.pokerhand.model.CardComparable;
import br.com.zg.pokerhand.model.Category;

import java.util.List;

public class TwoPairsRecognizer extends Recognizer {

	@Override
	public Result recognizes(List<Card> cards) {
		List<CardComparable> cardComparables = groupCards(cards);
		return countGroupsOfSize(cardComparables, 2) == 2 ? new Result(Category.TWO_PAIRS, cardComparables) : null;
	}

}
