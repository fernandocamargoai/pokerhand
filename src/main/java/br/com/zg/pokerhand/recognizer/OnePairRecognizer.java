package br.com.zg.pokerhand.recognizer;

import br.com.zg.pokerhand.model.Card;
import br.com.zg.pokerhand.model.CardComparable;
import br.com.zg.pokerhand.model.Category;

import java.util.List;

public class OnePairRecognizer extends Recognizer {

	@Override
	public Result recognizes(List<Card> cards) {
		List<CardComparable> cardComparables = groupCards(cards);
		return countGroupsOfSize(cardComparables, 2) == 1 ? new Result(Category.ONE_PAIR, cardComparables) : null;
	}

}
