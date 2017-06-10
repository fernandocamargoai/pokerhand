package br.com.zg.pokerhand.model.comparator;

import br.com.zg.pokerhand.model.CardComparable;

import java.util.Comparator;

public class CardComparableComparator implements Comparator<CardComparable> {
	@Override
	public int compare(CardComparable c1, CardComparable c2) {
		if(c1.size() != c2.size()){
			return c2.size() - c1.size();
		}
		return c2.getValue().ordinal() - c1.getValue().ordinal();
	}
}
