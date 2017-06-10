package br.com.zg.pokerhand.recognizer;

import br.com.zg.pokerhand.model.Card;
import br.com.zg.pokerhand.model.Category;

import java.util.List;

public class FlushRecognizer extends Recognizer {

	@Override
	public Result recognizes(List<Card> cards) {
		return isFlush(cards) ? new Result(Category.FLUSH, cards) : null;
	}

}
