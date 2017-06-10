package br.com.zg.pokerhand.model

import spock.lang.Specification
import spock.lang.Unroll

import static br.com.zg.pokerhand.model.Result.LOSS
import static br.com.zg.pokerhand.model.Result.WIN

class PokerHandSpec extends Specification {

	@Unroll
	def "Comparação de duas pokerhands retorna o resultado correto"(){
		given:
		PokerHand pokerHand1 = new PokerHand(hand1)
		PokerHand pokerHand2 = new PokerHand(hand2)

		expect:
		pokerHand1.compareWith(pokerHand2) == result

		where:
		hand1            | hand2            || result
		"TC TH 5C 5H KH" | "9C 9H 5C 5H AC" || WIN
		"TS TD KC JC 7C" | "JS JC AS KC TD" || LOSS
		"7H 7C QC JS TS" | "7D 7C JS TS 6D" || WIN
		"5S 5D 8C 7S 6H" | "7D 7S 5S 5D JS" || LOSS
		"AS AD KD 7C 3D" | "AD AH KD 7C 4S" || LOSS
		"TS JS QS KS AS" | "AC AH AS AS KS" || WIN
		"TS JS QS KS AS" | "TC JS QC KS AC" || WIN
		"TS JS QS KS AS" | "QH QS QC AS 8H" || WIN
		"AC AH AS AS KS" | "TC JS QC KS AC" || WIN
		"AC AH AS AS KS" | "QH QS QC AS 8H" || WIN
		"TC JS QC KS AC" | "QH QS QC AS 8H" || WIN
		"7H 8H 9H TH JH" | "JH JC JS JD TH" || WIN
		"7H 8H 9H TH JH" | "4H 5H 9H TH JH" || WIN
		"7H 8H 9H TH JH" | "7C 8S 9H TH JH" || WIN
		"7H 8H 9H TH JH" | "TS TH TD JH JD" || WIN
		"7H 8H 9H TH JH" | "JH JD TH TC 4C" || WIN
		"JH JC JS JD TH" | "4H 5H 9H TH JH" || WIN
		"JH JC JS JD TH" | "7C 8S 9H TH JH" || WIN
		"JH JC JS JD TH" | "TS TH TD JH JD" || WIN
		"JH JC JS JD TH" | "JH JD TH TC 4C" || WIN
		"4H 5H 9H TH JH" | "7C 8S 9H TH JH" || WIN
		"4H 5H 9H TH JH" | "TS TH TD JH JD" || LOSS
		"4H 5H 9H TH JH" | "JH JD TH TC 4C" || WIN
		"7C 8S 9H TH JH" | "TS TH TD JH JD" || LOSS
		"7C 8S 9H TH JH" | "JH JD TH TC 4C" || WIN
		"TS TH TD JH JD" | "JH JD TH TC 4C" || WIN
	}
}
