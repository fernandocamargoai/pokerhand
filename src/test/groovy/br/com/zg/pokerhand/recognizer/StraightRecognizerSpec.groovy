package br.com.zg.pokerhand.recognizer

import br.com.zg.pokerhand.adapter.StringToCardsAdapter
import br.com.zg.pokerhand.model.Card
import spock.lang.Specification
import spock.lang.Unroll

import static br.com.zg.pokerhand.model.Category.STRAIGHT

class StraightRecognizerSpec extends Specification {

	@Unroll
	def "Deve categorizar como sequencia apenas pokerhands corretas"(){
		given:
		List<Card> cards = StringToCardsAdapter.toCards(hand)
		and:
		StraightRecognizer sequenciaRecognizer = new StraightRecognizer();

		expect:
		sequenciaRecognizer.recognizes(cards) == category

		where:
		hand             || category
		"8C 7S 6H 5S 5D" || null
		"AC KS QC JS TC" || STRAIGHT
		"TC TH 5C 5H KH" || null
	}
}
