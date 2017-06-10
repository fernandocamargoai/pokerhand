package br.com.zg.pokerhand.recognizer;

import br.com.zg.pokerhand.model.Card;
import br.com.zg.pokerhand.model.CardValue;
import br.com.zg.pokerhand.model.Category;

import java.util.List;

public class RoyalFlushRecognizer extends Recognizer {

	@Override
	public Result recognizes(List<Card> cards) {
		return isFlush(cards) && isStraight(cards) &&
				cards.get(0).getValue() == CardValue.A
				? new Result(Category.ROYAL_FLUSH, cards) : null;
	}

}
