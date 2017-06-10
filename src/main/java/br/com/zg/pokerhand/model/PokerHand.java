package br.com.zg.pokerhand.model;

import br.com.zg.pokerhand.adapter.StringToCardsAdapter;
import br.com.zg.pokerhand.model.comparator.CardComparableComparator;
import br.com.zg.pokerhand.recognizer.*;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class PokerHand {

	private static final List<Recognizer> recognizers = Arrays.asList(
			new RoyalFlushRecognizer(),
			new StraightFlushRecognizer(),
			new FourOfAKindRecognizer(),
			new FullHouseRecognizer(),
			new FlushRecognizer(),
			new StraightRecognizer(),
			new ThreeOfAKindRecognizer(),
			new TwoPairsRecognizer(),
			new OnePairRecognizer()
	);

	private List<Card> cards;
	private Category category;
	private List<? extends CardComparable> cardComparables;

	public PokerHand(String cardsString){
		this.cards = StringToCardsAdapter.toCards(cardsString);

		for(Recognizer recognizer : recognizers){
			Recognizer.Result result = recognizer.recognizes(cards);

			if(result != null){
				this.category = result.getCategory();
				this.cardComparables = result.getCardComparables();
				break;
			}
		}
		if(category == null){
			this.category = Category.HIGH_HAND;
			this.cardComparables = cards;
		}
	}

	public Result compareWith(PokerHand pokerHand){
		if(this.category.ordinal() > pokerHand.category.ordinal()){
			return Result.WIN;
		}
		else if(this.category.ordinal() > pokerHand.category.ordinal()) {
			return Result.LOSS;
		}
		else {
			Comparator<CardComparable> comparator = new CardComparableComparator();

			for(int i=0; i<cardComparables.size(); i++){
				int result = comparator.compare(cardComparables.get(i), pokerHand.cardComparables.get(i));

				if(result < 0){
					return Result.WIN;
				}
				else if(result > 0){
					return Result.LOSS;
				}
			}

			return Result.DRAW;
		}
	}

	public Category getCategory() {
		return category;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("PokerHand{");
		sb.append("cards=").append(cards);
		sb.append(", category=").append(category);
		sb.append('}');
		return sb.toString();
	}
}
