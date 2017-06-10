package br.com.zg.pokerhand.recognizer

import br.com.zg.pokerhand.adapter.StringToCardsAdapter
import br.com.zg.pokerhand.model.Card
import spock.lang.Specification
import spock.lang.Unroll

import static br.com.zg.pokerhand.model.Category.ONE_PAIR


class OnePairRecognizerSpec extends Specification {

	@Unroll
	def "Deve categorizar como par apenas pokerhands corretas"(){
		given:
		List<Card> cards = StringToCardsAdapter.toCards(hand)
		and:
		OnePairRecognizer parRecognizer = new OnePairRecognizer();

		expect:
		parRecognizer.recognizes(cards) == category

		where:
		hand             || category
		"TC TH 5C 5H KH" || null
		"JS JC AS KC TD" || ONE_PAIR
		"5S 5D 8C 7S 6H" || ONE_PAIR
		"7H 8H 9H TH JH" || null
	}
}
